export default function PantryPage(ingredients) {
    return `
    <div class="pantry__page_header">
        <h2 class="your__pantry_header">Items in Your Pantry</h2>
    </div>
    <div class="pantry__info">
    <h3>Your Ingredients:</h3>
    ${ingredients.map((ingredient) => {
        return `
            <li>${ingredient.ingredient}</li>
        `;
    }).join('')}
    </div>
    `;
}