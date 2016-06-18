angular = require('angular');
var ecoSystemMonitor = angular.module('ecoSystemMonitor');
ecoSystemMonitor.service('apiService', ['$http', function($http) {
  this.resourceUrl = {
    'portalServiceApiProtocol': '${portal.service.api.protocol}',
    'portalServiceApiHost': '${portal.service.api.host}',
    'portalServiceApiPort': '${portal.service.api.port}',
    'validateCredentials': '/sso/user/login',
    'getComponentStatus': '/components/status',
    'getComponentSettings': '/components/settings',
    'updateComponentSettings': '/components/settings',
    'getSystemSettings': '/system/settings',
    'updateSystemSettings': '/system/settings',
    'getSubscriptionDetails': '/components/subscribers?email={{emailId}}&componentId={{id}}',
    'updateSubscription': '/components/subscribe'
  };

  this.portalServiceBaseUrl = this.resourceUrl.portalServiceApiProtocol + '://' + this.resourceUrl.portalServiceApiHost + ':' + this.resourceUrl.portalServiceApiPort;
  this.apiURL = this.portalServiceBaseUrl + '/sd-eco-alerts-api';
}]);