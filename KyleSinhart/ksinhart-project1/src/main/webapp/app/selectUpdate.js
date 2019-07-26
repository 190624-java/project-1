var baseurl = 'http://localhost:8080/project1/';

{
    //get var from localstorage
    console.log("Working?");
    //xhttp.send("fname=Henry&lname=Ford"); and set it in the post with this
    let xhr = new XMLHttpRequest();

    xhr.open('POST', baseurl + 'app/viewall');

    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let reimbursement = JSON.parse(xhr.response);
                for (let re in reimbursement) {
                    addReimbursementToTable(reimbursement[re]);
                }
            }
            else {
                console.log(`Ajax responded with status code: ` + xhr.status);
            }
        }
    };
    //xhr.responseText(`emp_id=${emp_id}`);
    xhr.send();
};
function addReimbursementToTable(re) {
    let newRow = document.createElement('tr');
    let idCol = document.createElement('td');
    let empIdCol = document.createElement('td');
    let statusCol = document.createElement('td');
    let amountCol = document.createElement('td');
    let dateCol = document.createElement('td');
    let descriptionCol = document.createElement('td');
    let managerCol = document.createElement('td');
    //coordinate id with the button id
    //let buttonCol = document.createElement('td').id=re.re_id;

    //let btn = document.createElement

    idCol.innerText = re.re_id;
    empIdCol.innerText = re.emp_id;
    //setup if else to print words for status
    if (re.re_status === 0) {
        statusCol.innerText = 'Unprocessed';
    }
    else if (re.re_status === 1) {
        statusCol.innerText = 'Approved';
    }
    else if (re.re_status === 2) {
        statusCol.innerText = 'Denied';
    }
    amountCol.innerText = `$${re.amount}` ;
    dateCol.innerText = re.date_of;
    descriptionCol.innerText = re.description;
    managerCol.innerText = re.manager_id;

    newRow.appendChild(idCol);
    newRow.appendChild(empIdCol);
    newRow.appendChild(statusCol);
    newRow.appendChild(amountCol);
    newRow.appendChild(dateCol);
    newRow.appendChild(descriptionCol);
    newRow.appendChild(managerCol);

    document.getElementById('re-table-body').appendChild(newRow);
};
/*
document.getElementById("goUpdate").onclick = () => {

    let re_id = document.getElementById('re_id').value;
    let status = document.getElementById('status').value;

    let re_obj = {re_id:re_id,re_status:status};

    console.log("Working?");
    //xhttp.send("fname=Henry&lname=Ford"); and set it in the post with this
    let xhr = new XMLHttpRequest();

    xhr.open('POST', baseurl + 'app/reupdate');

    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                location.reload();
                
            }
            else {
                console.log(`Ajax responded with status code: ` + xhr.status);
            }
        }
    };
    //xhr.responseText(`emp_id=${emp_id}`);
    /*
    let a=JSON.stringify(re_obj);
    console.log(a);
    xhr.send(a);
    *//*
    xhr.send(`re_id=${re_id}&re_status=${status}`);
};
*/