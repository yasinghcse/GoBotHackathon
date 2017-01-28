$(function() {
			$.supersized({
				slide_interval: 4000,
				transition: 1,
				transition_speed: 1000,
				slides: [
					{"image":"images\/home\/image42.jpg","title":"Ultimate theme"},
					{"image":"images\/home\/image45.jpg","title":"Elite quality"},
					{"image":"images\/home\/image33.jpg","title":"Design Studio"}]  		
			});
		});
		
		$(document).ready(function () {
			
			/* Home Slider navigation hover
				================================================= */	
			$('.hover-on').hover(function() {
			  var src= this.src;
			  this.src= src.replace(/\.(gif|png|jpe?g)$/, '-on.$1');
			}, function() {
			  var src= this.src;
			  this.src= src.replace(/-on\.(gif|png|jpe?g)$/, '.$1');
			});
			
			$('.hover-on').each(function() {
				var src= this.src;
				$('<img/>').attr('src', src.replace(/\.(gif|png|jpe?g)$/, '-on.$1'));
			});
		});