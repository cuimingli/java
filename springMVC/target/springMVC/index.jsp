
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script  type = "text/javascript" src=" /assets/jquery.min.js" ></script>
</head>
<body>
    <div class="container">
	     <form id="addUserForm">
		  <br/>
		  <div >
			<label for="username">userName：</label>
			<input type="text" class="form-control" id="username" name="username" >
		  </div>
		  <div class="form-group">
			<label for="userage">passWord：</label>
			<input type="password" class="form-control" id="password" name="password" >
		  </div>
		
		  <div >
		 <a href="#" class="btn btn-primary" onclick="addUser()">tj</a>
		  <a href="#" class="btn btn-primary" onclick="login()">dl</a>
		  </div>
		</form>
    </div>
    
    <script>
		function addUser(){
			var p={
					"userName": $("#username").val(),
					"passWord":$("#password").val()
				}
			$.ajax({
				url: "/user/add.do",
				type:'post',
				dataType:'json',
				data:JSON.stringify(p),
				contentType: "application/json;charset=UTF-8",
				success:function(data){	
					alert(data.data);
				}
			});
			
		}
		
		function login(){
			var p={
					"userName": $("#username").val(),
					"passWord":$("#password").val()
				}
			$.ajax({
				url: "/user/select.do",
				type:'post',
				dataType:'json',
				data:JSON.stringify(p),
				contentType: "application/json;charset=UTF-8",
				success:function(data){	
					alert(data.data);
				}
			});
			
			
		}
		
		
		</script> 	
</body>
</html>
