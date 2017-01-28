jQuery(document).ready(function(e){
	"use strict";
	function init_owl(){
		if(e(".header-slider").length){			
			var t=e(window).height(),			
			i=t;
			e.each(e("> .owl-item",e(".header-slider .owl-wrapper")),function(){
				var t=	e(this).find(".slider-item-background").children("img").attr("src");
						e(this).children(".cs-slider-item").css("background-image","url("+t+")"),
						e(this).children(".cs-slider-item").css("height",i)
			});
		}
	}

		
	if(e(".cs-slider").length>0&&e(".cs-slider").each(function(){
		var i=!1,s="fade",l=e(this).children(".cs-slider-content"),n=e(this).attr("data-slider"),r=e(this).attr("data-pagi"),o=e(this).attr("data-control"),
		c=e(this).attr("data-transition");"true"==o&&(i=!0),("fade"==c||"backSlide"==c||"goDown"==c||"fadeUp"==c)&&(s=c),
		l.owlCarousel({
			pagination:false,
			singleItem:true,
			autoPlay:3500,
			slideSpeed:500,
			paginationSpeed:500,
			transitionStyle:"goDown",
			items:1,
			itemsDesktop:[1e3,1],
			itemsDesktopSmall:[980,1],
			itemsTablet:[768,1],
			itemsMobile:[480,1]
		}),i&&(l.closest(".cs-slider").find(".cs-slider-control .nav-preview").click(function(){l.trigger("owl.prev")}),l.closest(".cs-slider").find(".cs-slider-control .nav-next").click(function(){l.trigger("owl.next")}))
	}));
		
		init_owl();
		e(window).resize(function(){init_owl()}).trigger("resize")
		
});