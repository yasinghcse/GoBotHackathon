(function($) { 

	"use strict";
	
	$(document).ready(function(){
			"use strict";

		//Slider Revolution
		jQuery('.tp-banner').show().revolution(
		{
			delay:5000,
			startwidth:1460,
			startheight:700,
			hideThumbs:false,
					fullScreenAlignForce:"off",
					autoHeight:"off",
					hideTimerBar:"off",
					hideThumbs:200,
					hideNavDelayOnMobile:1500,
					
					navigationType:"none",
					
					soloArrowLeftHalign:"left",
					soloArrowLeftValign:"center",
					soloArrowLeftHOffset:20,
					soloArrowLeftVOffset:0,

					soloArrowRightHalign:"right",
					soloArrowRightValign:"center",
					soloArrowRightHOffset:20,
					soloArrowRightVOffset:0,

					keyboardNavigation:"on",

					touchenabled:"on",						// Enable Swipe Function : on/off
					onHoverStop:"off",						// Stop Banner Timet at Hover on Slide on/off


					stopAtSlide:-1,							// Stop Timer if Slide "x" has been Reached. If stopAfterLoops set to 0, then it stops already in the first Loop at slide X which defined. -1 means do not stop at any slide. stopAfterLoops has no sinn in this case.
					stopAfterLoops:-1,						// Stop Timer if All slides has been played "x" times. IT will stop at THe slide which is defined via stopAtSlide:x, if set to -1 slide never stop automatic

					hideCaptionAtLimit:0,					// It Defines if a caption should be shown under a Screen Resolution ( Basod on The Width of Browser)
					hideAllCaptionAtLimit:0,				// Hide all The Captions if Width of Browser is less then this value
					hideSliderAtLimit:0,					// Hide the whole slider, and stop also functions if Width of Browser is less than this value

					shadow:0,								//0 = no Shadow, 1,2,3 = 3 Different Art of Shadows  (No Shadow in Fullwidth Version !)
					fullWidth:"off",						// Turns On or Off the Fullwidth Image Centering in FullWidth Modus
					fullScreen:"on",
					minFullScreenHeight:0,					// The Minimum FullScreen Height
					forceFullWidth:"off",						// Force The FullWidth

					spinner:"spinner0",

				startDelay:0		// Delay before the first Animation starts.
		});
	
	
		jQuery('#rev_slider_14_1').show().revolution(
		{	
			dottedOverlay:"none",
			delay:5000,
			startwidth:1170,
			startheight:700,
			hideThumbs:200,

			thumbWidth:100,
			thumbHeight:50,
			thumbAmount:3,					
									
			simplifyAll:"off",

			navigationType:"none",
			navigationArrows:"solo",
			navigationStyle:"preview4",

			touchenabled:"on",
			onHoverStop:"on",
			nextSlideOnWindowFocus:"off",

			swipe_threshold: 0.7,
			swipe_min_touches: 1,
			drag_block_vertical: false,												
									
			keyboardNavigation:"on",

			navigationHAlign:"center",
			navigationVAlign:"bottom",
			navigationHOffset:0,
			navigationVOffset:20,

			soloArrowLeftHalign:"left",
			soloArrowLeftValign:"center",
			soloArrowLeftHOffset:20,
			soloArrowLeftVOffset:0,

			soloArrowRightHalign:"right",
			soloArrowRightValign:"center",
			soloArrowRightHOffset:20,
			soloArrowRightVOffset:0,

			shadow:0,
			fullWidth:"off",
			fullScreen:"on",

			spinner:"spinner0",
									
			stopLoop:"off",
			stopAfterLoops:-1,
			stopAtSlide:-1,

			shuffle:"off",

			
			forceFullWidth:"off",
			fullScreenAlignForce:"off",
			minFullScreenHeight:"400",
			
			hideThumbsOnMobile:"off",
			hideNavDelayOnMobile:1500,
			hideBulletsOnMobile:"off",
			hideArrowsOnMobile:"off",
			hideThumbsUnderResolution:0,

			fullScreenOffsetContainer: ".headerwrap, .headertopwrap",
			fullScreenOffset: "",
			hideSliderAtLimit:0,
			hideCaptionAtLimit:0,
			hideAllCaptionAtLilmit:0,
			startWithSlide:0					
		});


	
	});
	
				
				
  })(jQuery); 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 





	