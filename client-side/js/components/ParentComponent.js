export default function ParentComponent(parent) {
    return `
    <div class='parent__info_containter'>
        <input type='hidden' id='parentInfo' value=${parent.url} />
        <h2 class='parent__name_header'>Hello, ${parent.parentFirstName}</h2>
        <li>First name: ${parent.parentFirstName}</li>
        <li>Last name: ${parent.parentLastName}</li>
        <li>Email: ${parent.email}</li>
        <li>Your preferences: ${parent.ingredients}</li>
    </div>
    `;
}