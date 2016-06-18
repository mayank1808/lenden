angular = require('angular');
var ecoSystemMonitor = angular.module('ecoSystemMonitor');
ecoSystemMonitor.service('SystemSettingsService', ['$http', 'commonRequest', 'apiService', function($http, commonRequest, apiService) {
  this.getSystemSettings = function(successCallback, errorCallback) {
    var url = apiService.apiURL + apiService.resourceUrl.getSystemSettings;
    commonRequest.get(url, successCallback, errorCallback);
  };

  this.updateSystemSettings = function(settings, successCallback, errorCallback) {
    var url = apiService.apiURL + apiService.resourceUrl.updateSystemSettings;
    commonRequest.put(url, settings, successCallback, errorCallback);
  };
}]);