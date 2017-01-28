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
	
	<!--Icon font-->
	<link rel="stylesheet" href="css/font-awesome.min.css" />
	<link rel="stylesheet" href="fonts/essential-icons/essential-regular-styles.css" />
	
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
					<div class = "col-sm-4" style="color: #ffffff;font-size: 26px; margin-top: 21px; border: 2px solid #000; padding: 8px 14px;font-style: #ffffff;" >New Windsorite</div>
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
						
						
						
						<!-- Divider -->
						<li><a>&nbsp;</a></li>
						<!-- End Divider -->
											
						<!-- Languages -->
						<li>
							<a href="#" class="menu-down"><i class="fa fa-twitter"></i></a>													
							
						</li>
						<!-- End Languages -->						
						
						<!-- Address -->
						<li class="hide_menu_item">
							<a href="#" class="menu-down hs1"><i class="fa fa-map-marker"></i></a>
							<ul class="nav-sub sp-top-bottom40 to-left">								
								<li><a class="text-center" href="/wincity/login.html">Get Started</a><strong>Get your Up to date buzz about the City of Windsor</strong></li>														
							</ul>
						</li>
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
			
			<!-- TOP SECTION
			================================================== -->
			
			<section class="page-section black-section innerpage-heading-1 bg-overlay-dark-alfa80 parallax-1" data-background="images/home/image61.jpg">
				<div class="relative container">
					<div class="page-heading text-center">
						<p class="text-italic side-line">Let's</p>
						<h1 class="sm-bottom10 fontalt4 hs4">Get in touch</h1>	
						<h3 class="hs1 fw400 fontalt4 lp2">Get closer to the heart of Windsor.</h3>
					</div>						
				</div>				
			</section>	
			
			
			<!-- VISIT US
			================================================== -->
			<section class="page-section white-section sp-top-bottom40">
				<div class="container">
					<div class="one-third column">
						<div class="about-bx4 clearfix">
							<div class="bx4-icon">
								<i class="icon icon-essential-regular-88-pin"></i>
							</div>
							<div class="bx4-content">
								<h3 class="hs2 fontalt4 lp1">Visit us</h3>
								<p>|| New Windsorite ||, 401 Sunset Avenue, Windsor, ON, Canada.</p>
							</div>	
						</div>										
					</div>						
					
					<div class="one-third column">
						<div class="about-bx4 clearfix">
							<div class="bx4-icon">
								<i class="icon icon-essential-regular-42-pen"></i>
							</div>
							<div class="bx4-content">
								<h3 class="hs2 fontalt4 lp1">Write us</h3>
								<p>Email : <a href="mailto:mail@company.com" title="">mail@company.com</a></p>
							</div>	
						</div>										
					</div>
					
					<div class="one-third column">
						<div class="about-bx4 clearfix">
							<div class="bx4-icon">
								<i class="icon icon-essential-regular-44-phone"></i>
							</div>
							<div class="bx4-content">
								<h3 class="hs2 fontalt4 lp1">Call us</h3>
								<p>Office +1 23 8756473</p>
							</div>	
						</div>										
					</div>
					
				</div>
			</section>
			
			<!-- FOOTER BOTTOM
			================================================== -->
			<section class="page-section grey-section">
			
				<div class="col col2 grey-section ap-link">
					<div class="icon-box text-center">
						<i class="pe-7s-coffee"></i>
					</div>
					
						<div class="clearfix">
								
							<div class="col col1">
								<h3 class="hs1 fontalt4">Location</h3>
								<p>401 Sunset Avenue, Windsor, ON, Canada.<p>
							</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="col col2 black-section ap-link">
					<div class="icon-box text-center">
						<i class="pe-7s-portfolio"></i>
					</div>
					<div class="section-title-5 center-xs">
						<h3 class="hs3 fontalt">Say something!</h3>	
						<div class="sm-top-bottom40">
												
						</div>
						<form autocomplete="off" id="c_form" class="form ">
						
							<div class="clearfix">
								
								<div class="col col1">
									
									<!-- Name -->
									<div class="form-group">
										<input type="text" required="" pattern=".{3,100}" placeholder="Name" class="full_width" id="name" name="name" style="">
									</div>
								
									<!-- Email -->
									<div class="form-group">
										<input type="email" required="" pattern=".{5,100}" placeholder="Email" class="full_width" id="email" name="email" style="">
									</div>
									
								</div>
								
								<div class="col col1">
									
									<!-- Message -->
									<div class="form-group">                                            
										<textarea placeholder="Message" rows="6" style="height:89px" class="full_width" id="message" name="message"></textarea>
									</div>
									
								</div>
								
							</div>
                                
							<div class="clearfix">
								
								<div class="col col1">							
									                              
									<div class="form-tip sp-top20">
										<i class="fa fa-info-circle"></i> All the fields are required
									</div>
									
								</div>
								
								<div class="col col1">							
									
									<div class="sp-top20">
										<button id="submit_btn" class="btn-bg-white btn-size-1 fontalt4 lp2">Submit Message</button>
									</div>
									
								</div>
								
							</div>
							
                            <div id="result"></div>
							
						</form>
					</div>
				</div>
				
			</section>
			
			<hr class="nomargin nopadding"/>
						
			
			<!-- GOOGLE MAP
			================================================== -->
            <div class="google-map">
                <div data-address="410, Sunset Avenue, Windsor, Ontario, Canada" id="map-canvas"></div>
            </div>
			
			<!-- FOOTER
			================================================== -->	
			<section class="page-section grey-section footer sp-top80 sp-bottom100">	
				<div class="container">
					<div class="sixteen columns text-center" data-sr="enter bottom over 0.8s and move 140px">	
						
						<!-- FOOTER SOCIAL LINK FOR SMALL DEVICES
						================================================== -->	
						<div class="footer-social-links">
							<a target="_blank" title="Facebook" href="#"><i class="fa fa-facebook"></i></a>
							<a target="_blank" title="Twitter" href="#"><i class="fa fa-twitter"></i></a>
							<a target="_blank" title="Behance" href="#"><i class="fa fa-behance"></i></a>
							<a target="_blank" title="LinkedIn+" href="#"><i class="fa fa-linkedin"></i></a>
							<a target="_blank" title="Pinterest" href="#"><i class="fa fa-pinterest"></i></a>
						</div>
						
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
									<a href="#" class="share-button">
										<i class="share-icon fa fa-twitter"></i>
									</a>
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
							<a target="_blank" href="#">&copy; || New Windsorite ||</a>.
							</div>
							<!-- End Copyright -->
							<div class="footer-madeby">
								Made with love by Team || New Windsorite ||.
							</div>
							
						</div>
						
					</div>
				</div>
				
				<!-- ACROLL TO TOP
				================================================== -->			
				<div class="scroll-to-top"><i class="fa fa-angle-up"></i></div>
			</section>
	
		</main>		

	<!-- JAVASCRIPT
    ================================================== -->
<script type="text/javascript" src="js/jquery.min.js"></script>
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
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"></script>
<script type="text/javascript" src="js/gmap3.min.js"></script>
<script type="text/javascript" src="js/map-init.js"></script>
<script type="text/javascript" src="js/contact-form.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<!--[if lt IE 10]><script type="text/javascript" src="js/placeholder.js"></script><![endif]--> 	  
<!-- End Document
================================================== -->
</body>
</html>