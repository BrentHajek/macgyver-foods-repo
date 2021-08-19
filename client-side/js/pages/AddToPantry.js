export default function AddToPantry(foodCategories) {
    return `
    <div class="body__ingredient_groups">
    ${foodCategories.map(foodCategory => {
        return`
        <section class="body__ingredients">
            <div class="body__category_list">
                <h2 class="body__category_title">${foodCategory.foodCategoryName}</h2>
                <i id="downBtn" class="fas fa-chevron-down"></i>
            </div>
            <div class="body__ingredients_list">
            ${foodCategory.ingredient.map(ingredient => {
        return `
                <label class="ingredients__listItem">${ingredient.ingredient}
                    <input type="checkbox" class="pantry-ingredients" id="ingredientId${ingredient.id}" value="${ingredient.ingredient}">
                    <span class="checkmark-box"></span>
                </label>
            `;
    })
        .join('')}
            </div>
        </section>
        `;
    })
        .join('')}
        </div>
        <section class='submit-items-to-pantry'>
            <button class='submit-items-to-pantry-btn'>Submit</button>
        </section>
    `;
}