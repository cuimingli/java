/**
 * Created by lily on 2017/4/8.
 */
var flags = true;
$(function(){
  initTable();
   sel();

	$(".js_upFile").uploadView({
		uploadBox : '.js_uploadBox',
		showBox : '.js_showBox',
		width : 180,
		height : 144,
		allowType : [ "jpg", "png", "jpeg", "bmp", "gif" ],
		maxSize : 10,
		success : function(e) {
			$(".js_uploadText").text("更改");
		}
	});
});

function initTable(){
    var cateTable = $("#cateTable");
    cateTable.bootstrapTable('destroy');
    cateTable.bootstrapTable({
        classes:'table table-hover',
        striped:true,
        pagination:true,
        method: "POST",
        contentType:"application/json;charset=utf-8",
        url : "/good/get-all.do",
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
        
        columns:[{
        	field:'url',
        	title:'商品',
            align: 'left',
            formatter : function(value, row, index) {
					var a = '<img style="width:50px;height:50px" src="'
							 +value + '" />';
					var b = row.name;
					return a +"&nbsp&nbsp"+ b;
				}
        },{
            field:'price',
            title:'价格',
            align: 'center'
        },{
            field:'inventory',
            title:'库存',
            align: 'center'
        },{
            field:'edit',
            title:'操作',
            align: 'center',
            formatter: function (value, row, index) {
            	
            	 var b = '<a href="/view/addOrder.html?id = '
						+ row.id +  '">创建订单</a>';

                return b;
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

function editRow(){
    $("#myModalEdit").modal({
        backdrop:true,
        show:true
    });
    $('#nameEd').css('display','none');
    $('#imageEd').css('display','none');
}

///添加类目
var addNumber = 0;
function addGoods(){
	addNumber++;
	$(".js_uploadText").text("上传");
	var image = document.querySelector('#image');
	if(addNumber == 1){
		image.addEventListener('change',function(){
			if(/image\/(.+?)+/.test(this.files[0].type)){
				//图片大小验证
				if(this.files[0].size < 5120 * 1000){
					//alert("图片不能大于1M");
					console.log(this.files[0].size);
					var fr = new FileReader;
					fr.readAsDataURL(image.files[0]);
					fr.addEventListener('load',function(){
						var src = this.result;
						$('.js_showBox').html('<img class="js_logoBox" src='+src+' width="180px" height="144px" >');
					})
				}else {
					layer.alert('图片不能大于5M',{skin: 'layui-layer-molv',closeBtn: 0,offset: '300px',icon: 2,title:"提示"} );
					return;
				}
			}else {
				layer.alert('只能上传图片',{skin: 'layui-layer-molv',closeBtn: 0,offset: '300px',icon: 2,title:"提示"} );
				return;
			}
		});
	}

    $("#addCate").modal({
        backdrop:true,
        show:true
    });

    $('#addName').css('display','none');
    $('#addImage').css('display','none');
    $('#name').val('');
	$('#image').val('');
	$('.js_showBox').text('');
}

function sel(){
    $(".select").change(function(){
        var val = $(this).val();
        var tjian = $(".tjian");
        var jxuan = $(".jxuan");
        if(val == "jx"){
            tjian.hide();
            jxuan.show();
        }else{
            tjian.show();
            jxuan.hide();
        }
    });
}
  
function uploadFile() {
	
	$.ajaxFileUpload({
		url : "/file/upload.do",
		type : "POST",
		contentType : "application/json;charset=utf-8",
		secureuri : false,// 是否启用安全提交，默认为false
		fileElementId : 'image',// 文件选择框的id属性
		dataType : 'JSON',// 服务器返回的格式
		async : false, // 异步
		success : function(data) {
			var data1 = data.replace(/<\/*?pre[^<>]*>/, '')
	        var data2 = data1.substring(0, data1.length - 6);
		    var data3 = JSON.parse(data2)
			$("#url").val(data3.data);
			
			
		},
		handleError : function(data, status, e) {
			// alert('添加失败')
			layer.alert('添加失败', {
				skin : 'layui-layer-molv',
				closeBtn : 0,
				offset : '1500px',
				icon : 2,
				title : "提示"
			})
		}
	});
}

 function addGood(){
	  var p = {
		"goodName":$("#name").val(),
		"price":$("#price").val(),
		"inventory":$("#inv").val(),
		"url" : $("#url").val()
			  
	  }
	  $.ajax({
			url: "/good/add.do",
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
		  				alert('添加失败')
		 					
		  				return false;
		  			} else {
		  				alert('添加成功')
		  				window.location	.href = "/view/addGood.html"
		  						  
		  			} 
		  		
		          },
		          error:function(){
		        	 alert('添加失败')   
		        			
		             }
			
		});
 }


 