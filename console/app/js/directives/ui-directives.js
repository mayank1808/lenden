angular = require('angular');
var ecoSystemMonitor = angular.module('ecoSystemMonitor');

ecoSystemMonitor.directive('elemReady', ['$parse', function($parse) {
  return {
    restrict: 'A',
    link: function($scope, element, attrs) {
      element.ready(function() {
        if (!$scope.$$phase) {
          $scope.$apply(function() {
            var func = $parse(attrs.elemReady);
            func($scope);
          });
        } else {
          var func = $parse(attrs.elemReady);
          func($scope);
        }
      });
    }
  };
}]);

ecoSystemMonitor.directive('fileModel', ['$parse', function($parse) {
  return {
    restrict: 'A',
    link: function(scope, element, attrs) {
      var model = $parse(attrs.fileModel);
      var modelSetter = model.assign;

      element.bind('change', function() {
        scope.$apply(function() {
          modelSetter(scope, element[0].files[0]);
        });
      });
    }
  };
}]);

ecoSystemMonitor.directive('pagination', ['$compile', function($compile) {
  var obj = {
    restrict: 'E',
    link: function($scope, $element, $attrs) {
      var totalCount = parseInt($attrs.totalCount, 10);
      var perPage = parseInt($attrs.perPage, 10);
      if (perPage == 0) {
        perPage = 10;
      }
      var currentPage = parseInt($attrs.currentPage, 10);
      var startIndex = (currentPage * perPage) + 1;
      var tempIndex = (currentPage + 1) * perPage;
      var endIndex = Math.min(tempIndex, totalCount);
      $scope.showNextSet = function(index) {
        if ($scope.pagination.endIndex !== $scope.numberOfPages) {
          $scope.pagination.startIndex = index;
          if ((index + $scope.maxLinks) > $scope.numberOfPages) {
            $scope.pagination.endIndex = $scope.numberOfPages;
          } else {
            $scope.pagination.endIndex = index + $scope.maxLinks;
          }
        }
      };
      $scope.showPrevSet = function(index) {
        if (index !== 0) {
          $scope.pagination.startIndex = index - $scope.maxLinks;
          $scope.pagination.endIndex = index;
        }
      }
      var buildElement = function(startIndex, endIndex, totalCount, perPage) {
        $scope.numberOfPages = Math.ceil(totalCount / perPage);
        $scope.maxLinks = 10;
        $scope.pagination = {};
        $scope.pagination.startIndex = $scope.currentPage - ($scope.currentPage % $scope.maxLinks);
        $scope.pagination.endIndex = Math.min(($scope.pagination.startIndex + $scope.maxLinks), $scope.numberOfPages);
        var str = '<div class="pagination"><small class="total LTgray">Showing ' + startIndex +
          ' - ' + endIndex + ' of ' + totalCount + ' results</small><ul class="LTblack">';
        if ($scope.numberOfPages > $scope.maxLinks) {
          str += '<li class="first"><span data-ng-click="showPrevSet(pagination.startIndex)">' +
            '<i class="fa fa-angle-left"></i></a></li>';
        }
        str += '<li data-ng-repeat="i in pagination | range"><span data-ng-class="{\'active\': currentPage == i}" data-ng-click="onPageChange(i)">{{i + 1}}</span></li>';
        if ($scope.numberOfPages > $scope.maxLinks) {
          str += '<li class="last"><span data-ng-click="showNextSet(pagination.endIndex)">' +
            '<i class="fa fa-angle-right"></i></a></li>';
        }
        str += '</ul></div>';
        var el = $compile(str)($scope);
        $element.html(el);
      }
      buildElement(startIndex, endIndex, totalCount, perPage);
      $attrs.$observe('currentPage', function(val) {
        currentPage = parseInt(val, 10)
        startIndex = (currentPage * perPage) + 1;
        tempIndex = (currentPage + 1) * perPage;
        endIndex = Math.min(tempIndex, totalCount);
        buildElement(startIndex, endIndex, totalCount, perPage);
      });
    }
  };
  return obj;
}]);
ecoSystemMonitor.filter('range', function() {
  return function(n) {
    var res = [];
    var start = n.startIndex;
    var end = n.endIndex;
    for (var i = start; i < end; i++) {
      res.push(i);
    }
    return res;
  };
});
ecoSystemMonitor.directive('ipAddress', ['$compile', function($compile) {
  var obj = {
    restrict: 'A',
    require: 'ngModel',
    link: function($scope, $element, $attr, $ctrl) {
      $scope.$watch($attr.ipAddress, function() {
        $ctrl.$setViewValue($ctrl.$viewValue);
      });
      var ipAddressValidator = function(value) {
        if (!isEmpty(value)) {
          var octets = value.split('.');
          var validOctets = true;
          for (var i = 0; i < octets.length; i++) {
            if (octets[i] === "" || parseInt(octets[i], 10) < 0 || parseInt(octets[i], 10) > 255) {
              validOctets = false;
              break;
            }
          }
          if (octets.length !== 4) {
            $ctrl.$setValidity('ipAddress', false);
            return undefined;
          } else if (!validOctets) {
            $ctrl.$setValidity('ipAddress', false);
            return undefined;
          } else {
            $ctrl.$setValidity('ipAddress', true);
            return value;
          }
        }
      };
      $ctrl.$parsers.push(ipAddressValidator);
      $ctrl.$formatters.push(ipAddressValidator);
    }
  };
  return obj;
}]);
ecoSystemMonitor.directive('rating', ['$compile', function($compile) {
  var obj = {
    restrict: 'A',
    require: 'ngModel',
    link: function($scope, $element, $attr, $ctrl) {
      $scope.$watch($attr.rating, function() {
        $ctrl.$setViewValue($ctrl.$viewValue);
      });
      var ratingValidator = function(value) {
        if (!isEmpty(value)) {
          if (isNaN(parseFloat(value, 10))) {
            $ctrl.$setValidity('rating', false);
            return undefined;
          } else if (parseFloat(value, 10) < 0 || parseFloat(value, 10) > 5) {
            $ctrl.$setValidity('rating', false);
            return undefined;
          } else {
            $ctrl.$setValidity('rating', true);
            return value;
          }
        }
      };
      $ctrl.$parsers.push(ratingValidator);
      $ctrl.$formatters.push(ratingValidator);
    }
  };
  return obj;
}]);

function isEmpty(value) {
  return angular.isUndefined(value) || value === '' || value === null || value !== value;
}