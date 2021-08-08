export default function FoodCategory(foodCategory) {
    return `
        <h1 class="preference-list-title">Food Preferences</h1>
        <div class="ingredient-list">
        ${foodCategory.ingredient.map(ingredient => {
        return `
            <ul>
                <li>
                    <span>${ingredient.ingredient}</span>
                </li>
                    </ul>
            `;
    })
        .join('')}
        </div>
    `;
}