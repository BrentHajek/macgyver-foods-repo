import apiActions from './api-actions/api-actions.js';
import ParentPage from './pages/ParentPage.js';
import AllergyComponent from './components/AllergyComponent.js';
import AddChildPage from './pages/AddChildPage.js';
import DeleteChildPage from './pages/DeleteChildPage.js';
import FoodCategories from './components/FoodCategories.js';
import FoodCategory from './components/FoodCategory.js';
import RecipeInstructions from './components/RecipeInstructions.js';
import RecipeIngredients from './components/RecipeIngredients.js';
import AddIngredientPage from './pages/AddIngredientPage.js';
import DeleteIngredientPage from './pages/DeleteIngredientPage.js';
import AddPreferencePage from './pages/AddPreferencePage.js';
import Child from './components/Child.js';
import DeletePreferencePage from './pages/DeletePreferencePage.js';
import RecipeIngredientsListPage from './pages/RecipeIngredientsListPage.js';

buildPage();

function buildPage() {
    renderProfileInfo();
    navAllergies();
    navFoodCategories();
    test();
}

const app = document.querySelector('#app');


const apiKeyNum = '4d2f51bba03b42a59ba6d0843ac5b5f9';
// const apiKeyNum = '733246d3691c4203855fd5063ee214b6';
// const apiKeyNum = '00f757b09028492da86c30d8109241c0';
// const apiKeyNum = '985a2080f8094fdea57cb96fa855b0dd';
// const apiKeyNum = '78bc7509124db458df764b454c2dc1e57807eff5';
// const apiKeyNum = 'd16a986f5295496bb236ca7062f1841a';

function renderProfileInfo() {
    const profileButton = document.querySelector('#profile_button');
    profileButton.addEventListener('click', () => {
        apiActions.getRequest('http://localhost:8080/parents/93', (parents) => {
            wireUpParent(parents);
        });
    });
}

function wireUpParent(parents) {
    app.innerHTML = ParentPage(parents);
    navToAddChildPage();
    navToDeleteChildPage();
    createChild();
    deleteChild();
    AddIngredientToParent();
    navToAddIngredientPage();
    navToDeleteIngredientPage();
    deleteIngredientFromParent();
    navToAddPreferencePage();
    addPreferenceToChild();
    navToDeletePreferencePage();
    deletePreferenceFromChild();
    toggleChildren();
}

function toggleChildren() {
    const childNames = document.querySelectorAll('.child__name');
    console.log(childNames);
    childNames.forEach((childName) => {
        console.log(childName);
        childName.addEventListener('click', (event) => {
            
            
            console.log(event);
            if(event.target.classList.contains('child__name')) {
                if(event.target.parentElement.style.visibility !== 'visible'){
                    event.target.parentElement.style.visibility = 'visible';
                    event.target.parentElement.style.height = '20%';
                } else {
                    event.target.parentElement.style.visibility = 'hidden';
                    event.target.parentElement.style.height = '20px';
                }
            }
            navToDeletePreferencePage();
            navToAddPreferencePage();
            addPreferenceToChild();
            deletePreferenceFromChild();
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
            apiActions.postRequest('http://localhost:8080/parents/93/add-child', {
                'firstName': firstName,
                'lastName': lastName,
                'age': age
            }, (parents) => {
                console.log(parents);
                app.innerHTML = ParentPage(parents);
                navToDeleteChildPage();
                navToAddChildPage();
                navToAddIngredientPage();
                navToDeleteIngredientPage();
                toggleChildren();
                navToAddPreferencePage();
                navToDeletePreferencePage();
            });
        }
    });
}

function deleteChild() {
    app.addEventListener('click', (event) => {
        if(event.target.classList.contains('delete_child_submit')){
            const firstName = event.target.parentElement.querySelector('#delete_child_firstName').value;
            apiActions.deleteRequest('http://localhost:8080/parents/93/delete-child', {
                'firstName': firstName
            }, (parents) => {
                app.innerHTML = ParentPage(parents)
                navToDeleteChildPage();
                navToAddChildPage();
                navToAddIngredientPage();
                navToDeleteIngredientPage();
                toggleChildren();
                navToAddPreferencePage();
                navToDeletePreferencePage();
            });
        }
    });
}

function navAllergies() {
    const app = document.querySelector('#app');
    app.addEventListener('click', (event) => {
        if (event.target.classList.contains('allergy-list-btn')) {
            childId = event.target.parentElement.parentElement.querySelector('input').value;
            apiActions.getRequest('http://localhost:8080/allergies', allergies => {
                app.innerHTML = AllergyComponent(allergies);
            });
        }
    });
    submitAllergySelections();
}

let allergyCount = 0;
function submitAllergySelections() {
    const app = document.querySelector('#app');
    app.addEventListener('click', (event) => {
        if (event.target.classList.contains('submit-allergies-btn')) {
            var allergiesToAdd = [];
            allergyCount = 0;
            currentAllergyCount = 0;
            var allAllergies = app.querySelectorAll('.allergies');
            allAllergies.forEach((currentAllergy) => {
                if (currentAllergy.checked) {
                    var checkedAllergy = currentAllergy.value;
                    allergiesToAdd.push(checkedAllergy);
                    allergyCount++;
                }
                else {

                }
            });
            allergiesToAdd.forEach(addAllergiesToChildProfile);
        }
    });
}

let currentAllergyCount = 0;
function addAllergiesToChildProfile(allergy) {
    apiActions.postRequest(`http://localhost:8080/children/${childId}/add-allergy`, {'allergy': allergy}, allergies => {
        currentAllergyCount++;
        if (currentAllergyCount == allergyCount) {
            apiActions.getRequest('http://localhost:8080/parents/93', (parents) => {
                wireUpParent(parents);
            });
        }
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

function navToAddIngredientPage() {
    const navToAddIngredientButton = document.querySelector('.add_ingredient_plus');
    navToAddIngredientButton.addEventListener('click', () => {
        app.innerHTML = AddIngredientPage();
    });
}

function AddIngredientToParent() {
    app.addEventListener('click', (event) => {
        if(event.target.classList.contains('add_ingredient_submit')) {
            const ingredient = event.target.parentElement.querySelector('#add_ingredient_name').value;
            makePostToAddIngredient(ingredient);
        }
    });
}

function makePostToAddIngredient(ingredient) {
    apiActions.postRequest('http://localhost:8080/parents/93/add-ingredient', {
        'ingredient': ingredient
    }, (parents) => {
        app.innerHTML = ParentPage(parents);
        navToDeleteChildPage();
        navToAddChildPage();
        navToAddIngredientPage();
        navToDeleteIngredientPage();
        toggleChildren();
        navToAddPreferencePage();
        navToDeletePreferencePage();
    });
}


function test() {
    const testButton = document.querySelector('#test');
    testButton.addEventListener('click', () => {
        apiActions.getRequest('http://localhost:8080/parents/93', (parents) => {
            let stringName = '';
            for (let i = 0; i < parents.ingredients.length; i++) {
                stringName += parents.ingredients[i].ingredient.toLowerCase() + ',';
            }
            apiActions.getRequest(`http://localhost:8080/children/${childId}`, (child) => {
                let stringName2 = '';
                for (let i = 0; i < child.allergies.length; i++) {
                    stringName2 += child.allergies[i].allergy.toLowerCase() + ',';
                }
                apiActions.getRequest(`http://localhost:8080/children/${childId}`, (child) => {
                    let stringName3 = '';
                    for(let i = 0; i < child.preferences.length; i++) {
                        stringName3 += child.preferences[i].preference.toLowerCase() + ',';
                    }
                    let stringInclude = stringName + stringName3;
                    let stringExclude = stringName2;
                    const parsedString = stringInclude.substring(0,stringInclude.length -1) ;
                    console.log(stringInclude);
                    console.log([parsedString]);
                    console.log(stringExclude);


                    apiActions.getRequest(`https://api.spoonacular.com/recipes/complexSearch?apiKey=${apiKeyNum}&includeIngredients=${parsedString}&intolerances=${stringExclude}&fillIngredients=true&number=10`, (recipes) => {
                        console.log(recipes);
                        app.innerHTML = RecipeIngredientsListPage(recipes);
                        // const recipeId = recipes.results[0].id;
                        // apiActions.getRequest(`https://api.spoonacular.com/recipes/${recipeId}/analyzedInstructions?apiKey=${apiKeyNum}`, (recipeInstructions) => {
                        //     // console.log(recipeInstructions);
                        //     app.innerHTML += RecipeInstructions(recipeInstructions);
                        // })
                    })
                })
            })
        })
    })
}

// function navToSingleRecipePage() {
//     const navToSingleRecipePageButton = document.querySelector('.ingredient_title');
//     navToSingleRecipePageButton.addEventListener('click', () => {
//         app.innerHTML = 
//     })
// }

function navToDeleteIngredientPage() {
    const navToDeleteIngredientPageButton = document.querySelector('.delete_ingredient_minus');
    navToDeleteIngredientPageButton.addEventListener('click', () => {
        app.innerHTML = DeleteIngredientPage();
    });
}

function deleteIngredientFromParent() {
    app.addEventListener('click', (event) => {
        if(event.target.classList.contains('delete_ingredient_submit')) {
            const ingredient = event.target.parentElement.querySelector('#delete_ingredient_name').value;
            apiActions.deleteRequest('http://localhost:8080/parents/93/delete-ingredient', {
                'ingredient': ingredient
            }, (parents) => {
                app.innerHTML = ParentPage(parents);
                navToDeleteChildPage();
                navToAddChildPage();
                navToAddIngredientPage();
                navToDeleteIngredientPage();
                toggleChildren();
                navToAddPreferencePage();
                navToDeletePreferencePage();
            });
        }
    });
}
let childId = 0;

function navToAddPreferencePage() {
    const navToAddPreferencePageButton = document.querySelectorAll('.add_preference_plus');
    for( const navToAddPreferencePageButton of navToAddPreferencePageButton) {
        navToAddPreferencePageButton.addEventListener('click', (event) => {
             childId = event.target.parentElement.parentElement.querySelector("input").value;
             console.log(childId);
            app.innerHTML = AddPreferencePage();
        });
    }
}

function addPreferenceToChild() {
    app.addEventListener('click', (event) => {
        if(event.target.classList.contains('add_preference_submit')) {
            const preference = event.target.parentElement.querySelector('#add_preference_name').value;
            console.log(childId);
            apiActions.postRequest(`http://localhost:8080/children/${childId}/add-preference`, {
                'preference': preference
            }, (child) => {
                Child(child);
                apiActions.getRequest('http://localhost:8080/parents/93', (parents) => {
                    app.innerHTML = ParentPage(parents);
                    navToAddChildPage();
                    navToDeleteChildPage();
                    createChild();
                    deleteChild();
                    AddIngredientToParent();
                    navToAddIngredientPage();
                    navToDeleteIngredientPage();
                    deleteIngredientFromParent();
                    navToAddPreferencePage();
                    addPreferenceToChild();
                    navToDeletePreferencePage();
                    deletePreferenceFromChild();
                    toggleChildren();
        });
            })
        }
    });
}

function navToDeletePreferencePage() {
    const navToDeletePreferencePageButton = document.querySelectorAll('.delete_preference_minus');
    for(const navToDeletePreferencePageButton of navToDeletePreferencePageButton) {
        navToDeletePreferencePageButton.addEventListener('click', (event) => {
            childId = event.target.parentElement.parentElement.querySelector('input').value;
            console.log(childId);
            app.innerHTML = DeletePreferencePage();
        });
    }
}

function deletePreferenceFromChild() {
    app.addEventListener('click', (event) => {
        if(event.target.classList.contains('delete_preference_submit')) {
            const preference = event.target.parentElement.querySelector('#delete_preference_name').value;
            console.log(childId);
            apiActions.deleteRequest(`http://localhost:8080/children/${childId}/delete-preference`, {
                'preference': preference
            }, (child) => {
                Child(child);
                apiActions.getRequest('http://localhost:8080/parents/93', (parents) => {
                    app.innerHTML = ParentPage(parents);
                    navToAddChildPage();
                    navToDeleteChildPage();
                    createChild();
                    deleteChild();
                    AddIngredientToParent();
                    navToAddIngredientPage();
                    navToDeleteIngredientPage();
                    deleteIngredientFromParent();
                    navToAddPreferencePage();
                    addPreferenceToChild();
                    navToDeletePreferencePage();
                    deletePreferenceFromChild();
                    toggleChildren();
        });
            })
        }
    });
}