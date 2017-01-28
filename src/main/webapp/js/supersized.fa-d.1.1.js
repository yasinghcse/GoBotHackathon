/*

	Supersized - Fullscreen Slideshow jQuery Plugin
	Version : 3.2.6
	Theme 	: FA Design 1.0
	
	Site	: www.fa-d.com
	Author	: Richard Vallee
	License : MIT License / GPL License

*/

(function($){
	theme = {
		_init : function() {
		    $(vars.next_slide).click(function() {
		    	api.nextSlide();
		    });
		    
		    $(vars.prev_slide).click(function() {
		    	api.prevSlide();
		    });
		},
		
	 	beforeAnimation : function(direction){
		    /* Update Fields
		  	----------------------------*/
		  	// Update slide caption
		   	if ($(vars.slide_caption).length) {
				$(vars.slide_caption).fadeOut('slow', function() {
					api.getField('title') ? $(vars.slide_caption).html(api.getField('title')) : $(vars.slide_caption).html('');
			   		$(vars.slide_caption).fadeIn('slow');
		   		});
		   		
		   		if(api.getField('url')) {
		   			$(vars.slide_caption).attr('href', api.getField('url'));
		   		} else {
		   			$(vars.slide_caption).removeAttr('href');
		   		}
		   	}
		    // Update slide number
//			if(vars.slide_current.length && vars.current_slide % 2 === 0) {
//			    $(vars.slide_current).html(vars.current_slide + 1);
//	 		}
	 	}
	 };
	 
	 /* Theme Specific Variables
	 ----------------------------*/
	 $.supersized.themeVars = {
		next_slide			:	'#slideshow-next',		// Next slide button
		prev_slide			:	'#slideshow-prev',		// Prev slide button
		
		slide_caption		:	'#slide-caption',	// Slide caption
		slide_current		:	'#slide-number'		// Current slide number
	 };
})(jQuery);