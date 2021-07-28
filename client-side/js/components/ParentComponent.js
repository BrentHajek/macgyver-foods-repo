export default function ParentComponent(parent) {
    return `
    <div class='parent__info_containter'>
        <input type='hidden' id='parentInfo' value=${parent.url} />
        <h2 class='parent__name'>${parent.name}</h2>
        <li>Email: ${parent.email}</li>
        <li>List of preferences: ${parent.preferences}</li>
    </div>
    `;
}