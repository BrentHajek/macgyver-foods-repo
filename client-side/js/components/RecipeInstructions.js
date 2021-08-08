export default function RecipeInstructions(recipeInstructions) {
    console.log(recipeInstructions);
    return `
        <h1>Recipe Instructions</h1>
        
        <ul>
            ${recipeInstructions.map((step) => {
                return `
                    ${step.steps.map((step) => {
                        return `
                            <li>${step.step}</li>
                        `
                    }).join('')}
                `;
            }).join('')}
        </ul>
    `;
}