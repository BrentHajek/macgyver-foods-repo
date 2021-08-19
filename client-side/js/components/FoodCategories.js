export default function FoodCategories(foodCategories) {
    return `
        <div class="body__child_preferences">
            <h2 class="child__preferences_title">Food Preferences</h2>
        </div>
    ${foodCategories.map(foodCategory => {
        return `
        <h3 class="preference__category_title">${foodCategory.foodCategoryName}</h3>
        <div class="preference__categories">
            ${foodCategory.ingredient.map(ingredient => {
                return `
                <div class="preferences__container">
                    <label class="preferences__listItem">${ingredient.ingredient}
                        <input type="checkbox" id="ingredientId" value="${ingredient.id}">
                        <span class="checkmark-box"></span>
                    </label>
                </div>
                `;
            })
            .join('')}
        </div>
        `;
    })
    .join('')}
        <section class='add-preferences'>
            <button class='submit-btn'>Submit</button>
        </section>
    `;
    
} 