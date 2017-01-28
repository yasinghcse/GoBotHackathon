function loadDoc(url, cFunction) {
  var xhttp;
  xhttp=new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      cFunction(this);
    }
  };
  var str= document.getElementById("firstname").value;
  xhttp.open("GET", "WatsonInteraction?question="+str, true);
  xhttp.send();
}
function myFunction(xhttp) {
  document.getElementById('lastname').value =
  xhttp.responseText;
}


function resetConversation() {
	var xhttp;
	console.log("inside reset conversation");
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log("got response");
			document.getElementById("lastname").value = xhttp.responseText;
		}
	};
		var str=1;
		console.log("opening connection");
		xhttp.open("GET", "WatsonInteraction?new="+str, true);
		xhttp.send();
}
window.onload = function() {
	resetConversation();
}