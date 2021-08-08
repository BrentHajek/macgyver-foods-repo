export default function RecipeIngredients(recipeIngredients) {
    return `
        <h2>Recipe Ingredients</h2>
        ${recipeIngredients.map((recipeIngredient) => {
            return `
            <input type="hidden" id="recipeIngredientId" value=${recipeIngredient.id}>
            `;
        }).join('')}
        
        
            ${recipeIngredients.map((usedIngredients) => {
                return `
                    <ul>
                    ${usedIngredients.usedIngredients.map((usedIngredient) => {
                        return  `
                            <li>${usedIngredient.original}</li>
                        `;
                    }).join('')}
                    </ul>
                `;
            }).join('')}
        
    `;
}