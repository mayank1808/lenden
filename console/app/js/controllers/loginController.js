angular = require('angular');
var ecoSystemMonitor = angular.module('ecoSystemMonitor');
ecoSystemMonitor.controller('loginController', ['$scope', '$rootScope', 'commonService', 'LoginService', function($scope, $rootScope, commonService, LoginService) {
  $scope.init = function() {
    $scope.loading = false;
  };

  $scope.onSubmit = function() {
    $scope.resetMessage();
    $scope.loading = true;
    var successCallback = function(data) {
      if (data.isAuthenticated) {
        $scope.populateData(data);
        $scope.loginSuccessful();
      } else {
        commonService.showError('error', 'User is not authenticated.');
        $scope.loginRequest.password = '';
      }
      $scope.loading = false;
    };
    var errorCallback = function(error) {
      commonService.showError(error, 'Login Failed, Invalid Credentials.');
      $scope.loginRequest.password = '';
      $scope.loading = false;
    };
    LoginService.validateCredentials($scope.loginRequest, successCallback, errorCallback);
  };

  $scope.populateData = function(data) {
    $rootScope.emailId = data.emailId;
    $rootScope.userName = data.name;
    $rootScope.userRole = 'admin';
    $scope.loginSuccessful();
  };

  $scope.loginSuccessful = function() {
    $rootScope.userLogged = true;
    window.location.hash = '/dashboard';
  };

  $scope.resetMessage = function() {
    $rootScope.message = null;
  };

  $scope.init();

}]);