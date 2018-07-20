angular.module('userServiceApp',[])
.controller('userController', [ '$scope','$http', function($scope,$http){
    var self = this;
    self.user = {};
    self.users=[];
    self.message = '';

    self.onlyIntegers = /^\d+$/;
    self.onlyNumbers = /^\d+([,.]\d+)?$/;

    
    function submit() {
        console.log('Submitting');
        if (self.user.id === undefined || self.user.id === null) {
            console.log('Saving New User', self.user);
            saveUser(self.user);
        }
    }

    function saveUser(user) {
        console.log('About to save user');
        $http.post("http://localhost:8080/save", user)
            .then(
                function (response) {
                	console.log('User created successfully');
                    self.message = 'User created successfully';
                    self.errorMessage='';
                    self.done = true;
                    self.user={};
                    self.users = getAllUsers();
                },
                function (errResponse) {
                   console.error('Error while creating User : '+errResponse.data.errorMessage);
                   self.message='Error while loading user';
                }
            );
        return self.message;
    }   
          
        function getAllUsers(){
        	$http.get("http://localhost:8080/listusers")
            .then(
                function (response) {
                	$scope.users = response.data;
                },
                function (errResponse) {
                   console.error('Error while getAllUsers Users : '+errResponse.data.errorMessage);
                }
            );
        return $scope.users;
        	
    }
}]);
 



