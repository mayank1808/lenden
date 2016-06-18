var ecoSystemMonitor = angular.module('ecoSystemMonitor');
ecoSystemMonitor.service('PageConfig');
ecoSystemMonitor.provider('pageConfig', function PageConfigProvider() {
  this.config = [{
    'name': 'Dashboard',
    'pageId': 'dashboard',
    'directLink': true,
    'pageHash': 'dashboard',
    'template': 'dashboard',
    'controller': 'dashboardController'
  },{
    'name': 'Login',
    'pageId': 'login',
    'directLink': false,
    'pageHash': '',
    'template': 'login',
    'controller': 'loginController'
  },{
    'name': 'Component Configuration',
    'pageId': 'componentConfiguration',
    'directLink': true,
    'pageHash': 'componentConfiguration',
    'template': 'componentConfiguration',
    'controller': 'componentConfigurationController'
  },{
    'name': 'System Configuration',
    'pageId': 'systemConfiguration',
    'directLink': true,
    'pageHash': 'systemConfiguration',
    'template': 'systemConfiguration',
    'controller': 'systemConfigurationController'
  }];

  this.$get = function pageConfigFactory() {
    return this.config;
  };
});