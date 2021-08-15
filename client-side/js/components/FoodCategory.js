export default function FoodCategory(foodCategory) {
    return `
    <h1 class="preference-list-title">Food Preferences</h1>
    <div class="ingredient-list">
    ${foodCategory.ingredient.map(ingredient => {
        return `
        <label class="preference-container">
            <div class="ingredient-name">
                <input type='checkbox' id='ingredientId${ingredient.id}' class="preferences" value='${ingredient.ingredient}'>${ingredient.ingredient}
            </div>
        </label>
        `;
    })
        .join('')}
        </div>

        <section class='add-preferences'>
            <button class='submit-btn'>Submit</button>
        </section>
    `;
}