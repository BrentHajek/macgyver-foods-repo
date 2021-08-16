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
import Child from './components/Child.js';
import About from './pages/About.js';
import RecipeIngredientsListPage from './pages/RecipeIngredientsListPage.js';
import RecipePage from './pages/RecipePage.js'
import ContactPage from './pages/ContactPage.js';
// import Ingredients from './components/Ingredients.js';
import SignInPage from './pages/SignInPage.js';
import SignInJs from './signin';
import LandingCategories from './components/LandingCategories.js';
import FaqPage from './pages/Faq.js';
import Terms from './pages/Terms.js';
import Privacy from './pages/Privacy.js';
import RemoveAllergy from './components/RemoveAllergy.js';
// import LandingPage from './index.html';
import RemovePreferences from './components/RemovePreferences.js';

buildPage();

function buildPage() {
    renderProfileInfo();
    navAllergies();
    navFoodCategories();
    navigateToContactPage();
    navLandingCategories();
    navFaq();
    navTerms();
    navPrivacy();
    navHome();
    navToAboutPageFooter();
    navToAboutPageMenu();
    navToSignInPage();
}

const app = document.querySelector('#app');

const apiKeyNum = '00f757b09028492da86c30d8109241c0';
// const apiKeyNum = '985a2080f8094fdea57cb96fa855b0dd';
// const apiKeyNum = '78bc7509124db458df764b454c2dc1e57807eff5';
// const apiKeyNum = 'd16a986f5295496bb236ca7062f1841a';
// const apiKeyNum = '4d2f51bba03b42a59ba6d0843ac5b5f9';
// const apiKeyNum = '733246d3691c4203855fd5063ee214b6';

function renderProfileInfo() {
    const profileButton = document.querySelector('#profile_button');
    profileButton.addEventListener('click', () => {
        apiActions.getRequest('http://localhost:8080/parents/203', (parents) => {
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
    toggleChildren();
    navToRecipesPage();
    navToSpecificRecipePage();
    navToSignInPage();
}

function toggleChildren() {
    const childNames = document.querySelectorAll('.child__name');
    console.log(childNames);
    childNames.forEach((childName) => {
        console.log(childName);
        childName.addEventListener('click', (event) => {
            console.log(event);
            if (event.target.classList.contains('child__name')) {
                if (event.target.parentElement.style.visibility !== 'visible') {
                    event.target.parentElement.style.visibility = 'visible';
                    event.target.parentElement.style.height = 'auto';
                } else {
                    event.target.parentElement.style.visibility = 'hidden';
                    event.target.parentElement.style.height = '20px';
                }
            }
        });
    });
}

function navToAddChildPage() {
    const navToAdd = document.querySelector('.add_child_plus');
    navToAdd.addEventListener('click', () => {
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
        if (event.target.classList.contains('add_child_submit')) {
            const firstName = event.target.parentElement.querySelector('#add_child_firstName').value;
            const lastName = event.target.parentElement.querySelector('#add_child_lastName').value;
            const age = event.target.parentElement.querySelector('#add_child_age').value;
            apiActions.postRequest('http://localhost:8080/parents/203/add-child', {
                'firstName': firstName,
                'lastName': lastName,
                'age': age
            }, (parents) => {
                wireUpParent(parents);
            });
        }
    });
}

function deleteChild() {
    app.addEventListener('click', (event) => {
        if (event.target.classList.contains('delete_child_submit')) {
            const firstName = event.target.parentElement.querySelector('#delete_child_firstName').value;
            apiActions.deleteRequest('http://localhost:8080/parents/203/delete-child', {
                'firstName': firstName
            }, (parents) => {
                wireUpParent(parents);
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
        } else if (event.target.classList.contains('delete__allergy_minus')) {
            childId = event.target.parentElement.parentElement.querySelector('input').value;
            apiActions.getRequest(`http://localhost:8080/children/${childId}/allergies`, allergies => {
                app.innerHTML = RemoveAllergy(allergies);
            });
        }
    });
    submitAllergySelections();
}

let allergyCount = 0;

let allergyToRemoveCount = 0;

function submitAllergySelections() {
    const app = document.querySelector('#app');
    app.addEventListener('click', (event) => {
        if (event.target.classList.contains('submit-allergies-btn')) {
            var allergiesToAdd = [];
            allergyCount = 0;
            var allAllergies = app.querySelectorAll('.allergies');
            allAllergies.forEach((currentAllergy) => {
                if (currentAllergy.checked) {
                    var checkedAllergy = currentAllergy.value;
                    allergiesToAdd.push(checkedAllergy);
                    allergyCount++;
                }
            });
            allergiesToAdd.forEach(addAllergiesToChildProfile);
        } else if (event.target.classList.contains('submit-allergies-to-remove-btn')) {
            var allergiesToRemove = [];
            allergyToRemoveCount = 0;
            var allAllergiesToRemove = app.querySelectorAll('.allergies');
            allAllergiesToRemove.forEach((currentAllergy) => {
                if (currentAllergy.checked) {
                    var checkedAllergyToRemove = currentAllergy.value;
                    allergiesToRemove.push(checkedAllergyToRemove);
                    allergyToRemoveCount++;
                }
            });
            allergiesToRemove.forEach(removeAllergiesFromChildProfile);
        }
    });
}

let currentAllergyCount = 0;

function addAllergiesToChildProfile(allergy) {
    apiActions.postRequest(`http://localhost:8080/children/${childId}/add-allergy`, {
        'allergy': allergy
    }, allergies => {
        currentAllergyCount++;
        if (currentAllergyCount == allergyCount) {
            apiActions.getRequest('http://localhost:8080/parents/203', (parents) => {
                currentAllergyCount = 0;
                wireUpParent(parents);
            });
        }
    });
}

let currentAllergiesToRemoveCount = 0;

function removeAllergiesFromChildProfile(allergy) {
    apiActions.deleteRequest(`http://localhost:8080/children/${childId}/delete-allergy`, {
        'allergy': allergy
    }, allergies => {
        currentAllergiesToRemoveCount++;
        if (currentAllergiesToRemoveCount == allergyToRemoveCount) {
            apiActions.getRequest('http://localhost:8080/parents/203', (parents) => {
                currentAllergiesToRemoveCount = 0;
                wireUpParent(parents);
            });
        }
    });
}

let childIdPreference = 0;

function navFoodCategories() {
    const app = document.querySelector('#app');
    app.addEventListener('click', () => {
        if (event.target.classList.contains('preference-list-btn')) {
            childIdPreference = event.target.parentElement.parentElement.querySelector('input').value;
            // childIdPreference = app.querySelector('#childId').value;
            apiActions.getRequest('http://localhost:8080/foodCategories', foodCategories => {
                app.innerHTML = FoodCategories(foodCategories);
            });
            renderFoodCategoryIngredients();
        } else if (event.target.classList.contains('delete_preference_minus')) {
            childIdPreference = event.target.parentElement.parentElement.querySelector('input').value;
            // childIdPreference = app.querySelector('#childId').value;
            apiActions.getRequest(`http://localhost:8080/children/${childIdPreference}/preferences`, preferences => {
                app.innerHTML = RemovePreferences(preferences);
            });
            submitPreferenceSelections();
        }
    });
}

function navLandingCategories() {
    const categoryElem = document.querySelector('#ingredient__categories');
    apiActions.getRequest('http://localhost:8080/foodCategories', foodCategories => {
        console.log(foodCategories);
        categoryElem.innerHTML = LandingCategories(foodCategories);
    });
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
    submitPreferenceSelections();
}

function navToAddIngredientPage() {
    const navToAddIngredientButton = document.querySelector('.add_ingredient_plus');
    navToAddIngredientButton.addEventListener('click', () => {
        app.innerHTML = AddIngredientPage();
    });
}

let preferenceCount = 0;
let preferenceToRemoveCount = 0;

function submitPreferenceSelections() {
    const app = document.querySelector('#app');
    app.addEventListener('click', (event) => {
        if (event.target.classList.contains('submit-btn')) {
            var preferencesToAdd = [];
            preferenceCount = 0;
            var allPreferences = app.querySelectorAll('.preferences');
            allPreferences.forEach((currentPreference) => {
                if (currentPreference.checked) {
                    var checkedPreference = currentPreference.value;
                    preferencesToAdd.push(checkedPreference);
                    preferenceCount++;
                }
            });
            preferencesToAdd.forEach(addPreferencesToChildProfile);
        } else if (event.target.classList.contains('remove-btn')) {
            var preferencesToRemove = [];
            preferenceToRemoveCount = 0;
            var allPreferencesToRemove = app.querySelectorAll('.preferences');
            allPreferencesToRemove.forEach((currentPreference) => {
                if (currentPreference.checked) {
                    var checkedPreferenceToRemove = currentPreference.value;
                    preferencesToRemove.push(checkedPreferenceToRemove);
                    preferenceToRemoveCount++;
                }
            });
            preferencesToRemove.forEach(removePreferencesFromChildProfile);
        }
    });
}

let currentPreferenceCount = 0;

function addPreferencesToChildProfile(preference) {
    apiActions.postRequest(`http://localhost:8080/children/${childIdPreference}/add-preference`, {
        'preference': preference
    }, preferences => {
        currentPreferenceCount++;
        if (currentPreferenceCount == preferenceCount) {
            apiActions.getRequest('http://localhost:8080/parents/203', (parents) => {
                currentPreferenceCount = 0;
                wireUpParent(parents);
            });
        }
    });
}

let currentPreferencesToRemoveCount = 0;

function removePreferencesFromChildProfile(preference) {
    apiActions.deleteRequest(`http://localhost:8080/children/${childIdPreference}/delete-preference`, {
        'preference': preference
    }, preferences => {
        currentPreferencesToRemoveCount++;
        if (currentPreferencesToRemoveCount == preferenceToRemoveCount) {
            apiActions.getRequest('http://localhost:8080/parents/203', (parents) => {
                currentPreferencesToRemoveCount = 0;
                wireUpParent(parents);
            });
        }
    });
}

function AddIngredientToParent() {
    app.addEventListener('click', (event) => {
        if (event.target.classList.contains('add_ingredient_submit')) {
            const ingredient = event.target.parentElement.querySelector('#add_ingredient_name').value;
            makePostToAddIngredient(ingredient);
        }
    });
}

function makePostToAddIngredient(ingredient) {
    apiActions.postRequest('http://localhost:8080/parents/203/add-ingredient', {
        'ingredient': ingredient
    }, (parents) => {
        wireUpParent(parents);
    });
}

function navToRecipesPage() {
    const navToRecipesPageButton = document.querySelectorAll('.search_recipes_button');

    for (const navToRecipesPageButton of navToRecipesPageButton) {
        navToRecipesPageButton.addEventListener('click', (event) => {
            const childId = event.target.parentElement.parentElement.querySelector('input').value;
            apiActions.getRequest('http://localhost:8080/parents/203', (parents) => {
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
                        for (let i = 0; i < child.preferences.length; i++) {
                            stringName3 += child.preferences[i].preference.toLowerCase() + ',';
                        }
                        let stringInclude = stringName + stringName3;
                        let stringExclude = stringName2;
                        const parsedString = stringInclude.substring(0, stringInclude.length - 1);

                        apiActions.getRequest(`https://api.spoonacular.com/recipes/complexSearch?apiKey=${apiKeyNum}&includeIngredients=${parsedString}&intolerances=${stringExclude}&fillIngredients=true&number=10`, (recipes) => {
                            // console.log(recipes);   
                            app.innerHTML = RecipeIngredientsListPage(recipes);
                            // const recipeId = recipes.results[0].id;
                            // apiActions.getRequest(`https://api.spoonacular.com/recipes/${recipeId}/analyzedInstructions?apiKey=${apiKeyNum}`, (recipeInstructions) => {
                            //     // console.log(recipeInstructions);
                            //     app.innerHTML += RecipeInstructions(recipeInstructions);
                            // })
                            navToSpecificRecipePage();
                        })
                    })
                })
            })
        })
    }
}

function navToSpecificRecipePage() {
    app.addEventListener('click', (event) => {
        if (event.target.classList.contains('nav_full_recipe')) {
            const singleRecipe = event.target.parentElement.parentElement.querySelector("input").value;
            console.log(singleRecipe);
            // apiActions.getRequest(`https://api.spoonacular.com/recipes/642582/card?apiKey=${apiKeyNum}&backgroundImage=background1`, (recipe) => {
            //     console.log(recipe);
            //     app.innerHTML = RecipePage(recipe);
            // })
        }
    })
}

function navToDeleteIngredientPage() {
    const navToDeleteIngredientPageButton = document.querySelector('.delete_ingredient_minus');
    navToDeleteIngredientPageButton.addEventListener('click', () => {
        app.innerHTML = DeleteIngredientPage();
    });
}

function deleteIngredientFromParent() {
    app.addEventListener('click', (event) => {
        if (event.target.classList.contains('delete_ingredient_submit')) {
            const ingredient = event.target.parentElement.querySelector('#delete_ingredient_name').value;
            apiActions.deleteRequest('http://localhost:8080/parents/203/delete-ingredient', {
                'ingredient': ingredient
            }, (parents) => {
                wireUpParent(parents);
            });
        }
    });
}
let childId = 0;

function navToAddPreferencePage() {
    const navToAddPreferencePageButton = document.querySelectorAll('.add_preference_plus');
    for (const navToAddPreferencePageButton of navToAddPreferencePageButton) {
        navToAddPreferencePageButton.addEventListener('click', (event) => {
            childId = event.target.parentElement.parentElement.querySelector("input").value;
            console.log(childId);
            app.innerHTML = AddPreferencePage();
        });
    }
}

function addPreferenceToChild() {
    app.addEventListener('click', (event) => {
        if (event.target.classList.contains('add_preference_submit')) {
            const preference = event.target.parentElement.querySelector('#add_preference_name').value;
            console.log(childId);
            apiActions.postRequest(`http://localhost:8080/children/${childId}/add-preference`, {
                'preference': preference
            }, (child) => {
                Child(child);
                apiActions.getRequest('http://localhost:8080/parents/203', (parents) => {
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
                    // navToDeletePreferencePage();
                    deletePreferenceFromChild();
                    toggleChildren();
                });
            })
        }
    });
}



function deletePreferenceFromChild() {
    app.addEventListener('click', (event) => {
        if (event.target.classList.contains('delete_preference_submit')) {
            const preference = event.target.parentElement.querySelector('#delete_preference_name').value;
            console.log(childId);
            apiActions.deleteRequest(`http://localhost:8080/children/${childId}/delete-preference`, {
                'preference': preference
            }, (child) => {
                Child(child);
                apiActions.getRequest('http://localhost:8080/parents/203', (parents) => {
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
    })
}

function navFaq() {
    const faqElem = document.querySelector('.footer__faq_listItem');
    faqElem.addEventListener('click', () => {
        const app = document.querySelector('#app');
        app.innerHTML = FaqPage();
    });
}

function navTerms() {
    const termsElem = document.querySelector('.footer__terms_listItem');
    termsElem.addEventListener('click', () => {
        const app = document.querySelector('#app');
        app.innerHTML = Terms();
    });
}

function navPrivacy() {
    const privacyElem = document.querySelector('.footer__privacy_listItem');
    privacyElem.addEventListener('click', () => {
        const app = document.querySelector('#app');
        app.innerHTML = Privacy();
    });
}

function navigateToContactPage() {
    const contactButton = document.querySelector('.footer__contact_listItem');
    contactButton.addEventListener('click', () => {
        const app = document.querySelector('#app');
        app.innerHTML = ContactPage();
    });
}

function navToAboutPageMenu() {
    const navToAboutPageButton = document.querySelector('#about')
    navToAboutPageButton.addEventListener('click', () => {
        const app = document.querySelector('#app');
        app.innerHTML = About()
    })
}

function navToAboutPageFooter() {
    const navToAboutPageButton = document.querySelector('.footer__about_listItem')
    navToAboutPageButton.addEventListener('click', () => {
        const app = document.querySelector('#app');
        app.innerHTML = About()
    })

    function navToSignInPage() {
        const navToSignInButton = document.querySelector('#sign_in');
        navToSignInButton.addEventListener('click', () => {
            app.innerHTML = SignInPage();
            SignInJs();
        })
    }

    function navHome() {
        const homeElem = document.querySelector('#home-button');
        homeElem.addEventListener('click', () => {
            location.href = 'index.html';
        });
    }
}