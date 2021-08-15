import FoodCategory from './FoodCategory';

export default function navLandingCategories(foodCategories) {
    return `
    ${foodCategories.map(foodCategory => {
    return`
        <section class="body__ingredients">
            <div class="body__category_list">
                <h2 class="body__spices_title">${foodCategory.foodCategoryName}</h2>
                <i id="downBtn" class="fas fa-chevron-down"></i>
            </div>
            <div class="body__ingredients_list">
                <label class="ingredients__listItem">Apples
                    <input type="checkbox">
                    <span class="checkmark-box"></span>
                </label>
                <label class="ingredients__listItem">Bananas
                    <input type="checkbox">
                    <span class="checkmark-box"></span>
                </label>
                <label class="ingredients__listItem">Plums
                    <input type="checkbox">
                    <span class="checkmark-box"></span>
                </label>
                    <label class="ingredients__listItem">Grapes
                    <input type="checkbox">
                    <span class="checkmark-box"></span>
                </label>
            </div>
        </section>
        `;
    })
        .join('')}
        </ul>
    `;
}