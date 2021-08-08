import apiActions from './api-actions/api-actions.js';
import ParentPage from './pages/ParentPage.js';
import AllergyComponent from './components/AllergyComponent.js';
import AddChildPage from "./pages/AddChildPage.js"
import DeleteChildPage from "./pages/DeleteChildPage.js"
import FoodCategories from './components/FoodCategories.js';
import FoodCategory from './components/FoodCategory.js';

buildPage();

function buildPage() {
    renderProfileInfo();
    navAllergies();
    navFoodCategories();
}

const app = document.querySelector('#app');

function renderProfileInfo() {
    const profileButton = document.querySelector('#profile_button');
    profileButton.addEventListener('click', () => {
        apiActions.getRequest('http://localhost:8080/parents/89', (parents) => {
            app.innerHTML = ParentPage(parents);
            navToAddChildPage();
            navToDeleteChildPage();
            createChild();
            deleteChild();
        });
    });
}

function navToAddChildPage() {
    const navToAdd = document.querySelector('.add_child_plus');
    navToAdd.addEventListener('click', ()=>{
        app.innerHTML = AddChildPage();
    });
}

function navToDeleteChildPage() {
    const deleteChildButton = document.querySelector('.delete_child_minus');
    deleteChildButton.addEventListener('click', () => {
        app.innerHTML = DeleteChildPage();
    });
}

function createChild() {
    app.addEventListener('click', (event) => {
        if(event.target.classList.contains('add_child_submit')){
            const firstName = event.target.parentElement.querySelector('#add_child_firstName').value;
            const lastName = event.target.parentElement.querySelector('#add_child_lastName').value;
            const age = event.target.parentElement.querySelector('#add_child_age').value;
            apiActions.postRequest('http://localhost:8080/parents/89/add-child', {
                "firstName": firstName,
                "lastName": lastName,
                "age": age
            }, (parents) => {
                console.log(parents);
                app.innerHTML = ParentPage(parents);
                navToAddChildPage();
                navToDeleteChildPage();
            });
        }
    });
}

function deleteChild() {
    app.addEventListener('click', (event) => {
        if(event.target.classList.contains('delete_child_submit')){
            const firstName = event.target.parentElement.querySelector('#delete_child_firstName').value;
            apiActions.deleteRequest('http://localhost:8080/parents/89/delete-child', {
                "firstName": firstName
            }, (parents) => {
                app.innerHTML = ParentPage(parents)
                navToDeleteChildPage();
                navToAddChildPage();
            });
        }
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

function navFoodCategories() {
    const foodCategoryElem = document.querySelector('.preference-list-btn');
    foodCategoryElem.addEventListener('click', () => {
        const app = document.querySelector('#app');
        apiActions.getRequest('http://localhost:8080/foodCategories', foodCategories => {
            app.innerHTML =FoodCategories(foodCategories);
        });
    });
    renderFoodCategoryIngredients();
}

function renderFoodCategoryIngredients() {
    const app = document.querySelector('#app');
    app.addEventListener('click', () => {
        if (event.target.classList.contains('food-category-name')) {
            const foodCategoryId = event.target.querySelector('#foodCategoryId').value;
            apiActions.getRequest(`http://localhost:8080/foodCategories/${foodCategoryId}`, foodCategory => {
                app.innerHTML = FoodCategory(foodCategory);
            });
        }
    });
}