export default function DeleteChildPage(child) {
    return `
        <section class="delete_child">
            ${child.map(child => {
        return `
            <label class="child-to-remove-container">
                <p class="child-name-to-remove">${child.firstName}
                    <input type='checkbox' class="childToRemove" id='childId${child.id}' value='${child.firstName}'>
                    <span class="radio-btn"></span>
                </p>
            </label>
                `;
    }).join('')}
            <button class="delete_child_submit" value='${child.id}' type="button">Submit</button>
        </section>
    `;
}