angular = require('angular');
var ecoSystemMonitor = angular.module('ecoSystemMonitor');
ecoSystemMonitor.controller('componentConfigurationController', ['$scope', '$rootScope', 'commonService', 'ComponentSettingsService', function($scope, $rootScope, commonService, ComponentSettingsService) {
  $scope.init = function() {
    $scope.loading = false;
    $scope.getComponents();
  };

  $scope.changeFormName = function(evt) {
    var form = angular.element(evt.target).parent();
    angular.element('form').removeAttr('name');
    if (form.parent().hasClass('expanded')) {
      angular.element(form).attr('name', 'form');
    }
  };

  $scope.onSubmit = function(evObject) {
    if (evObject.form.$valid) {
      var successCallback = function(data) {
        commonService.showSuccess(null, 'Component settings updated successfully.');
        $scope.loading = false;
      };
      var errorCallback = function(error) {
        commonService.showError(error, 'Unable to update component settings! Please try again later.');
        $scope.loading = false;
      };
      ComponentSettingsService.updateComponentSettings(evObject.component, successCallback, errorCallback);
    }
  };

  $scope.getComponents = function() {
    $scope.loading = true;
    var successCallback = function(data) {
      $scope.componentList = data;
      $scope.loading = false;
    };
    var errorCallback = function(error) {
      commonService.showError(error, 'Unable to fetch component settings! Please try again later.');
      $scope.loading = false;
    };
    ComponentSettingsService.getComponentSettings(successCallback, errorCallback);
  };

  $scope.init();
}]);