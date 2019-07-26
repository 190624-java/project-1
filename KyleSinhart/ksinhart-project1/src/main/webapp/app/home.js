{
    document.getElementById("goAccount").addEventListener("click", ()=>{
        console.log('was clicked');
        window.location.href = "http://localhost:8080/project1/app/account.html";
    });
    document.getElementById("goSubmit").addEventListener("click", ()=>{
        console.log('was clicked');
        window.location.href = "http://localhost:8080/project1/app/submit.html";
    });
    document.getElementById("goReimbursement").addEventListener("click", ()=>{
        console.log('was clicked');
        window.location.href = "http://localhost:8080/project1/app/viewReimbursements.html";
    });
}