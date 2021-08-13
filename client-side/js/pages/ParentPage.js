import Parent from '../components/Parent.js';

export default function ParentPage(parent) {
    return `
    <h2 class="your__profile_header">Your Profile</h2>
        <div class="user_info">
            ${Parent(parent)}
        </div>
    `;
}