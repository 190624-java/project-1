var baseurl = 'http://localhost:8080/project1/';

{
    console.log("Working?");
    let xhr = new XMLHttpRequest();

    xhr.open('GET', baseurl + 'app/info');

    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let e = JSON.parse(xhr.response);

                writeHomeAndPhone(e);
                //for (let re in reimbursement) {
               //     addReimbursementToTable(reimbursement[re]);
               // }
            }
            else {
                console.log(`Ajax responded with status code: ` + xhr.status);
            }
        }
    };
    xhr.send();
};

function writeHomeAndPhone(e){
    //write to hometown card
    document.getElementById('hometown').innerText = e.hometown;
    //write to phone card
    document.getElementById('phone').innerText = e.phone;

}