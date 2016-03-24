var app = angular.module('app', ['ngSanitize']);
 
app.factory('ChatService', function() {
  var service = {};
 
  service.disconnect= function() {
	  service.ws.close();
	  service.ws = null;
  };

  service.connect = function(hostname,nickname) {
    if(service.ws) { return; }
    var ws = new WebSocket(hostname + "/" + nickname);
 
    ws.onopen = function() {
      service.infoCallback("Connected to: " + hostname);
      service.errorCallback("");
    };
 
    ws.onerror = function() {
      service.errorCallback("Failed to open a connection");
      ws.close();
    };
 
    ws.onclose = function() {
      service.infoCallback("Connection to " + hostname + " closed!");
    };
 
    ws.onmessage = function(message) {
      service.messageCallback(message.data);
    };
 
    service.ws = ws;
  };
 
  service.send = function(message) {
  	var jsonMessage = {
			"message": message
	};
	
    service.ws.send(angular.toJson(jsonMessage, true));
  };
 
  service.subscribeMessages = function(callback) {
    service.messageCallback = callback;
  };

  service.subscribeInfo = function(callback) {
	service.infoCallback = callback;
  };

  service.subscribeError = function(callback) {
  	service.errorCallback = callback;
  };
  
  return service;
});
 
 
function AppCtrl($scope, $sce, ChatService) {

		var target = document.body;
		var observer = new MutationObserver(function( mutations ) {
			$('html, body').animate({scrollTop:$(document).height()}, 'slow');		
		});

		var config = { 
			attributes: true, 
			childList: true, 
			characterData: true, 
			subtree: true
		};
		 
		observer.observe(target, config);


	
  $scope.plop = $sce.trustAsHtml("<h1>test</h1><script>alert('test');</script>");
  $scope.messages = [];
  $scope.infoMessage= "";
  $scope.errorMessage= "";
  $scope.hostname = "ws://localhost:8080/web/chatserver";

  ChatService.subscribeMessages(function(message) {
	    var json = angular.fromJson(message);
	    
	    if(json.error){
	    	$scope.errorMessage = "An error occurred on the server: " + json.error;
	    	ChatService.disconnect();
	    }else{
	    	$scope.errorMessage = "";
	        $scope.messages.push(json.message);
	    }

    $scope.$apply();
  });

  ChatService.subscribeInfo(function(message) {
	    $scope.infoMessage=message;
	    $scope.$apply();
  });

  ChatService.subscribeError(function(message) {
	    $scope.errorMessage=message;
	    $scope.$apply();
  });

  $scope.connect = function() {
    ChatService.connect($scope.hostname, $scope.nickname);
  };
 
  $scope.send = function() {
    ChatService.send($scope.text);
    $scope.text = "";
  };

  
  $scope.test= function(e) {
	  return $sce.trustAsHtml(e);
  };

}