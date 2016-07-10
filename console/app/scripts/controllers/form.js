'use strict';
/**
 * @ngdoc function
 * @name sbAdminApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sbAdminApp
 */
angular.module('sbAdminApp')
  .controller('FormCtrl', function($scope, $http) {
    $scope.email= 'mayank.rathi1808@gmail.com';
    $scope.password= 'password';
    /*$scope.checkLogin = func
    $scope.checkLogin = function() {
    $http({
            method : 'POST',
            url : 'http://localhost:8080/lenden-api/user/login',
            data : angular.toJson($scope.user),
            headers : {
              'Content-Type' : 'application/json'
            }
          }).then(function mySuc(response) {
        $scope.data = response.data;
        $scope.code = response.code;
        $scope.message = response.message;
      }, function myErr(response) {
        $scope.data = "a";
        $scope.code = "b";
        $scope.message = "c";
      });
      $scope.data = 'a';
      $scope.code = 'b';
      $scope.message = 'c';
    };*/

    $scope.login = function() {
        $http({
            method : 'POST',
            url : 'http://localhost:8080/lenden-api/user/login',
            data : angular.toJson($scope.user),
            headers : {
              'Content-Type' : 'application/json'
            }
          }).then(function mySuc(response) {
        $scope.data = response.data;
        $scope.code = response.code;
        $scope.message = response.message;
      }, function myErr(response) {
        $scope.data = "a";
        $scope.code = "b";
        $scope.message = "c";
      });
    };
    $scope.list = [];
      $scope.text = 'hello';
      $scope.submit = function() {
        if ($scope.text) {
          $scope.list.push(this.text);
          $scope.text = '';
        }
      };

    function loginDTO(user){
      var dto = {
        'email': user.email,
        'password': user.password
      };
      return dto;
    };
  });