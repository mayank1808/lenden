angular = require('angular');
var ecoSystemMonitor = angular.module('ecoSystemMonitor');
ecoSystemMonitor.service('ComponentSettingsService', ['$http', 'commonRequest', 'apiService', function($http, commonRequest, apiService) {
  this.getComponentSettings = function(successCallback, errorCallback) {
    var url = apiService.apiURL + apiService.resourceUrl.getComponentSettings;
    commonRequest.get(url, successCallback, errorCallback);
  };

  this.updateComponentSettings = function(settings, successCallback, errorCallback) {
    var url = apiService.apiURL + apiService.resourceUrl.updateComponentSettings;
    commonRequest.put(url, settings, successCallback, errorCallback);
  };
}]);