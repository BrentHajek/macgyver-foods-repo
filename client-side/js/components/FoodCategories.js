export default function FoodCategories(foodCategories) {
    return `
        <h1 class="preference-list-title">Food Preferences</h1>
        <ul class="preference-list">
        ${foodCategories.map(foodCategory => {
        return `
            <div class="preference-container">
                <p class="food-category-name">${foodCategory.foodCategoryName}
                    <input type='hidden' id='foodCategoryId' value='${foodCategory.id}'>
                </p>
            </div>
            `;
    })
        .join('')}
        </ul>
    `;
}