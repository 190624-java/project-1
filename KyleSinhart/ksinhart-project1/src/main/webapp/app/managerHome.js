var baseurl = 'http://localhost:8080/project1/';

document.getElementById("getEmployees").onclick = () => {
    //ajax request
    let xhr = new XMLHttpRequest();
    //2
    xhr.open('GET',baseurl+'app/emplist');
    //3
    xhr.onreadystatechange = ()=>{
        if(xhr.readyState === 4 ){
            if(xhr.status===200){
                let employees = JSON.parse(xhr.response);
                for(let e in employees){
                    addEmployeeToTable(employees[e]);
                }
            }
            else{
                console.log(`Ajax responded with status code: `+xhr.status);
            }
        }
    };
    //4
    xhr.send();
};

function addEmployeeToTable(e){
    let newRow = document.createElement('tr');
    let idCol = document.createElement('td');
    let firstCol = document.createElement('td');
    let lastCol = document.createElement('td');
    let emailCol = document.createElement('td');
    let hometownCol = document.createElement('td');
    let phoneCol = document.createElement('td');

    idCol.innerText=e.emp_id;
    firstCol.innerText=e.fname;
    lastCol.innerText=e.lname;
    emailCol.innerText=e.email;
    hometownCol.innerText=e.hometown;
    phoneCol.innerText=e.phone;

    newRow.appendChild(idCol);
    newRow.appendChild(firstCol);
    newRow.appendChild(lastCol);
    newRow.appendChild(emailCol);
    newRow.appendChild(hometownCol);
    newRow.appendChild(phoneCol);

    document.getElementById('emp-table-body').appendChild(newRow);
};

document.getElementById('goEmpRe').addEventListener('click',()=>{
    //console.log("Clicked");
    localStorage.setItem('emp_id',document.getElementById("emp_id").value);
    window.location.href = "http://localhost:8080/project1/app/empReimbursement.html";
});