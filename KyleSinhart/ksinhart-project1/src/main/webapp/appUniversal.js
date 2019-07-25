{
    let part = document.getElementById("doLogout");
    if(part){
        part.addEventListener('click',()=>{
            console.log("logout was clicked");
            //possibly ajax call to destroy session variable?
            window.location.href = "http://localhost:8080/project1/login.html";
        });
    }
}