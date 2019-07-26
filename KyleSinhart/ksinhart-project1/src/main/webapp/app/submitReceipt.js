
var baseurl = 'http://localhost:8080/project1/';

document.getElementById("doneRec").onclick = ()=>{
    let xhr = new XMLHttpRequest();

    xhr.open('GET', baseurl + 'app/receipt');

    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let x = xhr.response;
                window.location.href = 'http://localhost:8080/project1/app/home.html';
            }
            else {
                console.log(`Ajax responded with status code: ` + xhr.status);
            }
        }
    };
    //xhr.responseText(`emp_id=${emp_id}`);
    xhr.send();
};