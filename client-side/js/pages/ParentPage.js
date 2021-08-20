import Parent from '../components/Parent.js';

export default function ParentPage(parent) {
    return `
        <div class="user_info">
            ${Parent(parent)}
        </div>
    `;
}