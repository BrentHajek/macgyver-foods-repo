import '../../css/parentPage.css';
import Child from './Child.js';

export default function Parent(parent) {
    return `
    <div class="parent__info_container">
        <input type="hidden" id="parentId" value=${parent.id}/>
        <h2 class="parent__name_header">Hello ${parent.parentFirstName},</h2>
        <p>First name: ${parent.parentFirstName}</p>
        <p>Last name: ${parent.parentLastName}</p>
        <p>Email: ${parent.email}</p>
        <h3>Your Favorite Ingredients:</h3>
        ${parent.ingredients.map((ingredient) => {
        return `
                <p>${ingredient.ingredient}</p>
            `;
    }).join('')}
        <button class="add_ingredient_plus" type="button">+ Add a Favorite Ingredient</button>
        <button class="delete_ingredient_minus" type="button">- Delete from Favorites</button>
    </div>
    <div class='child__info_container'>
    <h2 class="children__name_header">Your Picky Eaters:</h2>
    ${parent.child.map((child) => {
        return `
            <p>${Child(child)}</p>
        `;
    }).join('')}
    <div class="add_child_plus_button_container">
    <button class="add_child_plus" type="button">+ Add a Child</button>
    <button class="delete_child_minus" type="button">- Remove a Child</button>
    </div>
    </div>
    `;
}