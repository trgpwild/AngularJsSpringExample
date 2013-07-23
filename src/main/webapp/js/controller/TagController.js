var ListController = function($scope, TagService) {
	$scope.tags = TagService.query();
	$scope.deleteEntry = function(tag) {
		tag.$remove(function() {
			$scope.tags = TagService.query();
		});
	};
};
ListController.$inject = ['$scope', 'TagService'];

var EditController = function($scope, $routeParams, $location, TagService) {
	$scope.tag = TagService.get({id: $routeParams.id});
	$scope.save = function() {
		$scope.tag.$save(function() {
			$location.path('#!/');
		});
	};
};
EditController.$inject = ['$scope', '$routeParams', '$location', 'TagService'];

var CreateController = function($scope, $location, TagService) {
	$scope.tag = new TagService();
	$scope.save = function() {
		$scope.tag.$save(function() {
			$location.path('#!/');
		});
	};
};
CreateController.$inject = ['$scope', '$location', 'TagService'];