'use strict';

/**
 * @ngdoc directive
 * @name izzyposWebApp.directive:adminPosHeader
 * @description
 * # adminPosHeader
 */
angular.module('ecoSystemMonitor')
	.directive('headerNotification',function(){
		return {
        templateUrl:'views/header-notification.html',
        restrict: 'E',
        replace: true,
    	}
	});


