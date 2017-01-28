// index.js

// request message on server
//Calls SimpleServlet to get the "Hello World" message
xhrGet("Controller?act=getRecommendations", function(responseText){
	// add to document
	var mytitle = document.getElementById('message');
	console.log(responseText);
		
	//---------------
	var test = JSON.parse(responseText);
	//console.log(test.TrafficCharacter);
	var count =1;
	for(var event in test){
		console.log("*****************************");
		
		//console.log("Event :" + event);
		
	    var dataCopy = test[event];
	    var test1="";
	    for(key in dataCopy){
	        //console.log(dataCopy[key]);
	        test1+=dataCopy[key]+ "<br>";
	    }
	    console.log("count" + count);
	    if(event == "TrafficCharacter"){
	    	event = "Road Blockages";
	    }
	    else if (event == "forgot things"){
	    	event = "Waste Collection Schedule";
	    }
	    else if(event == "SocialCharacter"){
	    	event = "Events in Windsor";
	    }
	    console.log("event" + event);
	    console.log("test1" + test1);
	    if(count == 1){
			document.getElementById("rec1").style.display ="block";
			document.getElementById('title1').innerHTML =event; 
			document.getElementById('r1').innerHTML =test1;
		}
		else if(count == 2){
			document.getElementById("rec2").style.display ="block";
			document.getElementById('title2').innerHTML =event;
			document.getElementById('r2').innerHTML =test1;
		}
		else if(count == 3){
			document.getElementById("rec3").style.display ="block";
			document.getElementById('title3').innerHTML =event;
			document.getElementById('r3').innerHTML =test1;
		}
	    
	    count++;
	}
	
	//Loading the other profile info
	loadProfile();
	
}, function(err){
	console.log(err);
});

//utilities
function createXHR(){
	if(typeof XMLHttpRequest != 'undefined'){
		return new XMLHttpRequest();
	}else{
		try{
			return new ActiveXObject('Msxml2.XMLHTTP');
		}catch(e){
			try{
				return new ActiveXObject('Microsoft.XMLHTTP');
			}catch(e){}
		}
	}
	return null;
}
function xhrGet(url, callback, errback){
	var xhr = new createXHR();
	xhr.open("GET", url, true);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				callback(xhr.responseText);
			}else{
				errback('service not available');
			}
		}
	};
	xhr.timeout = 3000;
	xhr.ontimeout = errback;
	xhr.send();
}


//get connection to get the Profile info
function loadProfile() {
  var xhttp;
  xhttp=new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      displayProfile(xhttp.responseText);
    }
  };
  xhttp.open("GET", "Controller?act=getRecommendationsProfile", true);
  xhttp.send();
}

//correctly display the Profile info
function displayProfile(message){
	console.log("messgae" + message);
	var test = JSON.parse(message);
	var count =1;
	console.log("size" + test.length);
	for(var characters in test){
 			var dataCopy = test[characters];
			console.log("Charater recieved = " + characters );
			if(characters == "name"){
				document.getElementById("username").style.display ="block";
				document.getElementById("usernametext").style.display ="block";
				document.getElementById('usernametext').innerHTML =dataCopy;
			}
			else if (characters == "email") {
				document.getElementById("useremail").style.display ="block";
				document.getElementById("useremailtext").style.display ="block";
				document.getElementById('useremailtext').innerHTML =dataCopy;
			}
			else if (characters == "address") {
				document.getElementById("useraddress").style.display ="block";
				document.getElementById("useraddresstext").style.display ="block";
				document.getElementById('useraddresstext').innerHTML =dataCopy;
			}
			else if (characters == "zipcode") {
				document.getElementById("userzipcode").style.display ="block";
				document.getElementById("userzipcodetext").style.display ="block";
				document.getElementById('userzipcodetext').innerHTML =dataCopy;
			}
	}
}

