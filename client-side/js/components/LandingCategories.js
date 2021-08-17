import FoodCategory from './FoodCategory';
let foodCounter = 0;

export default function navLandingCategories(foodCategories) {
    return `
    ${foodCategories.map(foodCategory => {
    let currentRow = foodCounter%2;
    foodCounter++;
    currentRow++;
    return`
        <section class="ingredient__column${currentRow}">
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