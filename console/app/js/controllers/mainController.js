angular = require('angular');
var ecoSystemMonitor = angular.module('ecoSystemMonitor');
ecoSystemMonitor.controller('mainController', ['$scope', '$rootScope', 'pageConfig', 'pageAccessConfig', function($scope, $rootScope, pageConfig, pageAccessConfig) {
	$scope.init = function() {
		$rootScope.config = pageAccessConfig.config;
		$rootScope.pageConfig = pageConfig;
	};

	$scope.logout = function() {
		$scope.resetMessage();
		$rootScope.userLogged = false;
		$rootScope.emailId = undefined;
		$rootScope.userName = undefined;
		$rootScope.userRole = undefined;
		window.location.hash = '/';
	};

	$scope.isPageAccessible = function(page) {
		var permittedRoles = $scope.config[page];
		if (permittedRoles.indexOf($scope.userRole) > -1) {
			return true;
		}
		return false;
	};

	$scope.resetMessage = function() {
		$rootScope.message = null;
	};

	$scope.init();
}]);