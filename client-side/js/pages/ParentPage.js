import Parent from "../components/Parent.js"

export default function ParentPage(parent) {
    return `
    <h2>The Profile Page</h2>
        <div class="user_info">
            ${Parent(parent)}
            <button class="delete_child_minus" type="button">-</button>
        </div>
    `;
}