export default function Ingredients(ingredients) {
    return `
        <h1>Ingredients</h1>

        <ul>
        ${ingredients.map((ingredient) => {
            return `
                <li>${ingredient.ingredient}</li>
            `;  
        }).join('')}
        </ul>
    `;
}