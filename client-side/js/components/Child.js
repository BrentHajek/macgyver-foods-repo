export default function Child(child) {
    return `
        <div class="test_child_grid">
            <input type='hidden' id='childId${child.id}' value=${child.id} />
            <h2 class='child__name'>${child.firstName}</h2>
            <p>Age: ${child.age}</p>
            <div class="child__allergies_div">
            <h4>List of Allergies:</h4>
            <ul>
            ${child.allergies.map((allergy) => {
        return `
                    <li>
                        <span>${allergy.allergy}</span>
                    </li>
                `;
    }).join('')}
            </ul>
                <button class="allergy-list-btn" type="button">+ Add an Allergy</button>
                <button class="delete__allergy_minus" type="button">- Remove an Allergy</button>
            </div>
            <div class="child__preferences_div">
            <h4>List of preferences:</h4>
            <ul>
            ${child.preferences.map((preference) => {
        return `
                    <li>
                        <span>${preference.preference}</span>
                    </li>
                `;
    }).join('')}
            </ul>
                <button class="add__preference_plus" type="button">+ Add a Preference</button>
                <button class="delete__preference_minus" type="button">- Remove a Preference</button>
            </div>

        </div>
        `;
}