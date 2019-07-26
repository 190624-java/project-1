var baseURL = "http://localhost:8080/J2Inc";

var user = null;
var pendings = null;

//================================================================
//  Tab Responsivity
//================================================================
document.getElementById("tab2").ontoggle = () => {

    if (pendings == null) {
        pendings = getPendings();
    } //else just let the HTML display the existing view that was previously retrieved

};


//================================================================
//  Tab Refreshers
//================================================================
// These functions destroy the associated table data and call the 
// server for data.
//----------------------------------------------------------------

/**
 * Refetches from the server, the pending requests.
 * It does so by first clearing the existing pendings list (not just setting it to null, but 
 *  deleting the associated html elements that was created from it).
 * Then, it calls getPendings and reassigns the pendings.
 */
function refreshPendings() {
    destroyPendings();
    pendings = getPendings();
}
function destroyPendings(){

}

//================================================================
//  Tab Data Getters
//================================================================
// These functions are the ones talking to the server to get 
// data.
//----------------------------------------------------------------

/**
 * Gets Pending Requests for the session userID
 */
function getPendings() {
    let xhr = new XMLHttpRequest();

    let message = "";

    xhr.open("POST", baseURL + "/app/", true);

    xhr.onreadystatechange = () => {
        if (this.readyState === 4) { //i.e. "DONE" i.e. opened, sent, headers received, loading data completed.
            if (this.status === 200) { //i.e. DONE responding i.e. "OK"

                //If the servlet didn't redirect, then this will not get the tag referenced, 
                // because it won't be there.
                //There won't be responseText
                //It shouldn't even give a status of 200, because the redirect to another page will happen.
                message = this.responseText;
                document.getElementById("InvalidCredentials").innerText = message;
            }
        }
    }

    //xhr.send();
    xhr.send("userID=");
}


//================================================================
//  Tab HTML Constructors
//================================================================
// These functions take the server-returned JSON to Javascript 
// objects and populate/build the tables/elements.  
//----------------------------------------------------------------




