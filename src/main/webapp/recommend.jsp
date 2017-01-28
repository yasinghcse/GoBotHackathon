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
<!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<head>

<!-- Page header
	================================================== -->
<meta charset="utf-8">
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="author" content="" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- Page Title
	================================================== -->
<title>|| NEW WINDSORITE ||</title>

<!-- CSS
	================================================== -->

<!--A dead simple, responsive boilerplate-->
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/skeleton.css" />

<!--Icon font-->
<link rel="stylesheet" href="css/font-awesome.min.css" />

<!--Owl carousel-->
<link rel="stylesheet" href="css/owl.carousel.css" />

<!--Content Animation-->
<link rel="stylesheet" href="css/animsition.min.css" />

<!--venobox lightbox-->
<link rel="stylesheet" href="css/magnific-popup.css" />

<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css" />

<!--Common Style-->
<link rel="stylesheet" href="css/style.css" />

<!-- Favicons
	================================================== -->

<link rel="shortcut icon" href="favicon.png">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="apple-touch-icon-114x114.png">

</head>
<body>

	<div class="animsition" data-animsition-in="fade-in"
		data-animsition-out="fade-out">

		<!-- Navigation panel
		================================================== -->
		<nav class="main-nav js-stick">
			<div class="full-wrapper relative clearfix">

				<!-- Logo -->
				<div class="header-logo-wrap">
					<div class=""
						style="font-size: 26px; margin-top: 21px; border: 2px solid #000; padding: 8px 14px;">New
						Windsorite</div>
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
						<li><a href="#" class="menu-down"><i
								class="fa fa-twitter"></i></a></li>
						<!-- End Languages -->

						<!-- Address -->
						<li class="hide_menu_item"><a href="#" class="menu-down hs1"><i
								class="fa fa-map-marker"></i></a>
							<ul class="nav-sub sp-top-bottom40 to-left">
								<li><a class="text-center" href="/wincity/login.html">Get
										Started</a><strong>Get your Up to date buzz about the
										City of Windsor</strong></li>
							</ul></li>
						<!-- End Address -->

					</ul>
				</div>
				<!-- End Main Menu -->

			</div>
		</nav>
		<!-- End Navigation panel -->

		<!-- MAIN CONTENT
		================================================== -->
		<main class="cd-main-content"> <!-- TOP SECTION
			================================================== -->
		<section class="page-section black-section innerpage-heading-2"
			style="padding-top: 44px; padding-bottom: 0px;">
			<div class="container">
				<div class="col-sm-4">
					<div class="page-heading ph-left">
						<h1 class="sm-bottom10 fontalt4 hs3">Recommendation Page</h1>
						<h3 class="hs1 fw400 fontalt4 lp2">Here are your some ideas</h3>
					</div>
				</div>
				<div class="col-sm-8">
					<div class="col-sm-6"></div>
					<div class="col-sm-6" style="text-align: left;">
						<table>
							<tr>
								<h3 class="hs1 fw400 fontalt4 lp2" id="username"
									style="display: none;">
									Username:<span id="usernametext" style="display: none;"></span>
								</h3>
							</tr>
							<tr>
								<h3 class="hs1 fw400 fontalt4 lp2" id="useremail"
									style="display: none;">
									Email:<span id="useremailtext" style="display: none;"></span>
								</h3>
							</tr>
							<tr>
								<h3 class="hs1 fw400 fontalt4 lp2" id="useraddress"
									style="display: none;">
									Address:<span id="useraddresstext" style="display: none;"></span>
								</h3>
							</tr>
							<tr>
								<h3 class="hs1 fw400 fontalt4 lp2" id="userzipcode"
									style="display: none;">
									ZipCode:<span id="userzipcodetext" style="display: none;"></span>
								</h3>
							</tr>
						</table>
					</div>

				</div>
			</div>
		</section>






		<div class="col-sm-12" style="margin-top: 3%;">
			<div class="col-sm-12">

				<div class="col-sm-2"></div>
				<div class="col-sm-8"
					style="font-size: 26px; margin-top: 21px; border: 2px solid #000; padding: 8px 14px;">
					<!-- ACCORDION STYLE
			================================================== -->
					<section>
						<div class="#">
							<div class="#">
								<div class="accordion">
									<div class="accordion_in" id="rec1" style="display: none;">
										<div class="acc_head black-section" id="title1"></div>
										<div class="acc_content white-section">
											<p id="r1"></p>
										</div>
									</div>

									<div class="accordion_in" id="rec2" style="display: none;">
										<div class="acc_head black-section" id="title2"></div>
										<div class="acc_content white-section">
											<p id="r2"></p>
										</div>
									</div>

									<div class="accordion_in" id="rec3" style="display: none;">
										<div class="acc_head black-section" id="title3"></div>
										<div class="acc_content white-section">
											<p id="r3"></p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>
				</div>
			</div>

		</div>


		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<!-- ACCORDION STYLE
			================================================== -->

		</div>
		<div class="col-sm-2"></div>

		<!-- FOOTER
			================================================== -->
		<section
			class="page-section grey-section footer sp-top80 sp-bottom100">
			<div class="container">
				<div class="sixteen columns text-center"
					data-sr="enter bottom over 0.8s and move 140px">

					<!-- FOOTER SOCIAL LINK FOR SMALL DEVICES
						================================================== -->
					<div class="footer-social-links">
						<a target="_blank" title="Facebook" href="#"><i
							class="fa fa-facebook"></i></a> <a target="_blank" title="Twitter"
							href="#"><i class="fa fa-twitter"></i></a> <a target="_blank"
							title="Behance" href="#"><i class="fa fa-behance"></i></a> <a
							target="_blank" title="LinkedIn+" href="#"><i
							class="fa fa-linkedin"></i></a> <a target="_blank" title="Pinterest"
							href="#"><i class="fa fa-pinterest"></i></a>
					</div>

					<!-- FOOTER SOCIAL LINK FOR LARGE DEVICES
						================================================== -->
					<div class="share clearfix">
						<button class="share-toggle-button">
							<i class="share-icon fa fa-share-alt"></i>
						</button>
						<ul class="share-items">
							<li class="share-item"><a href="#" class="share-button">
									<i class="share-icon fa fa-facebook"></i>
							</a></li>
							<li class="share-item"><a href="#" class="share-button">
									<i class="share-icon fa fa-twitter"></i>
							</a></li>
							<li class="share-item"><a href="#" class="share-button">
									<i class="share-icon fa fa-pinterest"></i>
							</a></li>
							<li class="share-item"><a href="#" class="share-button">
									<i class="share-icon fa fa-tumblr"></i>
							</a></li>
						</ul>
					</div>

					<div class="footer-text sm-top60 clearfix">
						<!-- Copyright -->
						<div class="footer-cr fw900">
							<a target="_blank" href="#">&copy;New Windsorite</a>.
						</div>
						<!-- End Copyright -->
						<div class="footer-madeby">Made by Team NewWindsorite</div>

					</div>

				</div>
			</div>

			<!-- ACROLL TO TOP
				================================================== -->
			<div class="scroll-to-top">
				<i class="fa fa-angle-up"></i>
			</div>
		</section>

		</main>

	</div>

	<!-- JAVASCRIPT
    ================================================== -->
	<script src="script/recommendationpage.js"></script>
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
		(function($) {
			"use strict";
			$(document).ready(
					function() {

						$(".animsition").animsition(
								{

									inClass : 'fade-in',
									outClass : 'fade-out',
									inDuration : 1500,
									outDuration : 800,
									linkElement : '.animsition-link',
									// e.g. linkElement   :   'a:not([target="_blank"]):not([href^=#])'
									loading : true,
									loadingParentElement : 'body', //animsition wrapper element
									loadingClass : 'animsition-loading',
									unSupportCss : [ 'animation-duration',
											'-webkit-animation-duration',
											'-o-animation-duration' ],
									//"unSupportCss" option allows you to disable the "animsition" in case the css property in the array is not supported by your browser.
									//The default setting is to disable the "animsition" in a browser that does not support "animation-duration".

									overlay : false,

									overlayClass : 'animsition-overlay-slide',
									overlayParentElement : 'body'
								});
					});
		})(jQuery);
	</script>

	<script type="text/javascript" src="js/smk-accordion.js"></script>
	<script type="text/javascript" src="js/script.js"></script>

	<script type="text/javascript">
		(function($) {
			"use strict";

			$(document).ready(function() {
				$(".accordion").smk_Accordion({
					closeAble : true
				});
			});

		})(jQuery);
	</script>

	<!-- End Document
================================================== -->
</body>
</html>
