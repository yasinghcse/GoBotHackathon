<%@ page import="wasdev.windsor.resources.*" %>

<!DOCTYPE html>
<!--[if IE 8]><html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]>
<!--><html class="no-js" lang="en"><!--<![endif]-->
<head>

	<!-- Page header
	================================================== -->
	<meta charset="utf-8">	
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="author" content=""/>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	
	<!-- Page Title
	================================================== -->
	<title>|| NEW WINDSORITE ||</title>
	
	<!-- CSS
	================================================== -->
	
	<!--A dead simple, responsive boilerplate-->
	<link rel="stylesheet" href="css/base.css"/>
	<link rel="stylesheet" href="css/skeleton.css"/>	
	
	<!--Preloader-->
	<link rel="stylesheet" type="text/css" href="css/materialPreloader.css">
	
	<!--Rev slider-->
	<link rel="stylesheet" href="css/revslider.css"/>
	
	<!--Icon font-->
	<link rel="stylesheet" href="css/font-awesome.min.css" />
	<link rel="stylesheet" href="fonts/Icon-font-7/pe-icon-7-stroke.css" />
	<link rel="stylesheet" href="fonts/etlinefont/etlinefont.css" />
	
	<!--Owl carousel-->
	<link rel="stylesheet" href="css/owl.carousel.css"/>
	
	<!--Content Animation-->
	<link rel="stylesheet" href="css/animsition.min.css"/>
	
	<!--venobox lightbox-->
	<link rel="stylesheet" href="css/magnific-popup.css"/>
	
	<!--Common Style-->
	<link rel="stylesheet" href="css/style.css"/>
	
	<!-- Favicons
	================================================== -->
	
	<link rel="shortcut icon" href="favicon.png">
	<link rel="apple-touch-icon" href="apple-touch-icon.png">
	<link rel="apple-touch-icon" sizes="72x72" href="apple-touch-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="114x114" href="apple-touch-icon-114x114.png">
		
</head>
<body>	
		<!-- Navigation panel
		================================================== -->		
		<nav class="main-nav dark transparent stick-fixed">
			<div class="full-wrapper relative clearfix">
			
				<!-- Logo -->
				<div class="header-logo-wrap">
					<div class = "col-sm-4" style="color: #ffffff;font-size: 26px; margin-top: 21px; border: 2px solid #ffffff; padding: 8px 14px;" >|| New Windsorite ||</div>
				</div>
				
				<!-- Mobile nav bars -->
				<div class="mobile-nav">
					<i class="fa fa-bars"></i>
				</div>
				
				<!-- Main Menu -->
				<div class="nav-wrapper large-nav callme">
					<ul class="clearlist">
						
						<!-- Menu With Sub -->
						
					<%
						UserProfile user = null;
						if (session != null) {
							user = (UserProfile) session.getAttribute("UserProfile");
						}
						if (user == null) {
					%>
						<li>
							<a href="home.jsp" class="active">Home</a>							
						</li>
						<li>
							<a href="about.jsp" class="active">About</a>							
						</li>						
						<li>
							<a href="contact.jsp" class="active">Contact</a>							
						</li>
						<li>
							<a href="login.jsp" class="active">Login</a>							
						</li>
						<li>
							<a href="register.jsp" class="active">Register</a>							
						</li>
					<%
						} else {

					%>
						<li>
							<a href="home.jsp" class="active">Home</a>							
						</li>
						<li>
							<a href="about.jsp" class="active">About</a>							
						</li>						
						<li>
							<a href="contact.jsp" class="active">Contact</a>							
						</li>
						<li>
							<a href="recommend.jsp" class="active">Recommendations</a>							
						</li>
						<li>
							<a href="watsonchat.jsp" class="active">Talk To Me</a>							
						</li>
						<li>
							<a href="/Windsorite/Controller?act=logout" class="active">Log Out</a>							
						</li>
						<li>
							<a href="profile.jsp" class="active">Profile</a>							
						</li>
						<li>
							<a href="register.jsp" class="active">Register</a>							
						</li>
					<%
						}
					%>				
						<!-- End Item With Sub -->
						<!-- End Item With Sub -->
						<!-- Divider -->
						<li><a></a></li>
						<!-- End Divider -->
						<!-- Languages -->
						<li>
																			
						</li>
						<!-- End Languages -->						
										
						
						<!-- Address -->
						
						<!-- End Address -->
						
					 </ul>
				</div>
				<!-- End Main Menu -->	

			</div>
		</nav>
		<!-- End Navigation panel -->
	
		<!-- MAIN CONTENT
		================================================== -->		
		<main class="cd-main-content">
			
			<!-- HOME SECTION
			================================================== -->		
			<section class="home black-section">
			
				<div id="home-scrollto"><a data-scroll data-options='{ "easing": "easeInQuad" }' class="scroll" href="#scroll-link"><i class="fa fa-angle-double-down icon-option"></i></a></div>	
		
				<div class="slider-container rev2">

						<div class="tp-banner" >
							<ul>
								<li data-transition="slotzoom-vertical" data-slotamount="7" >
									<img src="images/home/image49.jpg"  alt="slidebg1" data-lazyload="images/home/image49.jpg" data-bgposition="center top" data-bgfit="cover" data-bgrepeat="no-repeat">
									
									<div class="tp-caption sfl      tp-resizeme index2-text-type fontalt4 lp10" 
										 data-x="center" data-hoffset="0" 
										 data-y="center" data-voffset="-10" 
										data-speed="900" 
										data-start="500" 
										data-easing="easeInOutSine" 
										data-splitin="none" 
										data-splitout="none" 
										data-elementdelay="0.1" 
										data-endelementdelay="0.1" 
										 data-endspeed="1000"
										><span class="">Windsor City Portal</span>
									</div>
									
									<!-- LAYER NR. 2 -->
									<div class="tp-caption sfr    tp-resizeme index2-text-type2 fontalt4 side-line" 
										 data-x="center" data-hoffset="0" 
										 data-y="center" data-voffset="50" 
										data-speed="300" 
										data-start="500" 
										data-easing="easeInOutSine" 
										data-splitin="chars" 
										data-splitout="none" 
										data-elementdelay="0.02" 
										data-endelementdelay="0.1" 
										data-endspeed="1000"
										>Search for Windsor Public Services online - Events, Road Blocks, Recycling information & much more !
									</div>
								</li>
								<li data-transition="slotzoom-horizontal" data-slotamount="7"  data-randomtransition="on" >
									<img src="images/home/image50.jpg"  alt="slidebg2" data-lazyload="images/home/image50.jpg" data-bgposition="center top" data-bgfit="cover" data-bgrepeat="no-repeat">
										
									<div class="tp-caption sfr     tp-resizeme index2-text-type fontalt4" 
										 data-x="center" data-hoffset="0" 
										 data-y="center" data-voffset="-10" 
										data-speed="900" 
										data-start="500" 
										data-easing="easeInOutSine" 
										data-splitin="none" 
										data-splitout="none" 
										data-elementdelay="0.1" 
										data-endelementdelay="0.1" 
										data-endspeed="1000"

										><span class="">Windsor City Portal</span>
									</div>
									
									<!-- LAYER NR. 2 -->
									<div class="tp-caption sfl   tp-resizeme index2-text-type2 fontalt4 side-line" 
										 data-x="center" data-hoffset="0" 
										 data-y="center" data-voffset="50" 
										data-speed="300" 
										data-start="500" 
										data-easing="easeInOutSine" 
										data-splitin="chars" 
										data-splitout="none" 
										data-elementdelay="0.02" 
										data-endelementdelay="0.1" 
										data-endspeed="1000"
										>Real-time recommendations at your doorstep!
									</div>
									
										
								</li>

							</ul>
						</div>

				</div>
				
			</section>
			
			
			
			<!-- ABOUT BLOCK
			================================================== -->	
			<section class="page-section white-section sp-top-bottom100" id="scroll-link">
				<div class="container">
					<div class="eight columns">
						<div class="col col1">							
							<h2 class="sp-bottom20 fontalt4 sm-bottom10 lp10">This is new Windsorite.</h2>
						</div>
						<div class="col col2">							
							<p class="fw300">It generally takes time for a newcomer to settle down and getting accustomed to available services in the town. On most of the city websites there is data available in raw form. With this arises a requirement to bring forth these services with
an ease to these people. The project goal is to provide easy and immediate information to newcomer not being necessary
to research and find the information from the City’s website. Based on newcomer preferences and characteristics, a new
system would be developed that should provide information based on the available raw data, for example, Open data
from the City of Windsor.
</p>
						</div>
						<div class="col col2">
							<p class="fw300">For any newcomer, there would be certain issues faced by them such as getting accustomed to the general public services in the city of Windsor. Moreover, a newcomer would lack acquaintances to support while they transit to a new city like Windsor. Therefore, the proposed solution would help in the eradication of the above-mentioned issues.
The system would provide a user friendly web application which can interact with the new windsorite to provide the public
services in real time. A new system would be developed that would recommend various services of the City of Windsor to
its registered users.</p>
						</div>
					</div>	
					<div class="eight columns">
						<div class="ap-quote">
							<div id="owl-quote-slider" class="owl-carousel">
								<div class="item">
									<blockquote class="bk1 nomargin nopadding">								
										<p class="sm-bottom20 fw300">This is your doorway to home away from home! </p>
										<footer>
											Team NewWindsorite
											
										</footer>
									</blockquote>
								</div>
								<div class="item">
									<blockquote class="bk1 nomargin nopadding">								
										<p class="sm-bottom20 fw300">Getting yourself cognizant to the city of Windsor couldn't get easier!</p>
										<footer>
											Team NewWindsorite
										</footer>
									</blockquote>
								</div>
							</div>
						</div>
					</div>	
				</div>
				
			</section>
			
			
			<!-- SKILL
			================================================== -->	
			
			
				<!-- action penal -->
				<div class="container">
					<div class="offset-by-three thirteen columns ">					
						<div class="seperator-action sp-top-bottom80 text-center">
							
							<a href="#" class="btn-bg-black btn-size-1" data-sr="enter bottom over 0.8s and move 140px">|| Explore Windsor ||</a>
						</div>
					</div>
						
				</div>	
				<div class="container">
					
				</div>
				<!-- End action penal -->
				
			</section>
			
			<!-- SECTION NUMBER
			================================================== -->	
			<section class="page-section white-section sp-top-bottom100">
				
						
			</section>	
				
			<!-- GALLERY SLIDER
			================================================== -->	
		

			<!-- SECTION PROCESS
			================================================== -->	
			
						
			<!-- SECTION WORK
			================================================== -->	
			
					
			
			<!-- SECTION ACTION PENAL
			================================================== -->	
			<section class="page-section black-section sp-top-bottom100">
				<div class="container">
					<div class="ten columns">
						<div class="wrapper text-right center-xs">
							<h3 class="hs1 fontalt4 lp5 fw400 sm-bottom10">Interested in working with us?</h3>
							<h4 class="lp5 fontalt4 fw400">Reach out today to get started with || New Windsorite ||.</h4>	
						</div>
					</div>
					<div class="six columns text-center">
						<a href="#" class="btn-bg-white btn-size-3">Get in touch</a>
					</div>
				</div>
			</section>		
			
			<!-- SECTION SERVICES
			================================================== -->
		
								<div class="about-bx8-hover"></div>
							</div>
						</div>
						
					
						</div>
						
						
							
								<div class="about-bx8-hover"></div>
							</div>
						</div>
					</div>
				</div>
				
			</section>
			
			<!-- SECTION APP
			================================================== -->
			<section class="page-section black-section sp-top-bottom100">
				<div class="container">
					
					<div class="seven columns">
										
					</div>
					
					
			</section>
			
			<!-- FEATURE BLOCK
			================================================== -->
			
			
			
			<!-- CONTENT SLIDER
			================================================== -->
			
			
			<!-- PRICING
			================================================== -->
			
			<!-- SHOP STORE
			================================================== -->	
			
			
			
		
			<!-- BLOG
			================================================== -->
			<section id="blog" class="page-section white-section sp-top-bottom100">
				<div class="container">
					<div class="offset-by-three thirteen columns" data-sr="enter top over 0.8s and move 140px">
						<div class="section-title text-center">
							<h2 class="sm-bottom10 fontalt4 lp10">Latest Blog</h2>
							<h3 class="hs1 lp8 side-line"><small>We write Ideas!</small></h3>	
							<div class="sm-top40">
							<p class="text-italic fw400 nomargin">.....BLOG AREA FOR WINDSOR CITY.....</p>							
							</div>
						</div>
					</div>	
				</div>
				
					<!-- End Post -->
				
			
			</section>		
			
			<hr class="nomargin nopadding"/>
			<div class="subscribe_section">
				<a href="JavaScript:void(0);" class="show_hide_section hs1 fontalt4 lp3">Subscribe <i class="fa fa-level-down"></i></a>
			</div>
			
			<!-- SUBSCRIBE
			================================================== -->
			<section class="page-section white-section slidingDiv1 inside_content">
				<div class="container">
					<div class="sixteen columns">
						<div class="section-title text-center sm-top-bottom100">
							<h2 class="hs2 fontalt4 fw400 lp2"> Stay informed with our newsletter </h2>		
							<form method="post" action="subscribe.php" class="subscribe-form">
								<div class="subscribe-empty">
									<input type="email" name="email" id="subscribe-email" class="txt-subscribe" placeholder="Email Address" required />					
									<span class="btn-subscribe-container">
										<button id="subscribe-submit" class="btn-subscribe lp3">Notify me...</button>
										<img src="images/ajax-loader.gif" alt="Loading..." width="32" height="32" id="subscribe-loading">
									</span>					
									<div class="subscribe-error-field"></div>
								</div>
								<div class="subscribe-message"></div>
							</form>							
						</div>
					</div>		
				</div>
			</section>
			
			<!-- VISIT US
			================================================== -->
			<section class="page-section black-section sp-top-bottom100">
				<div class="container">
					<div class="one-third column">
						<div class="about-bx4 clearfix">
							<div class="bx4-icon colortext">
								<i class="myicon-map-pin"></i>
							</div>
							<div class="bx4-content">
								<h3 class="hs2 fontalt4 lp2">Visit us</h3>
								<p>401, Sunset Avenue, Windsor, ON, Canada</p>
							</div>	
						</div>										
					</div>						
					
					<div class="one-third column">
						<div class="about-bx4 clearfix">
							<div class="bx4-icon colortext">
								<i class="myicon-pencil"></i>
							</div>
							<div class="bx4-content">
								<h3 class="hs2 fontalt4 lp2">Write us</h3>
								<p>Email : <a href="mailto:mail@newwindsorite.com" title="">mailxyz@newwindsorite.com</a></p>
							</div>	
						</div>										
					</div>
					
					<div class="one-third column">
						<div class="about-bx4 clearfix">
							<div class="bx4-icon colortext">
								<i class="myicon-phone"></i>
							</div>
							<div class="bx4-content">
								<h3 class="hs2 fontalt4 lp2">Call us</h3>
								<p>Office +1 519 992 4039</p>
							</div>	
						</div>										
					</div>
					
					
				</div>
			</section>
			
			<!-- SECTION ACTION 
			================================================== -->
			<div class="page-section call-to-action white-section sp-top-bottom100 bg-overlay-light-alfa60" data-background="images/home/image24.jpg">
				<div class="container">
					<div class="ten columns">
						
					</div>
					<div class="six columns text-center">
						<a href="#" class="btn-border-black btn-size-3">Get in touch</a>
					</div>
				</div>
			</div>

			<!-- FOOTER
			================================================== -->	
			<section class="page-section grey-section footer sp-top80 sp-bottom100">	
				<div class="container">
					<div class="sixteen columns text-center" data-sr="enter bottom over 0.8s and move 140px">	
						
						<!-- FOOTER SOCIAL LINK FOR SMALL DEVICES
						================================================== -->	
					
						<!-- FOOTER SOCIAL LINK FOR LARGE DEVICES
						================================================== -->	
						<div class="share clearfix">
							<button class="share-toggle-button">
								<i class="share-icon fa fa-share-alt"></i>
							</button>
							<ul class="share-items">
								<li class="share-item">
									<a href="#" class="share-button">
										<i class="share-icon fa fa-facebook"></i>
									</a>
								</li>
								<li class="share-item">
									
								</li>
								<li class="share-item">
									<a href="#" class="share-button">
										<i class="share-icon fa fa-pinterest"></i>
									</a>
								</li>
								<li class="share-item">
									<a href="#" class="share-button">
										<i class="share-icon fa fa-tumblr"></i>
									</a>
								</li>
							</ul>
						</div>	
						
						<div class="footer-text sm-top60 clearfix">
                        	<!-- Copyright -->
							<div class="footer-cr fw900">	
							<a href="index.html">&copy; New Windsorite</a>.
							</div>
							<!-- End Copyright -->
							<div class="footer-madeby">
								Made with love by Team ||New Windsorite||.
							</div>
							
						</div>
						
					</div>
				</div>
				
				<!-- ACROLL TO TOP
				================================================== -->			
				<div class="scroll-to-top"><i class="fa fa-angle-up"></i></div>
			</section>
	
		</main>		

	</div>
	
	<!-- JAVASCRIPT
    ================================================== -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/materialPreloader.js"></script>
<script type="text/javascript" src="js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="js/modernizr.custom.js"></script> 
<script type="text/javascript" src="js/jquery.sticky.js"></script>
<script type="text/javascript" src="js/jquery.countTo.js"></script>
<script type="text/javascript" src="js/jquery.appear.js"></script>
<script type="text/javascript" src="js/jquery.easing.js"></script>	
<script type="text/javascript" src='js/smooth-scroll.js'></script>
<script type="text/javascript" src="js/owl.carousel.min.js"></script>
<script type='text/javascript' src="js/jquery.magnific-popup.min.js"></script>
<script type="text/javascript" src="js/jquery.parallax-1.1.3.js"></script>
<script type="text/javascript" src="js/scrollReveal.min.js"></script>
<script type="text/javascript" src="js/TweenMax.min.js"></script>
<script type="text/javascript" src="js/share.js"></script>
<script type="text/javascript" src="js/jquery.animsition.min.js"></script>

<script type="text/javascript">
(function($) { "use strict";
	$(document).ready(function() {
	  
	  $(".animsition").animsition({
	  
		inClass               :   'fade-in',
		outClass              :   'fade-out',
		inDuration            :    1500,
		outDuration           :    800,
		linkElement           :   '.animsition-link', 
		// e.g. linkElement   :   'a:not([target="_blank"]):not([href^=#])'
		loading               :    true,
		loadingParentElement  :   'body', //animsition wrapper element
		loadingClass          :   'animsition-loading',
		unSupportCss          : [ 'animation-duration',
								  '-webkit-animation-duration',
								  '-o-animation-duration'
								],
		//"unSupportCss" option allows you to disable the "animsition" in case the css property in the array is not supported by your browser. 
		//The default setting is to disable the "animsition" in a browser that does not support "animation-duration".
		
		overlay               :   false,
		
		overlayClass          :   'animsition-overlay-slide',
		overlayParentElement  :   'body'
	  });
	});  
})(jQuery);
</script>

<script type="text/javascript" src="js/jquery.themepunch.tools.min.js"></script>   
<script type="text/javascript" src="js/jquery.themepunch.revolution.min.js"></script> 

<script type="text/javascript" src="js/cycle2.js"></script>
<script type="text/javascript" src="js/jquery.hoverdir.js"></script> 
<script type="text/javascript" src="js/isotope.js"></script>
<script type="text/javascript" src="js/imagesloaded.pkgd.min.js"></script> 
<script type="text/javascript" src="js/masonry.pkgd.min.js"></script>
<script type="text/javascript" src="js/script.js"></script> 

<script type="text/javascript">
(function($) {
	"use strict";
	$(document).ready(function() {
		
		//Gallery Slider
		$('.gallery-slider').cycle({fx:'scrollHorz',pager:'.slider-control-nav',pause:1,speed:300,slides:'.slide',swipe:true,timeout:3500});
	
		jQuery('.gpre').on("click",function(){
			$('.gallery-slider').cycle('prev');
		});
		jQuery('.gnext').on("click",function(){
			$('.gallery-slider').cycle('next');
		});
		
		/* Service hoverdir
		================================================= */		
		$('.about-bx8').each( function() { $(this).hoverdir(); } );
		
		//Mesonry Service Block
		init_masonry();
		
		//PORTFOLIO FILTER 
		
		var $container = $('.projects-wrapper');
		var $filter = $('#filter');
		// Initialize isotope 
		$container.isotope({
			filter: '*',
			layoutMode: 'masonry',
			animationOptions: {
				duration: 750,
				easing: 'linear'
			}
		});
		// Filter items when filter link is clicked
		$filter.find('a').click(function () {
			var selector = $(this).attr('data-filter');
			$filter.find('a').removeClass('current');
			$(this).addClass('current');
			$container.isotope({
				filter: selector,
				animationOptions: {
					animationDuration: 750,
					easing: 'linear',
					queue: false,
				}
			});
			return false;
		});	
		/*END*/
		
		
	});  
	
	function init_masonry(){
		(function($){    
		
			$(".masonry").imagesLoaded(function(){
				$(".masonry").masonry();
			});
			
		})(jQuery);
	}

})(jQuery);
</script>
<script type="text/javascript">
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

</script>

<!-- End Document
================================================== -->
</body>
</html>