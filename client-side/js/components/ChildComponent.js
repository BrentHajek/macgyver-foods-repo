export default function ChildComponent(child) {
    return `
    <div class='child__info_containter'>
        <input type='hidden' id='childInfo' value=${child.url} />
        <h2 class='child__name'>${child.firstName}</h2>
        <li>List of Allergies: ${child.allergies}</li>
        <li>List of preferences: ${child.preferences}</li>
    </div>
    `;
}