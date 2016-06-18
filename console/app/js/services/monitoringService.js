angular = require('angular');
var ecoSystemMonitor = angular.module('ecoSystemMonitor');
ecoSystemMonitor.service('MonitoringService', ['$http', 'commonRequest', 'apiService', function($http, commonRequest, apiService) {
  this.getComponentStatus = function(successCallback, errorCallback) {
    var url = apiService.apiURL + apiService.resourceUrl.getComponentStatus;
    commonRequest.get(url, successCallback, errorCallback);
  };

  this.getSubscriptionDetails = function(email, id, successCallback, errorCallback) {
    var url = apiService.apiURL + apiService.resourceUrl.getSubscriptionDetails;
    url = url.replace('{{emailId}}', email);
    url = url.replace('{{id}}', id);
    commonRequest.get(url, successCallback, errorCallback);
  };

  this.subscribe = function(subscriptionDetails, successCallback, errorCallback) {
    var url = apiService.apiURL + apiService.resourceUrl.updateSubscription;
    commonRequest.post(url, subscriptionDetails, successCallback, errorCallback);
  };
}]);