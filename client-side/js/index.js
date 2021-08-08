import apiActions from './api-actions/api-actions.js';
import ParentPage from './pages/ParentPage.js';
import AllergyComponent from './components/AllergyComponent.js';
import AddChildPage from "./pages/AddChildPage.js"
import DeleteChildPage from "./pages/DeleteChildPage.js"
import RecipeInstructions from './components/RecipeInstructions.js';
import RecipeIngredients from './components/RecipeIngredients.js';
import AddIngredientPage from './pages/AddIngredientPage.js';
import DeleteIngredientPage from './pages/DeleteIngredientPage.js';
import AddAllergyPage from './pages/AddAllergyPage.js';


buildPage();

function buildPage() {
    renderProfileInfo();
    navAllergies();
}

const app = document.querySelector('#app');

// const apiKeyNum = "78bc7509124db458df764b454c2dc1e57807eff5";
const apiKeyNum = "d16a986f5295496bb236ca7062f1841a";
// const apiKeyNum = "4d2f51bba03b42a59ba6d0843ac5b5f9";
// const apiKeyNum = "733246d3691c4203855fd5063ee214b6";
// const apiKeyNum = "00f757b09028492da86c30d8109241c0";
// const apiKeyNum = "985a2080f8094fdea57cb96fa855b0dd";

function renderProfileInfo() {
    const profileButton = document.querySelector('#profile_button');
    profileButton.addEventListener('click', () => {
        apiActions.getRequest('http://localhost:8080/parents/89', (parents) => {
            app.innerHTML = ParentPage(parents);
            navToAddChildPage();
            navToDeleteChildPage();
            createChild();
            deleteChild();
            AddIngredientToParent();
            renderRecipeInstructions();
            navToAddIngredientPage();
            navToDeleteIngredientPage();
            deleteIngredientFromParent();
        });
    });
}

function navToAddChildPage() {
        const navToAdd = document.querySelector('.add_child_plus');
        navToAdd.addEventListener('click', ()=>{
            app.innerHTML = AddChildPage();
        })   
}

function navToDeleteChildPage() {
    const deleteChildButton = document.querySelector('.delete_child_minus');
    deleteChildButton.addEventListener('click', () => {
        app.innerHTML = DeleteChildPage();
    })
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
                navToDeleteChildPage();
                navToAddChildPage();
                navToAddIngredientPage();
                navToDeleteIngredientPage();
            });
        }
    })
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
                navToAddIngredientPage();
                navToDeleteIngredientPage();
                });
            }
        })
}

function navAllergies() {
    const allergyElem = document.querySelector('.allergy-list-btn');
    allergyElem.addEventListener('click', () => {
        apiActions.getRequest('http://localhost:8080/allergies', allergies => {
            app.innerHTML = AllergyComponent(allergies);
        });
    });
}

function renderRecipeInstructions() {
    const recipeInstructionsButton = document.querySelector('#recipe_button');
    recipeInstructionsButton.addEventListener('click', () => {
        apiActions.getRequest(`https://api.spoonacular.com/recipes/findByIngredients?apiKey=${apiKeyNum}&ingredients=apples,+peaches,+milk&number=1`, (recipes) => {
            console.log(recipes);
            const recipeId = recipes[0].id;
            app.innerHTML = RecipeIngredients(recipes);
            apiActions.getRequest(`https://api.spoonacular.com/recipes/${recipeId}/analyzedInstructions?apiKey=${apiKeyNum}`, (recipeInstructions) => {
                console.log(recipeInstructions);
                app.innerHTML += RecipeInstructions(recipeInstructions);
            })
        })
    })
}

// function renderRecipeIngredients() {
//     const testButton =document.querySelector('#recipe_test');
//     testButton.addEventListener('click', () => {
//         apiActions.getRequest('https://api.spoonacular.com/recipes/findByIngredients?apiKey=733246d3691c4203855fd5063ee214b6&ingredients=apples,+peaches,+milk&number=1', (recipeIngredients) => {
//             app.innerHTML = RecipeIngredients(recipeIngredients);
//         })
//     })
// }

// function renderRecipeInstructions() {
//     const recipeInstructionsButton = document.querySelector('#recipe_button');
//     recipeInstructionsButton.addEventListener('click', () => {
//         apiActions.getRequest('https://api.spoonacular.com/recipes/324694/analyzedInstructions?apiKey=733246d3691c4203855fd5063ee214b6', (recipeInstructions) => {
//             app.innerHTML = RecipeInstructions(recipeInstructions);
//         })
//     })
// }

function navToAddIngredientPage() {
    const navToAddIngredientButton = document.querySelector('.add_ingredient_plus');
    navToAddIngredientButton.addEventListener('click', () => {
        app.innerHTML = AddIngredientPage();
    })
}

function AddIngredientToParent() {
    app.addEventListener('click', (event) => {
        if(event.target.classList.contains('add_ingredient_submit')) {
            const ingredient = event.target.parentElement.querySelector('#add_ingredient_name').value;
            apiActions.postRequest('http://localhost:8080/parents/89/add-ingredient', {
                "ingredient": ingredient
            }, (parents) => {
                app.innerHTML = ParentPage(parents);
                navToDeleteChildPage();
                navToAddChildPage();
                navToAddIngredientPage();
                navToDeleteIngredientPage();
            })
        }
    })
}

function navToDeleteIngredientPage() {
    const navToDeleteIngredientPageButton = document.querySelector('.delete_ingredient_minus');
    navToDeleteIngredientPageButton.addEventListener('click', () => {
        app.innerHTML = DeleteIngredientPage();
    })
}

function deleteIngredientFromParent() {
    app.addEventListener('click', (event) => {
        if(event.target.classList.contains('delete_ingredient_submit')) {
            const ingredient = event.target.parentElement.querySelector('#delete_ingredient_name').value;
            apiActions.deleteRequest('http://localhost:8080/parents/89/delete-ingredient', {
                "ingredient": ingredient
            }, (parents) => {
                app.innerHTML = ParentPage(parents);
                navToDeleteChildPage();
                navToAddChildPage();
                navToAddIngredientPage();
                navToDeleteIngredientPage();
            })
        }
    })
}

