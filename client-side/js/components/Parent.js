import Child from "./Child.js";

export default function Parent(parent) {
    return `
    <div class="parent__info_containter">
        <input type="hidden" id="parentId" value=${parent.id}/>
        <h2 class="parent__name_header">Hello, ${parent.parentFirstName}</h2>
        <p>First name: ${parent.parentFirstName}</p>
        <p>Last name: ${parent.parentLastName}</p>
        <p>Email: ${parent.email}</p>
        <h3>Your Ingredients:</h3>
        ${parent.ingredients.map((ingredient) => {
            return `
                <p>${ingredient.ingredient}</p>
            `;
        }).join('')}
        <button class="add_ingredient_plus" type="button">+</button>
        <button class="delete_ingredient_minus" type="button">-</button>
    </div>
    <div class='child__info_containter'>
    ${parent.child.map((child) => {
        return `
            <p>${Child(child)}</p>
        `;
    }).join('')}
    <button class="add_child_plus" type="button">+</button>
    </div>
    `;
}