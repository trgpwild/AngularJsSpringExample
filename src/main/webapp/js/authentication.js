App.run(['$rootScope', '$http', '$location', 'LoginService', function($rootScope, $http, $location, LoginService) {
	
	$rootScope.$on('$viewContentLoaded', function() {
		delete $rootScope.error;
	});
	
	$rootScope.hasRole = function(role) {
		
		if ($rootScope.user === undefined) {
			return false;
		}
		
		if ($rootScope.user.roles[role] === undefined) {
			return false;
		}
		
		return $rootScope.user.roles[role];
	};
	
	$rootScope.logout = function() {
		delete $rootScope.user;
		delete $http.defaults.headers.common['Auth-Token'];
		$location.path("/login");
	};
	
}]);