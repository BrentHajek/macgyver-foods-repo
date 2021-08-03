import Parent from "../components/Parent.js"

export default function ParentPage(parent) {
    return `
        <div class="user_info">
            <h2>The Profile Page</h2>
            ${Parent(parent)}
        </div>
    `;
}