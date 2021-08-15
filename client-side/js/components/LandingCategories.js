import FoodCategory from './FoodCategory';

export default function navLandingCategories(foodCategories) {
    return `
    ${foodCategories.map(foodCategory => {
        return`
        <section class="body__ingredient_testing">
            <h2 class="body__spices_title">${foodCategory.foodCategoryName}</h2>
            <i id="downBtn" class="fas fa-chevron-down"></i>
        </section>
        `;
    })
        .join('')}
        </ul>
    `;
}