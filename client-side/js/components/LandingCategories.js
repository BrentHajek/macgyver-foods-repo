import FoodCategory from "./FoodCategory";

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
                <ul class="ingredients__list">
                    <li class="ingredients__listItem">Apples</li>
                    <li class="ingredients__listItem">Grapes</li>
                    <li class="ingredients__listItem">Bananas</li>
                    <li class="ingredients__listItem">Blueberries</li>
                    <li class="ingredients__listItem">Strawberries</li>
                    <li class="ingredients__listItem">Plums</li>
                </ul>
            </div>
        </section>
        `;
    })
        .join('')}
        </ul>
    `;
}