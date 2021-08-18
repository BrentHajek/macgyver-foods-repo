export default function SavedRecipesToChildPage(savedRecipes) {
    return `

    <div class="recipe_container">
    <div class="recipeList_test">
    ${savedRecipes.map((recipe) => {
    return `
        <div class="card_recipe">
            <div class="recipe_card_wrapper">
                <div class="recipe_card_img">
                    <img src=${recipe.image} alt="" style="width:100%;"/>
                </div>
                <div class="recipe_card_box">
                    <h2 class="recipe_card_title">${recipe.title}</h2>
                    <button class="saved_full_recipe">Learn More
                    <input type="hidden" id="recipeIngredientId${recipe.id}" value=${recipe.id}>
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