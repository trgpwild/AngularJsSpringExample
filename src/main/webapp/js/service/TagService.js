services.factory('TagService', function($resource) {
	return $resource('rest/tags/:id', {id: '@id'});
});