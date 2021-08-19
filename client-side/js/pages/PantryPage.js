export default function PantryPage(ingredient) {
    return `
    <div class="pantry__page_header">
        <h2 class="your__pantry_header">Items in Your Pantry</h2>
    </div>
    <div class="pantry__info">
        ${ingredient}
    </div>
    `;
}