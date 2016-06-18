var ecoSystemMonitor = angular.module('ecoSystemMonitor');
ecoSystemMonitor.service('pageAccessConfig', [ '$rootScope', function($rootScope) {
  this.config = {
    "home": ["admin"],
    "dashboard": ["admin"],
    "componentConfiguration": ["admin"],
    "systemConfiguration": ["admin"]
  };
} ]);