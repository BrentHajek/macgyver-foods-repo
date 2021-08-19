export default function navLandingPreferences(foodCategories) {
    return `
        <div class="body__preferences">
            <h2 class="choose__preferences_title">Food Preferences</h2>
            <i id="downPrefBtn" class="fas fa-chevron-down"></i>
        </div>
    ${foodCategories.map(foodCategory => {
        return `
        <div class="preference__topLevel">
            <h3 class="preference__category_title">${foodCategory.foodCategoryName}</h3>
            <div class="preference__categories">
                ${foodCategory.ingredient.map(ingredient => {
                    return `
                    <div class="preferences__container">
                        <label class="preferences__listItem">${ingredient.ingredient}
                            <input type="checkbox" class="temp-preferences" id="ingredientId" value="${ingredient.ingredient}">
                            <span class="checkmark-box"></span>
                        </label>
                    </div>
                    `;
                })
                .join('')}
            </div>
        </div>
        `;
    })
    .join('')}
    `;
} 