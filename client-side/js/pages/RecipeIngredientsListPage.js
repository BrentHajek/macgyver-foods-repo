export default function RecipeIngredientsListPage(recipesList) {
    return `
    <h2>Recipe Ingredients</h2>
    <ul>
    ${recipesList.results.map((recipeIngredient) => {
    return `
        <li class="ingredient_title">${recipeIngredient.title}</li>
        <input type="hidden" id="recipeIngredientId" value=${recipeIngredient.id}>
        `;
    }).join('')}
    </ul>
    `;
}