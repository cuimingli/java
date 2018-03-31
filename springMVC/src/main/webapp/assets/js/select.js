/**
 * Created by WanYin on 2017/8/10.
 */
$('.s_optionBox').hide();
var select = '';
var boole = true;
$('.s_selectBox').click(function (e) {
    if(boole){
        $(this).css({'border':'1px solid #f33'});
        $(this).attr('click','this');
        console.log($(this).attr('click'));
        $(this).children('.s_optionBox').slideToggle('fast');
        boole = false;
    }else {
        if($(this).attr('click')){
            $(this).css({'border':'1px solid #dde2eb'});
            $(this).children('.s_optionBox').slideToggle('fast');
            $('.s_selectBox').attr('click','');
            boole = true;
        }else {
            console.log('不同');
            //$(this).attr('click','this');
            $('.s_selectBox').attr('click','').css({'border':'1px solid #dde2eb'});
            $('.s_optionBox').slideUp('fast');
            $(this).css({'border':'1px solid #f33'});
            $(this).attr('click','this');
            console.log($(this).attr('click'));
            $(this).children('.s_optionBox').slideToggle('fast');
            //boole = true;
        }
    }
    select = $(this).children('span');

    $('.s_optionBox li').click(function(){
        select.text($(this).text());
    });
    e.stopPropagation();
});
$(document).click(function(){
    $('.s_optionBox').slideUp('fast');
    $('.s_selectBox').attr('click','').css({'border':'1px solid #dde2eb'});
    boole = true;
});