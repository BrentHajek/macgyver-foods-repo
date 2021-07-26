import LogInPage from './pages/LogInPage';
const container = document.querySelector('.container'),
const LogInButton = document.querySelector('.LogIn__Form_Button');
let LogIns = [
    {
        username: 'leepowe', 
        password: 'NoPassword'
    }
]
function getInfo(){
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    console.log('your username  is ' + username + ' and your password is ' + password);
    for(i = 0; i < LogIns.length; i++) {
        if(username == LogIns[i].username && password == LogIns[i].password) {
            console.log(username + ' is logged in!')
            return
        }
    }
    console.log('incorrect username or password')
}