export default function Pantry(ingredients) {
    return `
        <h1 class="pantry-list-title">Pantry</h1>
        <ul class="pantry-list">
        ${ingredients.map(ingredient => {
        return `
            <label class="pantry-container">
                <p class="pantry-ingredient-name">${ingredient.ingredient}
                    <input type='checkbox' class="pantry-ingredients" id='ingredientId${ingredient.id}' value='${ingredient.ingredient}'>
                    <span class="radio-btn"></span>
                </p>
            </label>
            `;
    })
        .join('')}
        </ul>
        <section class='submit-pantry-items-to-remove'>
            <button class='submit-pantry-items-to-remove-btn'>Submit</button>
        </section>
    `;
}