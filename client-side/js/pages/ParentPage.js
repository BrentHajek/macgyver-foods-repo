import Parent from '../components/Parent.js';

export default function ParentPage(parent) {
    return `
    <div class="profile__page_header">
        <div id="profile__header_image" class="header__box"></div>
        <h2 class="your__profile_header">Your Profile</h2>
    </div>
        <div class="user_info">
            ${Parent(parent)}
        </div>
    `;
}