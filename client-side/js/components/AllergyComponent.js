export default function Allergy(allergy) {
    return `
        <h1 class="allergy-list-title">Food Allergens</h1>
        <ul class="allergen-list">
        ${allergy.map(allergy => {
        return `
            <label class="allergy-container">
                <p class="allergen-name">${allergy.allergy}
                    <input type='checkbox' id='allergyId' value='${allergy.id}'>
                    <span class="radio-btn"></span>
                </p>
            </label>
            `;
    })
        .join('')}
        </ul>
    `;
}