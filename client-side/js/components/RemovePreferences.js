export default function RemovePreferences(preference) {
    return `
    <h1 class="preference-list-title">Food Preferences</h1>
    <div class="ingredient-list">
    ${preference.map(preference => {
        return `
        <label class="preference-container">
            <div class="ingredient-name">
                <input type='checkbox' class="preferences" id='ingredientId${preference.id}' value='${preference.preference}'>${preference.preference}
            </div>
        </label>
        `;
    })
        .join('')}
        </div>

        <section class='remove-preferences'>
            <button class='remove-btn'>Submit</button>
        </section>
    `;
}