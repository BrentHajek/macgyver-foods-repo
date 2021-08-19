
export default function RecipeIngredientsListPage(recipesList) {
    return `
    <h2>Recipe Ingredients</h2>

    <div class="recipe_container">
        <div class="recipeList_test">
        ${recipesList.results.map((recipeList) => {
        return `
            <div class="card_recipe">
                <div class="recipe_card_wrapper">
                    <div class="recipe_card_img">
                        <img src=${recipeList.image} alt="" style="width:100%;"/>
                    </div>
                    <div class="recipe_card_box">
                        <h2 class="recipe_card_title">${recipeList.title}</h2>
                        <button class="nav_full_recipe">Learn More
                        <input type="hidden" id="recipeIngredientId${recipeList.id}" value=${recipeList.id}>
                        </button>
                    </div>
                </div>
                
            </div>
        `;
        }).join('')}
        </div>
    </div>
    `;
}

// export default function RecipeIngredientsListPage(recipesList) {
//     return `
//     <h2>Recipe Ingredients</h2>

//     ${recipesList.results.map((recipeList) => {
//     return `
//         <div class="card-wrapper">
//             <li class="recipe_title">
//             <img src=${recipeList.image} alt=""/>
//             ${recipeList.title}
//             <input type="hidden" id="recipeIngredientId${recipeList.id}" value=${recipeList.id}>
//             </li>
//         </div>
//         `;
//     }).join('')}
//     `;
// }