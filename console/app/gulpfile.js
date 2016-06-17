var gulp = require('gulp'),
    webserver = require('gulp-webserver'),
    del = require('del'),
    exec = require('child_process').exec,
    watch = require('gulp-watch'),
    batch = require('gulp-batch'),
    sass = require('gulp-sass'),
    jshint = require('gulp-jshint'),
    sourcemaps = require('gulp-sourcemaps'),
    spritesmith = require('gulp.spritesmith'),
    browserify = require('browserify'),
    source = require('vinyl-source-stream'),
    buffer = require('vinyl-buffer'),
    uglify = require('gulp-uglify'),
    gutil = require('gulp-util'),
    ngAnnotate = require('browserify-ngannotate'),
    rename = require("gulp-rename"),
    filterProperties = require('gulp-filter-java-properties'),
    zip = require('gulp-zip');

var CacheBuster = require('gulp-cachebust');
var cachebust = new CacheBuster();

var buildDetails = require('./build-details.json');
var serverDetails = require('./server-details.json');

/////////////////////////////////////////////////////////////////////////////////////
//
// cleans the build output
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('clean', function(cb) {
    return del([
        'compiled'
    ], {
        force: true
    }, cb);
});

/////////////////////////////////////////////////////////////////////////////////////
//
// runs bower to install frontend dependencies
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('bower', function() {

    var install = require("gulp-install");

    return gulp.src(['./bower.json'])
        .pipe(install());
});

/////////////////////////////////////////////////////////////////////////////////////
//
// runs sass, creates css source maps
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('build-css', ['clean'], function() {
    return gulp.src('./styles/**/*.css')
        .pipe(sourcemaps.init())
        .pipe(sass())
        .pipe(cachebust.resources())
        .pipe(sourcemaps.write('./maps'))
        .pipe(gulp.dest('./compiled/css'));
});

/////////////////////////////////////////////////////////////////////////////////////
//
// fills in the Angular template cache, to prevent loading the html templates via
// separate http requests
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('build-template-cache', function() {

    var ngHtml2Js = require("gulp-ng-html2js"),
        concat = require("gulp-concat");

    return gulp.src("./views/*.html")
        .pipe(ngHtml2Js({
            moduleName: "ecoSystemMonitor",
            prefix: "/views/"
        }))
        .pipe(concat("templateCacheViews.js"))
        .pipe(gulp.dest("./compiled"));
});

gulp.task('build-component-cache', function() {

    var ngHtml2Js = require("gulp-ng-html2js"),
        concat = require("gulp-concat");

    return gulp.src("./components/*.html")
        .pipe(ngHtml2Js({
            moduleName: "ecoSystemMonitor",
            prefix: "/components/"
        }))
        .pipe(concat("templateCacheComponents.js"))
        .pipe(gulp.dest("./compiled"));
});

/////////////////////////////////////////////////////////////////////////////////////
//
// reads properties and prepare resources file
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('populate-server-details', function() {
    return gulp.src('./js/services/resourceService.js')
        .pipe(filterProperties({
            propertiesPath: gutil.env.buildEnv + '.properties',
            delimiters: ['${*}'] // optional, defaults shown 
        }))
        .pipe(gulp.dest('./tmp/'));
});

gulp.task('rename-resource', ['populate-server-details'], function(cb) {
    gulp.src('./tmp/resourceService.js')
        .pipe(rename('apiService.js'))
        .pipe(gulp.dest('./js/services'));
    return del([
        './tmp'
    ], {
        force: true
    }, cb);
});

/////////////////////////////////////////////////////////////////////////////////////
//
// runs jshint
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('jshint', function() {
    gulp.src('/js/*.js')
        .pipe(jshint())
        .pipe(jshint.reporter('default'));
});

/////////////////////////////////////////////////////////////////////////////////////
//
// Build a minified Javascript bundle - the order of the js files is determined
// by browserify
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('build-js', ['build-template-cache', 'build-component-cache', 'rename-resource', 'jshint'], function() {
    var b = browserify({
        entries: './js/app.js',
        debug: true,
        paths: ['./js/controllers', './js/services', './js/directives'],
        transform: [ngAnnotate]
    });

    return b.bundle()
        .pipe(source('bundle.js'))
        .pipe(buffer())
        .pipe(cachebust.resources())
        .pipe(sourcemaps.init({
            loadMaps: true
        }))
        .pipe(uglify())
        .on('error', gutil.log)
        .pipe(sourcemaps.write('./'))
        .pipe(gulp.dest('./compiled/js/'));
});

/////////////////////////////////////////////////////////////////////////////////////
//
// Copy library js files as it is in target
//
/////////////////////////////////////////////////////////////////////////////////////
gulp.task('copy-js-libs', ['clean'], function() {
    return gulp.src('./js/lib/*.js')
        .pipe(gulp.dest('./compiled/js/lib/'));
});

/////////////////////////////////////////////////////////////////////////////////////
//
// Copy sample response json files as it is in target
//
/////////////////////////////////////////////////////////////////////////////////////
gulp.task('copy-sample-json', function() {
    return gulp.src('./js/sampleResponse/*.json')
        .pipe(gulp.dest('./compiled/js/sampleResponse/'));
});

/////////////////////////////////////////////////////////////////////////////////////
//
// full build (except sprites), applies cache busting to the main page css and js bundles
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('build', ['build-css', 'copy-images', 'copy-js-libs', 'build-js'], function() {
    return gulp.src('index.html')
        .pipe(cachebust.references())
        .pipe(gulp.dest('compiled'));
});

/////////////////////////////////////////////////////////////////////////////////////
//
// watches file system and triggers a build when a modification is detected
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('watch', function() {
    watch(['./index.html', './views/*.html', './components/*.html', './styles/*.*css', './js/**/*.js', '!./js/**/apiService.js'], batch(function(events, done) {
        gulp.start('copy-to-server', done);
    }));
});

/////////////////////////////////////////////////////////////////////////////////////
//
// launch a build upon modification and publish it to a running server
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('dev', ['watch']);

gulp.task('copy-to-server', ['build'], function(cb) {
    exec('./copyScript.sh ' + serverDetails.path, function(err, stdout, stderr) {
        cb(err);
    });
});

/////////////////////////////////////////////////////////////////////////////////////
//
// generates a sprite png and the corresponding sass sprite map.
// This is not included in the recurring development build and needs to be run separately
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('sprite', ['copy-images'], function() {

    var spriteData = gulp.src('./images/*.png')
        .pipe(spritesmith({
            imgName: 'todo-sprite.png',
            cssName: '_todo-sprite.scss',
            algorithm: 'top-down',
            padding: 5
        }));

    spriteData.css.pipe(gulp.dest('./compiled/images'));
    spriteData.img.pipe(gulp.dest('./compiled/images'))
});

gulp.task('copy-images', ['clean'], function() {

    return gulp.src('./images/*')
        .pipe(gulp.dest('./compiled/images'));
});

/////////////////////////////////////////////////////////////////////////////////////
//
// installs and builds everything, including sprites
//
/////////////////////////////////////////////////////////////////////////////////////

gulp.task('default', ['clean', 'build']);

/////////////////////////////////////////////////////////////////////////////////////
//
// installs and builds zip from everything
//
/////////////////////////////////////////////////////////////////////////////////////
gulp.task('build-zip', ['build'], function() {
    return gulp.src('compiled/**/*')
        .pipe(zip(buildDetails.name + '-' + buildDetails.version + '.' + gutil.env.buildversion + '.zip'))
        .pipe(gulp.dest('./build'));
});