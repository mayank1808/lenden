'use strict';

/**
 * @ngdoc directive
 * @name izzyposWebApp.directive:adminPosHeader
 * @description
 * # adminPosHeader
 */
angular.module('ecoSystemMonitor')
	.directive('notifications',function(){
		return {
        templateUrl:'views/notifications.html',
        restrict: 'E',
        replace: true,
    	}
	});


