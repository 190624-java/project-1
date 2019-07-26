{
    var baseurl = 'http://localhost:8080/project1/';
    let part = document.getElementById("doLogout");
    if (part) {
        part.addEventListener('click', () => {
            console.log("logout was clicked");
            //possibly ajax call to destroy session variable?
            let xhr = new XMLHttpRequest();

            xhr.open('POST', baseurl + 'app/logout');

            xhr.onreadystatechange = () => {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        console.log('logged out');
                        window.location.href = "http://localhost:8080/project1/login.html";
                    }
                    else {
                        console.log(`Ajax responded with status code: ` + xhr.status);
                    }
                }
            };
            xhr.send();
        });
    }
}