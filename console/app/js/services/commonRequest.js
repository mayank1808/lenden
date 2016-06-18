angular = require('angular');
var ecoSystemMonitor = angular.module('ecoSystemMonitor');
ecoSystemMonitor.service('commonRequest', ['$http', '$rootScope', function($http, $rootScope) {
  this.get = function(url, successCallback, errorCallback, extraInfo) {
    var req = {
      method: 'GET',
      url: url,
      dataType: 'json',
      headers: {
        'Content-Type': 'application/json'
      }
    };
    $http(req).success(function(response) {
      try {
        response = JSON.parse(response);
      } catch (e) {
        response = response;
      }
      if (typeof successCallback === 'function') {
        if (extraInfo) {
          successCallback(response, extraInfo);
        } else {
          successCallback(response);
        }
      }
    }).error(function(error) {
      if (typeof errorCallback === 'function') {
        if (extraInfo) {
          errorCallback(error, extraInfo);
        } else {
          errorCallback(error);
        }
      } else {
        $rootScope.message = {
          type: 'error',
          content: 'Request failed. Please try again later.'
        };
      }
    })
  };

  this.deleteRequest = function(url, successCallback, errorCallback, extraInfo) {
    var req = {
      method: 'DELETE',
      url: url,
      dataType: 'json',
      headers: {
        'Content-Type': 'application/json'
      }
    };
    $http(req).success(function(response) {
      try {
        response = JSON.parse(response);
      } catch (e) {
        response = response;
      }
      if (typeof successCallback === 'function') {
        if (extraInfo) {
          successCallback(response, extraInfo);
        } else {
          successCallback(response);
        }
      }
    }).error(function(error) {
      if (typeof errorCallback === 'function') {
        if (extraInfo) {
          errorCallback(error, extraInfo);
        } else {
          errorCallback(error);
        }
      } else {
        $rootScope.message = {
          type: 'error',
          content: 'Request failed. Please try again later.'
        };
      }
    })
  };

  this.post = function(url, formData, successCallback, errorCallback, extraInfo) {
    var req = {
      method: 'POST',
      url: url,
      data: formData
    };
    $http(req).success(function(response) {
      try {
        response = JSON.parse(response);
      } catch (e) {
        response = response;
      }
      if (typeof successCallback === 'function') {
        if (extraInfo) {
          successCallback(response, extraInfo);
        } else {
          successCallback(response);
        }
      }
    }).error(function(error) {
      if (typeof errorCallback === 'function') {
        if (extraInfo) {
          errorCallback(error, extraInfo);
        } else {
          errorCallback(error);
        }
      } else {
        $rootScope.message = {
          type: 'error',
          content: 'Request failed. Please try again later.'
        };
      }
    });
  };

  this.put = function(url, formData, successCallback, errorCallback, extraInfo) {
    var req = {
      method: 'PUT',
      url: url,
      data: formData
    };
    $http(req).success(function(response) {
      try {
        response = JSON.parse(response);
      } catch (e) {
        response = response;
      }
      if (typeof successCallback === 'function') {
        if (extraInfo) {
          successCallback(response, extraInfo);
        } else {
          successCallback(response);
        }
      }
    }).error(function(error) {
      if (typeof errorCallback === 'function') {
        if (extraInfo) {
          errorCallback(error, extraInfo);
        } else {
          errorCallback(error);
        }
      } else {
        $rootScope.message = {
          type: 'error',
          content: 'Request failed. Please try again later.'
        };
      }
    });
  };

  this.getPromise = function(url) {
    var req = {
      method: 'GET',
      url: url,
      dataType: 'json',
      headers: {
        'Content-Type': 'application/json'
      }
    };
    return $http(req);
  };

  this.deletePromise = function(url) {
    var req = {
      method: 'DELETE',
      url: url,
      dataType: 'json',
      headers: {
        'Content-Type': 'application/json'
      }
    };
    return $http(req);
  };

  this.postPromise = function(url, formData) {
    var req = {
      method: 'POST',
      url: url,
      data: formData,
      dataType: 'json',
      headers: {
        'Content-Type': 'application/json'
      }
    };
    return $http(req);
  };

  this.putPromise = function(url, formData) {
    var req = {
      method: 'PUT',
      url: url,
      data: formData,
      dataType: 'json',
      headers: {
        'Content-Type': 'application/json'
      }
    };
    return $http(req);
  };
}]);