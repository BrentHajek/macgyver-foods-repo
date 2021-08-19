export default function SignInJs() {
    // const loginForm = document.getElementById("login-form");
    // const loginButton = document.getElementById("login-form-submit");
    // const loginErrorMsg = document.getElementById("login-error-msg");

    // loginButton.addEventListener("click", (e) => {
    //     e.preventDefault();
    //     const username = loginForm.username.value;
    //     const password = loginForm.password.value;

    //     if (username === "user" && password === "teammacgyver") {
    //         alert("You have successfully logged in.");
    //         window.location.assign('https://www.espn.com')
    //         // location.reload();
    //     } else {
    //         loginErrorMsg.style.opacity = 1;
    //     }
    // })
    
    /** Modal **/
    let modal = document.getElementById("myModal");
    let btn = document.getElementById("sign_in");
    let span = document.getElementsByClassName("close")[0];

    btn.onclick = function () {
        modal.style.display = "block";
    }

    span.onclick = function () {
        modal.style.display = "none";
    }

    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
}