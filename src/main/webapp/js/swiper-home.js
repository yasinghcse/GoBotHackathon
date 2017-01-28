var height, de, width, oldBrowser = false, ie8 = false;
$(document).ready(function(){
	de = document.documentElement;
	setHeight();
	setWidth();	
	$('.arrow-left,.arrow-left2').on('click', function(e){
    	e.preventDefault();
    		var swiper = $(this).siblings('.swiper-container').data('swiper');
    			swiper.swipePrev();
  	});
  	$('.arrow-right,.arrow-right2').on('click', function(e){
    	e.preventDefault();
    		var swiper = $(this).siblings('.swiper-container').data('swiper');
    			swiper.swipeNext();
  	});  	
  	$('.trigger').first().addClass('trigger_active');  	
  	$('.trigger').not('.trigger_active').next('.toggle_container').hide();
	$('.trigger').click( function() {
		var trig = $(this);
		if ( trig.hasClass('trigger_active') ) {
			trig.next('.toggle_container').slideToggle('slow');
			trig.removeClass('trigger_active');
		} else {
			$('.trigger_active').next('.toggle_container').slideToggle('slow');
			$('.trigger_active').removeClass('trigger_active');
			trig.next('.toggle_container').slideToggle('slow');
			trig.addClass('trigger_active');
		};
		return false;
	});
});

$(window).resize(function(){
	setHeight();
	setWidth();
});

$(window).load(function() {		
	var mySwiper = $('#home-content .swiper-container').swiper({
		mode:'horizontal',
	    loop:true,
	    speed:800,
	    useCSS3Transforms:true,
	    grabCursor: true,
	    paginationClickable: true,
	    autoplay: 10000
	});
	
	var mySwiper2 = $('#home-swiper3 .swiper-container').swiper({
		mode:'horizontal',
		pagination: '.pagination',
	    loop:true,
	    speed:800,
	    useCSS3Transforms:true,
	    grabCursor: true,
	    paginationClickable: true,
	    autoplay: 10000
	});
	
});

function checkSize() {
	if(width >= 850) {
		setHeight();
	} 
}
function setHeight() {
	height = window.innerHeight || self.innerHeight || (de&&de.clientHeight) || document.body.clientHeight;
	$('#home-content .slider, #home-content .swiper-slide, #home-content .swiper-wrapper').height(height);
	$('#home-content .slider.content').height(640);
	
	$('#home-swiper3 .slider, #home-swiper3 .swiper-slide, #home-swiper3 .swiper-wrapper').height(540);
	$('#home-swiper3 .slider.content').height(340);
	
	$('.slider.content > img').height(height);
	
}
function setWidth() {
  width = window.innerWidth || self.innerWidth || (de&&de.clientWidth) || document.body.clientWidth;
}