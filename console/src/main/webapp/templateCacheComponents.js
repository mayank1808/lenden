(function(module) {
try {
  module = angular.module('ecoSystemMonitor');
} catch (e) {
  module = angular.module('ecoSystemMonitor', []);
}
module.run(['$templateCache', function($templateCache) {
  $templateCache.put('/components/header.html',
    '<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">\n' +
    '    <div class="navbar-header">\n' +
    '\n' +
    '        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">\n' +
    '            <span class="sr-only">Toggle navigation</span>\n' +
    '            <span class="icon-bar"></span>\n' +
    '            <span class="icon-bar"></span>\n' +
    '            <span class="icon-bar"></span>\n' +
    '        </button>\n' +
    '        <a class="navbar-brand" href="index.html">SB Admin v2.0</a>\n' +
    '    </div>\n' +
    '    <!-- /.navbar-header -->\n' +
    '    <header-notification></header-notification>\n' +
    '\n' +
    '    <sidebar></sidebar>\n' +
    '</nav>\n' +
    '');
}]);
})();

(function(module) {
try {
  module = angular.module('ecoSystemMonitor');
} catch (e) {
  module = angular.module('ecoSystemMonitor', []);
}
module.run(['$templateCache', function($templateCache) {
  $templateCache.put('/components/navigation.html',
    '<div class="navbar-default sidebar" role="navigation">\n' +
    '    <div class="sidebar-nav navbar-collapse">\n' +
    '        <ul class="nav in" id="side-menu">\n' +
    '            <sidebar-search></sidebar-search>\n' +
    '            <li ui-sref-active="active">\n' +
    '                <a ui-sref="dashboard.home"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>\n' +
    '            </li>\n' +
    '            <li ui-sref-active="active">\n' +
    '\n' +
    '                <a ui-sref="dashboard.chart"><i class="fa fa-bar-chart-o fa-fw"></i> Charts<span></span></a>\n' +
    '\n' +
    '            </li>\n' +
    '            <li ui-sref-active="active">\n' +
    '                <a ui-sref="dashboard.table"><i class="fa fa-table fa-fw"></i> Tables</a>\n' +
    '            </li>\n' +
    '            <li ui-sref-active="active">\n' +
    '                <a ui-sref="dashboard.form"><i class="fa fa-edit fa-fw"></i> Forms</a>\n' +
    '            </li>\n' +
    '            <li ng-class="{active: collapseVar==1}">{{dropDown}}\n' +
    '                <a href="" ng-click="check(1)"><i class="fa fa-wrench fa-fw"></i> UI Elements<span\n' +
    '                        class="fa arrow"></span></a>\n' +
    '                <ul class="nav nav-second-level" collapse="collapseVar!=1">\n' +
    '                    <li ui-sref-active="active">\n' +
    '                        <a ui-sref="dashboard.panels-wells">Panels and Wells</a>\n' +
    '                    </li>\n' +
    '                    <li ui-sref-active="active">\n' +
    '                        <a ui-sref="dashboard.buttons">Buttons</a>\n' +
    '                    </li>\n' +
    '                    <li ui-sref-active="active">\n' +
    '                        <a ui-sref="dashboard.notifications">Notifications</a>\n' +
    '                    </li>\n' +
    '                    <li ui-sref-active="active">\n' +
    '                        <a ui-sref="dashboard.typography">Typography</a>\n' +
    '                    </li>\n' +
    '                    <li ui-sref-active="active">\n' +
    '                        <a ui-sref="dashboard.icons"> Icons</a>\n' +
    '                    </li>\n' +
    '                    <li ui-sref-active="active">\n' +
    '                        <a ui-sref="dashboard.grid">Grid</a>\n' +
    '                    </li>\n' +
    '                </ul>\n' +
    '                <!-- /.nav-second-level -->\n' +
    '            </li>\n' +
    '            <li ng-class="{active: collapseVar==2}">\n' +
    '                <a href="" ng-click="check(2)"><i class="fa fa-sitemap fa-fw"></i> Multi-Level Dropdown<span\n' +
    '                        class="fa arrow"></span></a>\n' +
    '                <ul class="nav nav-second-level" collapse="collapseVar!=2">\n' +
    '                    <li>\n' +
    '                        <a href="">Second Level Item</a>\n' +
    '                    </li>\n' +
    '                    <li>\n' +
    '                        <a href="">Second Level Item</a>\n' +
    '                    </li>\n' +
    '                    <li ng-init="third=!third" ng-class="{active: multiCollapseVar==3}">\n' +
    '                        <a href="" ng-click="multiCheck(3)">Third Level <span class="fa arrow"></span></a>\n' +
    '                        <ul class="nav nav-third-level" collapse="multiCollapseVar!=3">\n' +
    '                            <li>\n' +
    '                                <a href="">Third Level Item</a>\n' +
    '                            </li>\n' +
    '                            <li>\n' +
    '                                <a href="">Third Level Item</a>\n' +
    '                            </li>\n' +
    '                            <li>\n' +
    '                                <a href="">Third Level Item</a>\n' +
    '                            </li>\n' +
    '                            <li>\n' +
    '                                <a href="">Third Level Item</a>\n' +
    '                            </li>\n' +
    '\n' +
    '                        </ul>\n' +
    '                        <!-- /.nav-third-level -->\n' +
    '                    </li>\n' +
    '                </ul>\n' +
    '                <!-- /.nav-second-level -->\n' +
    '            </li>\n' +
    '            <li ng-class="{active:collapseVar==4}">\n' +
    '                <a href="" ng-click="check(4)"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span\n' +
    '                        class="fa arrow"></span></a>\n' +
    '                <ul class="nav nav-second-level" collapse="collapseVar!=4">\n' +
    '                    <li ng-class="{active: selectedMenu==\'blank\'}">\n' +
    '                        <a ui-sref="dashboard.blank" ng-click="selectedMenu=\'blank\'">Blank Page</a>\n' +
    '                    </li>\n' +
    '                    <li>\n' +
    '                        <a ui-sref="login">Login Page</a>\n' +
    '                    </li>\n' +
    '                </ul>\n' +
    '                <!-- /.nav-second-level -->\n' +
    '            </li>\n' +
    '            <li><a href="http://www.strapui.com/">Premium Angular Themes</a></li>\n' +
    '        </ul>\n' +
    '    </div>\n' +
    '    <!-- /.sidebar-collapse -->\n' +
    '</div> \n' +
    '\n' +
    '\n' +
    '');
}]);
})();
