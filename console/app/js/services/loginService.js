angular = require('angular');
var ecoSystemMonitor = angular.module('ecoSystemMonitor');
ecoSystemMonitor.service('LoginService', ['$http', 'commonRequest', 'apiService', function($http, commonRequest, apiService) {
  this.validateCredentials = function(loginDetails, successCallback, errorCallback) {
    var url = apiService.apiURL + apiService.resourceUrl.validateCredentials;
    commonRequest.post(url, loginDetails, successCallback, errorCallback);
  };
}]);