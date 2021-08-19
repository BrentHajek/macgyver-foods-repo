//preference categories
var prefDropDownBtn = document.querySelectorAll('.body__preferences');
var prefDownButton = document.querySelectorAll('#downPrefBtn');
var preferenceTitle = document.querySelectorAll('.choose__preferences_title');
var preferenceMenu = document.querySelectorAll('.preference__topLevel')

function bindPrefButtons() {
    prefDropDownBtn.forEach((ingredientBtn) => {
        ingredientBtn.addEventListener('click', (event) => {
            if (event.target.classList.contains('body__preferences')) {
                let ingredientList = event.target.parentElement.querySelector('.preference__topLevel');
                if (ingredientList.style.display !== 'block') {
                    ingredientList.style.display = 'block';
                } else {
                    ingredientList.style.display = 'none';
                }
            }
        });
    });
}

function bindPrefTitleButton() {
    preferenceTitle.forEach((ingredientBtn) => {
        ingredientBtn.addEventListener('click', (event) => {
            if (event.target.classList.contains('choose__preferences_title')) {
                let ingredientList = event.target.parentElement.parentElement.querySelector('.preference__topLevel');
                if (ingredientList.style.display !== 'block') {
                    ingredientList.style.display = 'block';
                } else {
                    ingredientList.style.display = 'none';
                }
            }
        });
    });
}

function bindPrefDownButton() {
    prefDownButton.forEach((ingredientBtn) => {
        ingredientBtn.addEventListener('click', (event) => {
            if (event.target.classList.contains('fa-chevron-down')) {
                let ingredientList = event.target.parentElement.parentElement.querySelector('.preference__topLevel');
                if (ingredientList.style.display !== 'block') {
                    ingredientList.style.display = 'block';
                } else {
                    ingredientList.style.display = 'none';
                }
            }
        });
    });
}

export default function startPrefSite() {
    prefDownButton = document.querySelectorAll('#downPrefBtn');
    prefDropDownBtn = document.querySelectorAll('.body__preferences');
    preferenceTitle = document.querySelectorAll('.choose__preferences_title');
    preferenceMenu = document.querySelectorAll('.preference__topLevel');
    bindPrefButtons();
    bindPrefTitleButton();
    bindPrefDownButton();
}
