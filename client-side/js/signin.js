export default function SignInJs() {
  const loginForm = document.getElementById("login-form");
  const loginButton = document.getElementById("login-form-submit");
  const loginErrorMsg = document.getElementById("login-error-msg");

  loginButton.addEventListener("click", (e) => {
    e.preventDefault();
    const username = loginForm.username.value;
    const password = loginForm.password.value;

    if (username === "user" && password === "teammacgyver") {
      alert("You have successfully logged in.");
      window.location.assign('https://www.espn.com')
      // location.reload();
    } else {
      loginErrorMsg.style.opacity = 1;
    }
  })
  // Get the modal
  var modal = document.getElementById("myModal");

  // Get the button that opens the modal
  var btn = document.getElementById("sign_in");

  // Get the <span> element that closes the modal
  var span = document.getElementsByClassName("close")[0];

  // When the user clicks on the button, open the modal
  btn.onclick = function () {
    modal.style.display = "block";
  }

  // When the user clicks on <span> (x), close the modal
  span.onclick = function () {
    modal.style.display = "none";
  }

  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function (event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }
}