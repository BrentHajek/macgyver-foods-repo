import FoodCategory from './FoodCategory';

export default function navLandingCategories(foodCategories) {
    return `
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
                    <input type="checkbox" id="ingredientId" value="${ingredient.id}">
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
        </ul>
    `;
}