App.config(['$routeProvider', '$locationProvider', '$httpProvider', function($routeProvider, $locationProvider, $httpProvider) {
		
		$routeProvider.when('/loggedin', {templateUrl: 'views/loggedin.html', controller: LoginController});
		
		$routeProvider.when('/login', {templateUrl: 'views/login.html', controller: LoginController});
		
		$routeProvider.when('/tag/create', {templateUrl: 'views/tag/form.html', controller: CreateController});
		
		$routeProvider.when('/tag/edit/:id', {templateUrl: 'views/tag/form.html', controller: EditController});

		$routeProvider.when('/tag/list', {templateUrl: 'views/tag/list.html', controller: ListController});
		
		$routeProvider.otherwise({redirectTo:'/tag/list'});
		
		$locationProvider.hashPrefix('!');
		
	    $httpProvider.responseInterceptors.push(interceptor);
	    
}]);