// const container = document.querySelector('.container');
// container.innerText = 'hello world!';

import apiActions from './api-actions/api-actions.js';
import ParentComponent from './components/ParentComponent.js';
import ChildComponent from './components/ChildComponent.js';
import AllergyComponent from './components/AllergyComponent.js';

buildPage();

function buildPage() {
    navAllergies();
}

function navAllergies() {
    const allergyElem = document.querySelector('.allergy-list-btn');
    allergyElem.addEventListener('click', () => {
        const app = document.querySelector('#app');
        apiActions.getRequest('http://localhost:8080/allergies', allergies => {
            app.innerHTML = AllergyComponent(allergies);
        });
    });
}