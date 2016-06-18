angular = require('angular');
var ecoSystemMonitor = angular.module('ecoSystemMonitor');
ecoSystemMonitor.controller('dashboardController', ['$scope', '$rootScope', 'commonService', 'MonitoringService', function($scope, $rootScope, commonService, MonitoringService) {
  $scope.init = function() {
    $scope.loading = false;
    $scope.getComponentStatus();
  };

  $scope.getComponentStatus = function() {
    $scope.loading = true;
    var successCallback = function(data) {
      $scope.componentList = data;
      $scope.loading = false;
      window.setTimeout(function() {
        $scope.getComponentStatus();
      }, 30000);
    };
    var errorCallback = function(error) {
      commonService.showError(error, 'Couldn\'t get current component status! Please try again later.');
      $scope.loading = false;
    };
    MonitoringService.getComponentStatus(successCallback, errorCallback);
  };

  $scope.checkStatus = function(env, componentStatus) {
    componentStatus[env] = true;
    for (var i = 0; i < componentStatus.environments.length; i++) {
      var currentEnv = componentStatus.environments[i];
      if (currentEnv.type === env.toUpperCase()) {
        if (currentEnv.status === 'GREEN') {
          return 'running';
        } else if (currentEnv.status === 'YELLOW') {
          return 'partial';
        } else if (currentEnv.status === 'RED') {
          return 'stopped';
        }
      }
    }
    componentStatus[env] = false;
    return 'not';
  };

  $scope.showSubscribeModal = function(evt, index) {
    $scope.currentComp = $scope.componentList[index];
    $scope.subscriptionDetails = {};
    $scope.getSubscriptionDetails();
  };

  $scope.subscribe = function() {
    $scope.loading = true;
    var successCallback = function(data) {
      commonService.showSuccess(null, 'Subscription details updated successfully.');
      $('#subscribeModal').hide();
      $scope.loading = false;
    };
    var errorCallback = function(error) {
      commonService.showError(error, 'Unable to subscribe! Please try again later.');
      $('#subscribeModal').hide();
      $scope.loading = false;
    };
    MonitoringService.subscribe($scope.subscriptionDetails, successCallback, errorCallback);
  };

  $scope.getSubscriptionDetails = function() {
    $scope.loading = true;
    var successCallback = function(data) {
      $scope.subscriptionDetails = data;
      $('#subscribeModal').show();
      $scope.loading = false;
    };
    var errorCallback = function(error) {
      commonService.showError(error, 'Couldn\'t get current component status! Please try again later.');
      $scope.loading = false;
      $scope.subscriptionDetails = {};
    };
    MonitoringService.getSubscriptionDetails($scope.emailId, $scope.currentComp.id, successCallback, errorCallback);
  };

  $scope.launch = function(path) {
    window.location.hash = '#/' + path;
  };

  $scope.init();
}]);