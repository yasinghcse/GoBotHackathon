/* ---------------------------------------------
 Contact form
 --------------------------------------------- */
$(document).ready(function(){
    $("#submit_btn").click(function(){        
       
        var user_name = $('input[name=name]').val();
        var user_email = $('input[name=email]').val();
        var user_message = $('textarea[name=message]').val();
        var emailReg = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/igm;
    	 
        //Valiadation
        var proceed = true;
        if (user_name == "") {
            $('input[name=name]').css('border-color', '#e41919');
            proceed = false;
        }
        if (user_email == "") {
            $('input[name=email]').css('border-color', '#e41919');
            proceed = false;
        }
        if (!emailReg.test(user_email)) {
			$('input[name=email]').css('border-color', '#e41919');
            proceed = false;
		}
        if (user_message == "") {
            $('textarea[name=message]').css('border-color', '#e41919');
            proceed = false;
        }
                
        if (proceed) {
			
			var data_string = $('#c_form').serialize();
			
			$('#submit_btn').fadeOut();
			
			 $.ajax({
				type: "POST",
				url: "contact-form.php",
				data: data_string,

				//success
				success: function (data) {
				
                    $('#result').html('<div class="success"><i class="fa fa-check contact-success"></i><span>Your message has been sent.</span></div>').fadeIn();
                    //reset values in all input fields
                    $('#c_form input').val('');
                    $('#c_form textarea').val('');
					
					$("#c_form").hide().slideDown();
				},
				error: function (data) {
                    $('#result').html('<div class="error"><i class="fa fa-exclamation contact-error"></i><span>Something went wrong, please try again later.</span></div>').fadeIn();
					//output = '<div class="error">' + response.text + '</div>';
				}

			}) //end ajax call
        }
        
        return false;
    });
    
    //reset border colors and hide all message on .keyup()
    $("#c_form input, #c_form textarea").keyup(function(){
        $("#c_form input, #c_form textarea").css('border-color', '');
        $("#result").slideUp();
    });
    
});
