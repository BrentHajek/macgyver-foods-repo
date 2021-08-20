import '../../css/parentPage.css';
import Child from './Child.js';

export default function Parent(parent) {
    return `
    <div class="parent__info_container">
    <div class="parent__info_card">
        <input type="hidden" id="parentId" value=${parent.id}/>
        <div id="profile__pic" class="image__box"></div>
        <h2 class="parent__name_header">Hello ${parent.parentFirstName},</h2>
        <p class="parent__first_name">First name: ${parent.parentFirstName}</p>
        <p class="parent__last_name">Last name: ${parent.parentLastName}</p>
        <p class="parent__email">Email: ${parent.email}</p>
        <h3>Your Ingredients:</h3>
        ${parent.ingredients.map((ingredient) => {
        return `
                <li>${ingredient.ingredient}</li>
            `;
    }).join('')}
        <div class="pantry__buttons_container">
        <button class="add_ingredient_plus" type="button">+ Add To Pantry</button>
        <button class="delete_ingredient_minus" type="button">- Remove From Pantry</button>
        </div>
        <div class="add_child_plus_button_container">
            <button class="add_child_plus" type="button">+ Add a Child</button>
            <button class="delete_child_minus" type="button">- Remove a Child</button>
        </div>
    </div>
</div>
    <div class='child__info_container'>
    <h2 class="children__name_header">Your Picky Eaters:</h2>
    ${parent.child.map((child) => {
        return `
            <p>${Child(child)}</p>
        `;
    }).join('')}
    </div>
    `;
}