import Child from "./Child";

export default function Parent(parent) {
    return `
    <div class="parent__info_containter">
        <input type="hidden" id="parentId" value=${parent.id}/>
        <h2 class="parent__name_header">Hello, ${parent.parentFirstName}</h2>
        <p>First name: ${parent.parentFirstName}</p>
        <p>Last name: ${parent.parentLastName}</p>
        <p>Email: ${parent.email}</p>
        <h3>Your Ingredients:</h3>
        ${parent.ingredients.map((ingredients) => {
            return `
                <p>${ingredients}</p>
            `;
        }).join('')}
    </div>
    <div class="children_list">${parent.children.map((child) => {
        return `
            ${Child(child)}
        `;
    }).join('')}
    </div>
    `;
}

 


