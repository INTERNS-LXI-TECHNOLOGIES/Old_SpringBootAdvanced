 	// Get the dialog-box
var dialogBox = document.getElementById('id01');
var number;

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == dialogBox) {
        dialogBox.style.display = "none";
    }
}

function setPhoneNumber(n) {
	number=n;
	document.getElementById("yes").href="delete?link="+number;
	document.getElementById('id01').style.display='block';
}