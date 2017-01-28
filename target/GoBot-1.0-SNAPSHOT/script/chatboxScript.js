var userName="";

//bot display function
function displayBotMessage(message){
  var prevMessage = $('#container').html();
  console.log("message**" + message);
  console.log("message.length**" + message.length);

  if(prevMessage.length >6){
    prevMessage= prevMessage + "<br>";
  }
  $('#container').html(prevMessage +
  "<span class = 'currMessage'><div class='alert alert-success' id='dialog-box'><span class = 'bot' =>Watson: </span>" +
  message + "</div></span>");
  $('#container').scrollTop($('#container').prop("scrollHeight"));
}

//bot message function
function getMessage() {
  displayBotMessage("Hi, What can i call you ?");
}

//bot regular function
function watsonAIHandling(message){
  if(userName.length < 1){
    userName=message;

    displayBotMessage("Nice to meet you " + userName + "!!");
    resetConversation();
    console.log(userName+ "2");
  }
  else{
    loadDoc('WatsonInteraction', message);
  }

}

//Function getting loaded on the starting
$(function() {

  //starting function
  getMessage();

  $('#textbox').keypress(function(event){
    if(event.which == 13){
      if( $('#enter').prop("checked")){
        $('#send').click();
        event.preventDefault();
      }
    }
  });

  $('#send').click(function(){
    var userName = "<span class = 'username' =>You: </span>";
    var userMessage = $("#textbox").val();
    $('#textbox').val("");
    var prevMessage = $('#container').html();
    if(prevMessage.length >6){
      prevMessage= prevMessage + "<br>";
    }
    $('#container').html( prevMessage + "<div class='alert alert-info' id='dialog-box1'>" + userName + userMessage + "</div>");
    $('#container').scrollTop($('#container').prop("scrollHeight"));
    watsonAIHandling(userMessage);
  });

});

function loadDoc(url, message) {
  var xhttp;
  xhttp=new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      displayBotMessage(xhttp.responseText);
    }
  };
  var str= message;
  xhttp.open("GET", "WatsonInteraction?question="+str, true);
  xhttp.send();
}


function resetConversation() {
	var xhttp;
	console.log("inside reset conversation");
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log("got response");
			displayBotMessage(xhttp.responseText);
		}
	};
		var str=1;
		console.log("opening connection");
		xhttp.open("GET", "WatsonInteraction?new="+str, true);
		xhttp.send();
}
