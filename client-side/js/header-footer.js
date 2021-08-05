var menuDropDown = document.querySelector('.header__menu_list');
var menuBackdrop = document.querySelector('.header__menu_backdrop');

function openMenuDrop() {
    menuDropDown.style.display = "block";
}

function hideMenuDrop() {
    menuDropDown.style.display = "none";
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

