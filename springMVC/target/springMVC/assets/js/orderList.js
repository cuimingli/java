/**
 * Created by lily on 2017/4/8.
 */
var flags = true;
$(function(){
	selectUser();
  initTable()
  
});

function initTable(){
    var cateTable = $("#orderTable");
    cateTable.bootstrapTable('destroy');
    cateTable.bootstrapTable({
        classes:'table table-hover',
        striped:true,
        pagination:true,
        method: "POST",
        contentType:"application/json;charset=utf-8",
        url : "/order/get-all.do",
        dataType: "json",
        reorderableColumns : true,
		pagination : true,
		pageSize : 10, //每页显示的记录数
		pageNumber : 1, //当前第几页
		pageList : [10], //记录数可选列表
		queryParams : queryParams,
		sidePagination : "server",
		queryParamsType : "undefined",
		minimumCountColumns : 2,
		sortable : true,
		resizable : true,
		minWidth : 50,
		fixed : false,
		search : false, //是否启用查询
		showColumns : true, //显示下拉框勾选要显示的列
		showRefresh : false,
		showExport : true,
        columns:[
        	  {
                field:'orderNo',
                title:'订单号',
                align: 'center'
            },{
                field:'name',
                title:'商品',
                align: 'center'
           },
        	{
        	field:'url',
        	title:'商品',
            align: 'left',
            formatter : function(value, row, index) {
					var a = '<img style="width:50px;height:50px" src="'
							 +value + '" />';
					return a;
				}
        },{
            field:'price',
            title:'价格',
            align: 'center'
        },{
            field:'num',
            title:'数量',
            align: 'center'
        }
        ,{
            field:'totalPrice',
            title:'总价',
            align: 'center'
        },{
            field:'edit',
            title:'操作',
            formatter: function (value, row, index) {
            	var c = '<a href="#" class="s_top" mce_href="#" onclick="deleteOrder(\''+ row.id + '\')">删除</a> ';
                  return c;
            }
        }]

    });
    function queryParams(params) {
		var temp = {
			//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			pageSize : params.pageSize,
			pageIndex : params.pageNumber,
			
			}
         return JSON.stringify(temp);
	}
	;
};


function deleteOrder(sid){
	var bool = window.confirm("你是否确定删除？");
	if (bool == false) {
		return;
	}
	var p = {
			"id" :sid
	}
	
	  $.ajax({
			url: "/order/delete.do",
			type:'post',
			dataType:'json',
			data:JSON.stringify(p),
			contentType: "application/json;charset=UTF-8",
			success:function(data){	
			
			       if (data.errorMessage) {
		  				if (data.code != "N/A") {
		  					alert(data.errorMessage)
		  	
		  					return false;
		  				}
		  				alert('添加删除')
		 					
		  				return false;
		  			} else {
		  				 initTable();
		  				alert('删除成功')
		  						  
		  			} 
		  		
		          },
		          error:function(){
		        	 alert('添加失败')   
		        			
		             }
			
		});
	
}

  function selectUser(){
	  $.ajax({
			url: "/order/getUser-info.do",
			type:'post',
			dataType:'json',
			contentType: "application/json;charset=UTF-8",
			success:function(data){	
			
				$("#username").html(data.data.userName);
				
		  		
		          },
		          error:function(){
		        	 alert('添加失败')   
		        			
		             }
			
		});
	  
	  
  }
 