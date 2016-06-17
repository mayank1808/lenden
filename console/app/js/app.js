/*global angular */

/**
 * The main Account Management app module
 *
 * @type {angular.Module}
 */

angular = require('angular');
require('angular-route');
require('../compiled/templateCacheViews');
require('../compiled/templateCacheComponents');

var ecoSystemMonitor = angular.module('ecoSystemMonitor', ['ngRoute']);
ecoSystemMonitor.config(['$routeProvider', 'pageConfigProvider', function($routeProvider, pageConfigProvider) {
  for (var i = 0; i < pageConfigProvider.config.length; i++) {
    var config = pageConfigProvider.config[i];
    $routeProvider.when("/" + config.pageHash, {
      templateUrl: "/views/" + config.template + ".html",
      page: config.pageId,
      controller: config.controller
    });
  }
  $routeProvider.otherwise({
    redirectTo: "/home"
  });
}]);

ecoSystemMonitor.run(function($rootScope, $location) {
  // register listener to watch route changes
  $rootScope.$on("$routeChangeStart", function(event, next, current) {
    if (!$rootScope.userLogged) {
      // no logged user, we should be going to #login
      if (next.templateUrl !== "/views/login.html") {
        $location.path("/");
      }
    } else {
      $rootScope.activePage = next.page;
      var permittedRoles = $rootScope.config[$rootScope.activePage];
      if (permittedRoles.indexOf($rootScope.userRole) === undefined) {
        $rootScope.userLogged = false;
        $location.path("/home");
      }
      $rootScope.message = null;
    }
  });
});

$(document).ready(function() {
  angular.element('.moduleContainer').each(function(index, moduleContainer) {
    angular.bootstrap(moduleContainer, angular.element(moduleContainer).data('ngModules'));
  });
});

//Importing required services
require('apiService');
require('pageConfig');
require('loginService');
require('commonRequest');
require('commonService');
require('pageAccessConfig');
require('monitoringService');
require('systemSettingsService');
require('componentSettingsService');

// Importing required directives
require('ui-directives');

// Importing required controllers
require('mainController');
require('loginController');
require('dashboardController');
require('systemConfigurationController');
require('componentConfigurationController');