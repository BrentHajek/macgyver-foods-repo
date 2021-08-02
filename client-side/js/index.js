// const container = document.querySelector('.container');
// container.innerText = 'hello world!';

import apiActions from './api-actions/api-actions.js';
import ParentComponent from './components/ParentComponent.js';
import ChildComponent from './components/ChildComponent.js';
import AllergyComponent from './components/AllergyComponent.js';

buildPage();

function buildPage() {
    allergyChecklist();
}

function allergyChecklist() {
    const app = document.querySelector('#app');
    app.innerHTML = AllergyComponent();
}