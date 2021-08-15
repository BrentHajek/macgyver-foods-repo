export default function RemovePreferences(preference) {
    return `
    <h1 class="preference-list-title">Food Preferences</h1>
    <div class="ingredient-list">
    ${preference.map(preference => {
        return `
        <label class="preference-container">
            <input type='checkbox' id='preferenceId' class="checkboxes" value='${preference.id}'>${preference.preference}</label>
            <div class="preference-name">   
            </div>
        
        `;
    })
        .join('')}
        </div>

        <section class='remove-preferences'>
            <button class='remove-btn'>Submit</button>
        </section>
    `;
}