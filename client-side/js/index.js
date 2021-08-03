import apiActions from './api-actions/api-actions.js';
import ParentPage from './pages/ParentPage.js';
// import Child from './components/Child.js';

buildPage();

function buildPage() {
    renderProfileInfo();
}

const app = document.querySelector('#app');


function renderProfileInfo() {
    const profileButton = document.querySelector('#profile_button');
    profileButton.addEventListener('click', () => {
        apiActions.getRequest('http://localhost:8080/parents/84', (parents) => {
            app.innerHTML = ParentPage(parents);
        });
    });
}