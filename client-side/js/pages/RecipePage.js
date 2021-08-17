export default function RecipePage(recipe) {
    return `
       <img src=${recipe.url} alt='' />
       <button class="save_recipe_to_child" position:absolute;>Save</button>
    `;
}