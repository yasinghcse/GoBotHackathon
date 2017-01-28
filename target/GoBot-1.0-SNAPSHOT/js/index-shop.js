$(document).ready(function () {
    "use strict";
   
    // Initialize Home Sliders
    $('#home-slider').flexslider({
        directionNav: false,
		controlNav:true,
		autoPlay:5000,
		animation: Modernizr.touch ? "slide" : "fade"
		

  
    });	

	
	$('#home-slider li').parallax("50%", 0.1);
	
    // Adjust slide height for smaller screens
    if ($(window).height() < 760) {
        $('#home-slider .slides li').css('height', $(window).height());
    }
    $('#home-slider .slides li').each(function () {

        var imgSrc = $(this).children('.slider-bg').attr('src');
        $(this).css('background', 'url("' + imgSrc + '")');
        $(this).children('.slider-bg').remove();

        var slideHeight = $(this).height();
        var contentHeight = $(this).children('.slide-content').height();
        var padTop = (slideHeight / 2) - (contentHeight / 2);

        $(this).children('.slide-content').css('padding-top', padTop);

    });

});