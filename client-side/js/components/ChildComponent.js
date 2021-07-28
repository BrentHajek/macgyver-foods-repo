export default function ChildComponent(child) {
    return `
    <div class='child__info_containter'>
        <input type='hidden' id='childInfo' value=${child.url} />
        <h2 class='child__name'>${child.name}</h2>
        <li>List of foods: ${child.ingredients}</li>
        <li>List of preferences: ${child.preferences}</li>
    </div>
    `;
}