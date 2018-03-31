$(function() {
	  var str = location.href;
	  var str1 = str.substring(str.lastIndexOf("%") + 3);
	  var p={
				"id": str1
				
			}
		$.ajax({
			url: "/good/get-info.do",
			type:'post',
			dataType:'json',
			data:JSON.stringify(p),
			contentType: "application/json;charset=UTF-8",
			success:function(data){	
			      $("#id").val(data.data.id);
			      $("#name").val(data.data.name);
		  		  $("#price").val(data.data.price);
		          },
		          error:function(){
		        	 alert('查询失败')   
		        			
		             }
			
		});
	  
	  
  })
  
  
  function createOrder(){
	 var p={
				"goodId": $("#id").val(),
				 "num" : $("#num").val()
				
			}
		$.ajax({
			url: "/order/createOrder.do",
			type:'post',
			dataType:'json',
			data:JSON.stringify(p),
			contentType: "application/json;charset=UTF-8",
			success:function(data){	
				window.location.href = "/view/listOrder.html"

		          },
		          error:function(){
		        	 alert('查询失败')   
		        			
		             }
			
		});
	
	
}