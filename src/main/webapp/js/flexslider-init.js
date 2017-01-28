/*-----------------------------------------------------------------------------------*/
/*	FLEXSLIDER
/*-----------------------------------------------------------------------------------*/
jQuery(window).load(function(){
	//Top Slider
	$('.flexslider.top_slider').flexslider({
		animation: "fade",
		controlNav: false,
		directionNav: true,
		animationLoop: false,
		slideshow: false,
		prevText: "",
		nextText: "",
		sync: "#carousel"
	});
	
	homeHeight();
	
	jQuery('.flexslider.top_slider .flex-direction-nav').addClass('container');
	
});

jQuery(window).resize(function(){
	homeHeight();
	
});

jQuery(document).ready(function(){
	homeHeight();
	
});

function homeHeight(){
	var wh = jQuery(window).height()-75;
	jQuery('.top_slider, .top_slider .slides li').css('height', wh);
}

