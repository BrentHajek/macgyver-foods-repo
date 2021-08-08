export default function Child(child) {
    return `
        <div class="test_child_grid">
            <input type='hidden' class='childId' value=${child.id} />
            <h2 class='child__name'>${child.firstName}</h2>
            <p>Child age: ${child.age}</p>
            <h3>List of Allergies:</h3>
            <ul>
            ${child.allergies.map((allergy) => {
                return `
                    <li>
                        <span>${allergy.allergy}</span>
                    </li>
                    
                `;
            }).join('')}
            </ul>
            <h3>List of preferences:</h3>
            <ul>
            ${child.preferences.map((preference) => {
                return `
                    <li>
                        <span>${preference.preference}</span>
                    </li>
                `;
            }).join('')}
            </ul>
        </div>
        `;
}