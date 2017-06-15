angular.module('app')
	.run([
		'$log',
		function($log) {
			$log.info('App Running')
		}
	])