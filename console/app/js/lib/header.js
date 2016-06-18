'use strict';

/**
 * @ngdoc directive
 * @name izzyposWebApp.directive:adminPosHeader
 * @description
 * # adminPosHeader
 */
angular.module('ecoSystemMonitor')
	.directive('header',function(){
		return {
        templateUrl:'views/header.html',
        restrict: 'E',
        replace: true,
    	}
	});


