angular = require('angular');
var ecoSystemMonitor = angular.module('ecoSystemMonitor');
ecoSystemMonitor.controller('systemConfigurationController', ['$scope', '$rootScope', 'commonService', 'SystemSettingsService', function($scope, $rootScope, commonService, SystemSettingsService) {
  $scope.init = function() {
    $scope.loading = false;
    $scope.getSystemSettings();
  };

  $scope.onSubmit = function() {
    var successCallback = function(data) {
      commonService.showSuccess(null, 'System settings updated successfully.');
      $scope.loading = false;
    };
    var errorCallback = function(error) {
      commonService.showError(error, 'Unable to update system settings! Please try again later.');
      $scope.loading = false;
    };
    var tmp = {
      settings: $scope.systemSettings
    };
    SystemSettingsService.updateSystemSettings(tmp, successCallback, errorCallback);
  };

  $scope.getSystemSettings = function() {
    $scope.loading = true;
    var successCallback = function(data) {
      $scope.systemSettings = data;
      for (var i = 0; i < $scope.systemSettings.length; i++) {
        if ($scope.systemSettings[i].dataType == 'Integer') {
          $scope.systemSettings[i].value = parseInt($scope.systemSettings[i].value, 10);
        } else if ($scope.systemSettings[i].dataType == 'Boolean' && $scope.systemSettings[i].value === 'true') {
          $scope.systemSettings[i].value = true;
        }
      }
      $scope.loading = false;
    };
    var errorCallback = function(error) {
      commonService.showError(error, 'Unable to fetch system settings! Please try again later.');
      $scope.loading = false;
    };
    SystemSettingsService.getSystemSettings(successCallback, errorCallback);
  };

  $scope.init();
}]);