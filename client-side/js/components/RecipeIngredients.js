export default function RecipeIngredients(recipeIngredients) {
    return `
        <h2>Recipe Ingredients</h2>
        ${recipeIngredients.results.map((recipeIngredient) => {
        return `
            ${recipeIngredient.title}
            <input type="hidden" id="recipeIngredientId" value=${recipeIngredient.id}>
            `;
        }).join('')}
        
        
            ${recipeIngredients.results.map((usedIngredients) => {
                return `
                    <ul>
                    ${usedIngredients.usedIngredients.map((usedIngredient) => {
                        return  `
                            <li>${usedIngredient.originalString}</li>
                        `;
                    }).join('')}
                    </ul>
                `;
            }).join('')}
        
    `;
}