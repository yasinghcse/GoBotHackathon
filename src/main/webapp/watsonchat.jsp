<%@ page import="wasdev.windsor.resources.*"%>
<%
		UserProfile user1 = null;
		if (session != null) {
			user1 = (UserProfile) session.getAttribute("UserProfile");
		}
		if (user1 == null) {
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/login.jsp");
			reqDispatcher.forward(request, response);
		} 
%>

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

	<!--Owl carousel-->
	<link rel="stylesheet" href="css/owl.carousel.css"/>

	<!--Content Animation-->
	<link rel="stylesheet" href="css/animsition.min.css"/>

	<!--venobox lightbox-->
	<link rel="stylesheet" href="css/magnific-popup.css"/>

	<!-- bootstrap -->
	<link rel="stylesheet" href="css/bootstrap.css"/>

	<!--Common Style-->
	<link rel="stylesheet" href="css/style.css"/>

	<link rel="stylesheet" href="css/watsonStyle.css" />
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<!-- Favicons
	================================================== -->

	<link rel="shortcut icon" href="favicon.png">
	<link rel="apple-touch-icon" href="apple-touch-icon.png">
	<link rel="apple-touch-icon" sizes="72x72" href="apple-touch-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="114x114" href="apple-touch-icon-114x114.png">

</head>
<body>

	<div class="animsition" data-animsition-in="fade-in" data-animsition-out="fade-out">

	<!-- Navigation panel
		================================================== -->
		<nav class="main-nav js-stick">
			<div class="full-wrapper relative clearfix">
			
				<!-- Logo -->
				<div class="header-logo-wrap">
					<div class = "" style="font-size: 26px; margin-top: 21px; border: 2px solid #000; padding: 8px 14px;" >|| New Windsorite ||</div>
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
						<li><a href="home.jsp" class="active">Home</a></li>
						<li><a href="about.jsp" class="active">About</a></li>
						<li><a href="contact.jsp" class="active">Contact</a></li>
						<li><a href="login.jsp" class="active">Login</a></li>
						<li><a href="register.jsp" class="active">Register</a></li>
						<%
							} else {
						%>
						<li><a href="home.jsp" class="active">Home</a></li>
						<li><a href="about.jsp" class="active">About</a></li>
						<li><a href="contact.jsp" class="active">Contact</a></li>
						<li>
							<a href="recommend.jsp" class="active">Recommendations</a>							
						</li>
						<li>
							<a href="watsonchat.jsp" class="active">Talk To Me</a>							
						</li>
						<li><a href="/Windsorite/Controller?act=logout"
							class="active">Log Out</a></li>
						<li><a href="profile.jsp" class="active">Profile</a></li>
						<li><a href="register.jsp" class="active">Register</a></li>
						<%
							}
						%>

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
		<div class = "whole" >
			<div class="container1">
				<div class="jumbotron" id="container"></div>
			</div>
			<div id="controls">
				<textarea class="form-control" rows="1" id="textbox"
					placeholder="Enter your message here .."></textarea>
				<button type="button" class="btn btn-primary" style="display: none;"
					id="send">Send</button>
				<input type="checkbox" id="enter" style="display: none;"
					checked="true" style = "display:none"" /> <label style="display: none;">Send
					on enter</label>
			</div>
		</div>

	</div>

	<!-- JAVASCRIPT
    ================================================== -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src = "script/chatboxScript.js"></script>
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

<script type="text/javascript" src="js/bootstrap.min.js"></script>
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

<script type="text/javascript" src="js/smk-accordion.js"></script>
<script type="text/javascript" src="js/script.js"></script>

<script type="text/javascript">
(function($) { "use strict";

	$(document).ready(function() {
	 	$(".accordion").smk_Accordion({
				closeAble: true
				
		});
	});

})(jQuery);
</script>

<!-- End Document
================================================== -->
</body>
</html>
