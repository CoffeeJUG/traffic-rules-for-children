$(document).ready(function() {
	
	if(typeof(Cookies.get('username')) == 'undefined'){
		$("#modal").css("display","grid")
		console.log('here funct to show modal');
	}else{
		$("#modal").css("display","none");
		console.log('here func to close modal');
	}
	$(document).on('submit', '.signin', function(e){
		Cookies.set('username', $('#username').val());
		$("#modal").css("display","none");
		console.log('here func to close modal');
	})
});