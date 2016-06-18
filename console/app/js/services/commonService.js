var ecoSystemMonitor = angular.module('ecoSystemMonitor');
ecoSystemMonitor.service('commonService', ['$rootScope', function($rootScope) {
  this.showError = function(error, msg) {
    if (error && error.message) {
      $rootScope.message = {
        type: 'error',
        content: error.message
      };
    } else {
      $rootScope.message = {
        type: 'error',
        content: msg
      };
    }
  };

  this.showSuccess = function(success, msg) {
    if (success && success.message) {
      $rootScope.message = {
        type: 'success',
        content: success.message
      };
    } else {
      $rootScope.message = {
        type: 'success',
        content: msg
      };
    }
  };

  this.showInfo = function(info, msg) {
    if (info && info.message) {
      $rootScope.message = {
        type: 'info',
        content: info.message
      };
    } else {
      $rootScope.message = {
        type: 'info',
        content: msg
      };
    }
  };

  this.showWarning = function(warning, msg) {
    if (warning && warning.message) {
      $rootScope.message = {
        type: 'warning',
        content: warning.message
      };
    } else {
      $rootScope.message = {
        type: 'warning',
        content: msg
      };
    }
  };

  this.resetForm = function(form) {
    form.$setUntouched();
    form.$setPristine();
    for (var key in form) {
      if (key.indexOf('$') !== 0) {
        form[key].$viewValue = null;
      }
    }
    document.getElementsByName(form.$name)[0].reset();
  };

}]);