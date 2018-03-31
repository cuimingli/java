/*多行文本输入字数限制*/
function textare(num,txt){
	var txt=txt;
	$('.num').html(num);
	if(!txt){
		txt="详细地址";
	}
	$('.textarea').attr('placeholder','请输入'+txt+'，最多可输入'+num+'字')
	$('.textarea').on('focus',function(){
		if(this.value==''){
			$(this).parent().children('.num').html('0');
		}
	}).keyup(function(){
		var val=$(this).val().trim(),
		len=val.length;
		$(this).parent().children('.num').html(len);
		if(len>num){
			$(this).val($(this).val().substr(0,num));
			$(this).parent().children('.num').css('color','#f90');
		}
	}).blur(function(){
		var val=$(this).val().trim(),
		len=val.length;
		$(this).parent().children('.num').html(len);
		if(this.value==''){
			$(this).parent().children('.num').html(num);
		}
	})
}
/*关闭弹窗*/
$('.closedBtn').on('click',function(){
	$(this).parents('.popup').hide();
})
$(document).on('click',function(){
	$('.popup').hide();
})
$('.popMain').click(function(e){
	e.stopPropagation()
})

/*自定义单选和多选*/
	/*多选*/
$('.checked').on('click',function(){
	if($(this).hasClass('checked-click')){
		$(this).removeClass('checked-click')
	}else{
		$(this).addClass('checked-click')
	}
})
	/*单选*/
	$('.radio').on('click',function(){
		if($(this).hasClass('radio-click')){
			$(this).removeClass('radio-click');
		}else{
			$(this).parents('.radiobox').find('.radio').removeClass('radio-click');
			$(this).addClass('radio-click')
		}
	})
	/*下拉单选*/
	$('.radio1').on('click',function(e){
		var val=$(this).next().html();
		if($(this).hasClass('radio-click1')){
			$(this).removeClass('radio-click1');
		}else{
			$(this).parents('.selectOption ul').find('.radio1').removeClass('radio-click1');
			$(this).addClass('radio-click1');
			$(this).parents('.selectCustom').find('.selectInput input').val(val)
		}
	})
	$('.selectInput').on('click',function(e){
		var $this=$(this).parent().children('.selectOption');
		if($this.css('display')=='none'){
			$this.slideDown(500);
		}else{
			$this.slideUp(500);
		}
		
	})
	$('.selectInput input').blur(function(){
		var val=$(this).val();
		if(val==''){
			$('.selectOption li').show();
		}else{
			$('.selectOption li').each(function(){
				var txt=$(this).find('.rightTxt').text();
				if(txt.indexOf(val)!=-1){
					$(this).show();
				}else{
					$(this).hide();
				}
			})
		}
	}).keyup(function(){
		$(this).triggerHandler('blur');
	})
	$('.selectCustom').click(function(e){
		e.stopPropagation();
	})
	$(document).click(function(){
		$('.selectOption').fadeOut(100);
	})
/*关闭全局提示弹窗*/
$('.rightRemove').click(function(){
	$(this).parents('.commonTips').hide()
})

var Time=new Date();
var year=Time.getFullYear();
var month=Time.getMonth()+1;
var day=Time.getDate();
var newDate=year+'-'+month+'-'+day;