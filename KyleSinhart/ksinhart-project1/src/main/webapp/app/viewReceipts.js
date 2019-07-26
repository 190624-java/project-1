var baseurl = 'http://localhost:8080/project1/';


{
    //get var from localstorage
    let re_id = localStorage.getItem("re_id");
    localStorage.clear();
    console.log("Working?");
    //xhttp.send("fname=Henry&lname=Ford"); and set it in the post with this
    let xhr = new XMLHttpRequest();

    xhr.open('POST', baseurl + 'app/reclist');

    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let receipt = JSON.parse(xhr.response);
                for (let rec in receipt) {
                    addReceiptToTable(receipt[rec]);
                }
            }
            else {
                console.log(`Ajax responded with status code: ` + xhr.status);
            }
        }
    };
    //xhr.responseText(`emp_id=${emp_id}`);
    xhr.send(JSON.stringify(re_id));
};

function addReceiptToTable(rec) {

    //FIX THE TABLE STUFF


    let newRow = document.createElement('tr');
    let idCol = document.createElement('td');
    let reIdCol = document.createElement('td');
    let amountCol = document.createElement('td');
    let vnameCol = document.createElement('td');
    //let photoCol = document.createElement('td');

    //let btn = document.createElement
   // let photo = receiptView(rec.rec_id);
    //console.log(photo);

    idCol.innerText = rec.rec_id;
    reIdCol.innerText = rec.re_id;
    amountCol.innerText = `$${rec.amount}`;
    vnameCol.innerText = rec.vendor_name;
    //photoCol.innerHTML = `<img src="data:image/png;base64,${photo}"/>`;

    newRow.appendChild(idCol);
    newRow.appendChild(reIdCol);
    newRow.appendChild(amountCol);
    newRow.appendChild(vnameCol);
    //newRow.appendChild(photoCol);

    document.getElementById('rec-table-body').appendChild(newRow);
};

function receiptView(rec_id) {
    let xhr = new XMLHttpRequest();

    xhr.open('GET', baseurl + 'app/reclist?rec_id=' + rec_id);
    xhr.responseType = "arraybuffer";

    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                arrayBuffer=xhr.response;
                if (arrayBuffer) {
                    //var byteArray = new Uint8Array(arrayBuffer);
                   // console.log(byteArray);
                    //let blob = new Blob([byteArray], {type: contentType});
                    return arrayBuffer;
                }

            }
        }
        //xhr.responseText(`emp_id=${emp_id}`);
    };
    xhr.send();
}
document.getElementById('goBack').onclick = () => {
    console.log('going back');
    window.location.href = "http://localhost:8080/project1/app/managerHome.html";
};