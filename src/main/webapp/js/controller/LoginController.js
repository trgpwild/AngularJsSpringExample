var LoginController = function($scope, $rootScope, $location, $http, LoginService) {
	$scope.login = function() {
		LoginService.authenticate($.param({username: $scope.username, password: $scope.password}), function(user) {
			$rootScope.user = user;
			$http.defaults.headers.common['Auth-Token'] = user.token;
			$location.path("/");
		});
	};
};
LoginController.$inject = ['$scope', '$rootScope', '$location', '$http', 'LoginService'];