var menuDropDown = document.querySelector('.header__menu_list');
var menuBackdrop = document.querySelector('.header__menu_backdrop');
var modalXButton = document.querySelector('.modal-close');
var modalEnterButton = document.querySelector('.modal-listItem');
var modalContent = document.querySelector('.header__modal_container');

function openMenuDrop() {
    menuDropDown.style.display = "block";
}

function hideMenuDrop() {
    menuDropDown.style.display = "none";
}

function closeWelcomeModal() {
    modalContent.style.display = 'none';
}

const menuBtn = document.querySelector('.header__menu_btn');
let menuOpen = false;
menuBtn.addEventListener('click', () => {
    if(!menuOpen) {
        menuBtn.classList.add('open');
        menuOpen = true;
        openMenuDrop();
    } else {
        menuBtn.classList.remove('open');
        menuOpen = false;
        hideMenuDrop();
    }
});

modalXButton.addEventListener('click', () => {
    closeWelcomeModal();
});

modalEnterButton.addEventListener('click', () => {
    closeWelcomeModal();
});