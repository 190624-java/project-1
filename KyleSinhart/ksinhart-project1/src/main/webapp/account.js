document.getElementById("cardRow").onclick=()=>{
    console.log("Working?");
    let xhr = new XMLHttpRequest();

    xhr.open('GET', baseurl + 'app/info');

    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let info = JSON.parse(xhr.response);

                writeHomeAndPhone(info);
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

function writeHomeAndPhone(arr){
    
}