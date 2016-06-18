'use strict';

/**
 * @ngdoc directive
 * @name izzyposWebApp.directive:adminPosHeader
 * @description
 * # adminPosHeader
 */
angular.module('ecoSystemMonitor')
	.directive('timeline',function() {
    return {
        templateUrl:'views/timeline.html',
        restrict: 'E',
        replace: true,
    }
  });
