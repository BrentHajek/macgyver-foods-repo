export default function Allergy(allergy) {
    return `
        <h1 class="allergy-list-title">Food Allergens</h1>
        <ul class="allergen-list">
        ${allergy.map(allergy => {
        return `
            <label class="allergy-container">
                <p class="allergen-name">${allergy.allergy}
                    <input type='checkbox' class="allergies" id='allergyId${allergy.id}' value='${allergy.allergy}'>
                    <span class="radio-btn"></span>
                </p>
            </label>
            `;
    })
        .join('')}
        </ul>
        <section class='submit-allergies'>
            <button class='submit-allergies-btn'>Submit</button>
        </section>
    `;
}