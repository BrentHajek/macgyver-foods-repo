export default function AddChildPage() {
    return `
    <div class="add_child__container"
        <section="welcome__add_picky_eater">
            <h2 class="header_add_your_eater">Add Your Picky Eater</h2>
            <p class="add_your_eater__info">Add your Picky Eater's name and age here.</p>
        </section>
        <section class="add_child">
            <input class="test5" id="add_child_firstName" type="text" placeholder="First Name"/>
            <input class="test5" id="add_child_lastName" type="text" placeholder="Last Name"/>
            <input class="test5" id="add_child_age" type="text" placeholder="Age"/>
            <button class="add_child_submit" type="button">Save</button>
            </section>
    </div>
    `;
}