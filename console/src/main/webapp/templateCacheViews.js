(function(module) {
try {
  module = angular.module('ecoSystemMonitor');
} catch (e) {
  module = angular.module('ecoSystemMonitor', []);
}
module.run(['$templateCache', function($templateCache) {
  $templateCache.put('/views/login.html',
    '<div class="row">\n' +
    '    <div class="col-lg-12">\n' +
    '        <h1 class="page-header">Forms</h1>\n' +
    '    </div>  \n' +
    '    <!-- /.col-lg-12 -->\n' +
    '</div>\n' +
    '<!-- /.row -->\n' +
    '<div class="row">\n' +
    '    <div class="col-lg-12">\n' +
    '        <div class="panel panel-default">\n' +
    '            <div class="panel-heading">\n' +
    '                Basic Form Elements\n' +
    '            </div>\n' +
    '            <div class="panel-body">\n' +
    '                <div class="row">\n' +
    '                    <div class="col-lg-6">\n' +
    '                        <form role="form">\n' +
    '                            <div class="form-group">\n' +
    '                                <label>Text Input</label>\n' +
    '                                <input class="form-control">\n' +
    '                                <p class="help-block">Example block-level help text here.</p>\n' +
    '                            </div>\n' +
    '                            <div class="form-group">\n' +
    '                                <label>Text Input with Placeholder</label>\n' +
    '                                <input class="form-control" placeholder="Enter text">\n' +
    '                            </div>\n' +
    '                            <div class="form-group">\n' +
    '                                <label>Static Control</label>\n' +
    '                                <p class="form-control-static">email@example.com</p>\n' +
    '                            </div>\n' +
    '                            <div class="form-group">\n' +
    '                                <label>File input</label>\n' +
    '                                <input type="file">\n' +
    '                            </div>\n' +
    '                            <div class="form-group">\n' +
    '                                <label>Text area</label>\n' +
    '                                <textarea class="form-control" rows="3"></textarea>\n' +
    '                            </div>\n' +
    '                            <div class="form-group">\n' +
    '                                <label>Checkboxes</label>\n' +
    '                                <div class="checkbox">\n' +
    '                                    <label>\n' +
    '                                        <input type="checkbox" value="">Checkbox 1\n' +
    '                                    </label>\n' +
    '                                </div>\n' +
    '                                <div class="checkbox">\n' +
    '                                    <label>\n' +
    '                                        <input type="checkbox" value="">Checkbox 2\n' +
    '                                    </label>\n' +
    '                                </div>\n' +
    '                                <div class="checkbox">\n' +
    '                                    <label>\n' +
    '                                        <input type="checkbox" value="">Checkbox 3\n' +
    '                                    </label>\n' +
    '                                </div>\n' +
    '                            </div>\n' +
    '                            <div class="form-group">\n' +
    '                                <label>Inline Checkboxes</label>\n' +
    '                                <label class="checkbox-inline">\n' +
    '                                    <input type="checkbox">1\n' +
    '                                </label>\n' +
    '                                <label class="checkbox-inline">\n' +
    '                                    <input type="checkbox">2\n' +
    '                                </label>\n' +
    '                                <label class="checkbox-inline">\n' +
    '                                    <input type="checkbox">3\n' +
    '                                </label>\n' +
    '                            </div>\n' +
    '                            <div class="form-group">\n' +
    '                                <label>Radio Buttons</label>\n' +
    '                                <div class="radio">\n' +
    '                                    <label>\n' +
    '                                        <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>Radio 1\n' +
    '                                    </label>\n' +
    '                                </div>\n' +
    '                                <div class="radio">\n' +
    '                                    <label>\n' +
    '                                        <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">Radio 2\n' +
    '                                    </label>\n' +
    '                                </div>\n' +
    '                                <div class="radio">\n' +
    '                                    <label>\n' +
    '                                        <input type="radio" name="optionsRadios" id="optionsRadios3" value="option3">Radio 3\n' +
    '                                    </label>\n' +
    '                                </div>\n' +
    '                            </div>\n' +
    '                            <div class="form-group">\n' +
    '                                <label>Inline Radio Buttons</label>\n' +
    '                                <label class="radio-inline">\n' +
    '                                    <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline1" value="option1" checked>1\n' +
    '                                </label>\n' +
    '                                <label class="radio-inline">\n' +
    '                                    <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline2" value="option2">2\n' +
    '                                </label>\n' +
    '                                <label class="radio-inline">\n' +
    '                                    <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline3" value="option3">3\n' +
    '                                </label>\n' +
    '                            </div>\n' +
    '                            <div class="form-group">\n' +
    '                                <label>Selects</label>\n' +
    '                                <select class="form-control">\n' +
    '                                    <option>1</option>\n' +
    '                                    <option>2</option>\n' +
    '                                    <option>3</option>\n' +
    '                                    <option>4</option>\n' +
    '                                    <option>5</option>\n' +
    '                                </select>\n' +
    '                            </div>\n' +
    '                            <div class="form-group">\n' +
    '                                <label>Multiple Selects</label>\n' +
    '                                <select multiple class="form-control">\n' +
    '                                    <option>1</option>\n' +
    '                                    <option>2</option>\n' +
    '                                    <option>3</option>\n' +
    '                                    <option>4</option>\n' +
    '                                    <option>5</option>\n' +
    '                                </select>\n' +
    '                            </div>\n' +
    '                            <button type="submit" class="btn btn-default">Submit Button</button>\n' +
    '                            <button type="reset" class="btn btn-default">Reset Button</button>\n' +
    '                        </form>\n' +
    '                    </div>\n' +
    '                    <!-- /.col-lg-6 (nested) -->\n' +
    '                    <div class="col-lg-6">\n' +
    '                        <h1>Disabled Form States</h1>\n' +
    '                        <form role="form">\n' +
    '                            <fieldset disabled>\n' +
    '                                <div class="form-group">\n' +
    '                                    <label for="disabledSelect">Disabled input</label>\n' +
    '                                    <input class="form-control" id="disabledInput" type="text" placeholder="Disabled input" disabled>\n' +
    '                                </div>\n' +
    '                                <div class="form-group">\n' +
    '                                    <label for="disabledSelect">Disabled select menu</label>\n' +
    '                                    <select id="disabledSelect" class="form-control">\n' +
    '                                        <option>Disabled select</option>\n' +
    '                                    </select>\n' +
    '                                </div>\n' +
    '                                <div class="checkbox">\n' +
    '                                    <label>\n' +
    '                                        <input type="checkbox">Disabled Checkbox\n' +
    '                                    </label>\n' +
    '                                </div>\n' +
    '                                <button type="submit" class="btn btn-primary">Disabled Button</button>\n' +
    '                            </fieldset>\n' +
    '                        </form>\n' +
    '                        <h1>Form Validation States</h1>\n' +
    '                        <form role="form">\n' +
    '                            <div class="form-group has-success">\n' +
    '                                <label class="control-label" for="inputSuccess">Input with success</label>\n' +
    '                                <input type="text" class="form-control" id="inputSuccess">\n' +
    '                            </div>\n' +
    '                            <div class="form-group has-warning">\n' +
    '                                <label class="control-label" for="inputWarning">Input with warning</label>\n' +
    '                                <input type="text" class="form-control" id="inputWarning">\n' +
    '                            </div>\n' +
    '                            <div class="form-group has-error">\n' +
    '                                <label class="control-label" for="inputError">Input with error</label>\n' +
    '                                <input type="text" class="form-control" id="inputError">\n' +
    '                            </div>\n' +
    '                        </form>\n' +
    '                        <h1>Input Groups</h1>\n' +
    '                        <form role="form">\n' +
    '                            <div class="form-group input-group">\n' +
    '                                <span class="input-group-addon">@</span>\n' +
    '                                <input type="text" class="form-control" placeholder="Username">\n' +
    '                            </div>\n' +
    '                            <div class="form-group input-group">\n' +
    '                                <input type="text" class="form-control">\n' +
    '                                <span class="input-group-addon">.00</span>\n' +
    '                            </div>\n' +
    '                            <div class="form-group input-group">\n' +
    '                                <span class="input-group-addon"><i class="fa fa-eur"></i>\n' +
    '                                </span>\n' +
    '                                <input type="text" class="form-control" placeholder="Font Awesome Icon">\n' +
    '                            </div>\n' +
    '                            <div class="form-group input-group">\n' +
    '                                <span class="input-group-addon">$</span>\n' +
    '                                <input type="text" class="form-control">\n' +
    '                                <span class="input-group-addon">.00</span>\n' +
    '                            </div>\n' +
    '                            <div class="form-group input-group">\n' +
    '                                <input type="text" class="form-control">\n' +
    '                                <span class="input-group-btn">\n' +
    '                                    <button class="btn btn-default" type="button"><i class="fa fa-search"></i>\n' +
    '                                    </button>\n' +
    '                                </span>\n' +
    '                            </div>\n' +
    '                        </form>\n' +
    '                    </div>\n' +
    '                    <!-- /.col-lg-6 (nested) -->\n' +
    '                </div>\n' +
    '                <!-- /.row (nested) -->\n' +
    '            </div>\n' +
    '            <!-- /.panel-body -->\n' +
    '        </div>\n' +
    '        <!-- /.panel -->\n' +
    '    </div>\n' +
    '    <!-- /.col-lg-12 -->\n' +
    '</div>');
}]);
})();
