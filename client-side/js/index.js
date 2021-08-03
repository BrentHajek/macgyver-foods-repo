import apiActions from './api-actions/api-actions.js';
import ParentPage from './pages/ParentPage.js';
import Child from './components/Child.js';
import AllergyComponent from './components/AllergyComponent.js';


buildPage();

function buildPage() {
    renderProfileInfo();
    navAllergies();
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

function navAllergies() {
    const allergyElem = document.querySelector('.allergy-list-btn');
    allergyElem.addEventListener('click', () => {
        apiActions.getRequest('http://localhost:8080/allergies', allergies => {
            app.innerHTML = AllergyComponent(allergies);
        });
    });
}