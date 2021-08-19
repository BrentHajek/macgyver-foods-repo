const track = document.querySelector('.body__carousel_track');
const slides = Array.from(track.children);
const nextBtn = document.querySelector('.body__carousel_btnRight');
const prevBtn = document.querySelector('.body__carousel_btnLeft');
const dotsNav = document.querySelector('.body__carousel_nav');
const dots = Array.from(dotsNav.children);

const slideWidth = slides[0].getBoundingClientRect().width;

//arrange the slides next to one another
const setSlidePosition = (slide, index) => {
    slide.style.left = slideWidth * index + 'px';
};
slides.forEach(setSlidePosition);

const moveToSlide = (track, currentSlide, targetSlide) => {
    track.style.transform = 'translateX(-' + targetSlide.style.left + ')';
    currentSlide.classList.remove('current-slide');
    targetSlide.classList.add('current-slide');
}

const updateDots = (currentDot, targetDot) => {
    currentDot.classList.remove('current-slide');
    targetDot.classList.add('current-slide');
}

const hideShowArrows = (slides, prevBtn, nextBtn, targetIndex) => {
    if (targetIndex === 0) {
        prevBtn.classList.add('is-hidden');
        nextBtn.classList.remove('is-hidden');
    } else if (targetIndex === slides.length - 1) {
        prevBtn.classList.remove('is-hidden');
        nextBtn.classList.add('is-hidden');
    } else {
        prevBtn.classList.remove('is-hidden');
        nextBtn.classList.remove('is-hidden');
    }
}

//when I click left, move slides to the left
prevBtn.addEventListener('click', () => {
    const currentSlide = track.querySelector('.current-slide');
    const prevSlide = currentSlide.previousElementSibling;
    const currentDot = dotsNav.querySelector('.current-slide');
    const prevDot = currentDot.previousElementSibling;
    const prevIndex = slides.findIndex(slide => slide === prevSlide);

    moveToSlide(track, currentSlide, prevSlide);
    updateDots(currentDot, prevDot);
    hideShowArrows(slides, prevBtn, nextBtn, prevIndex);
});

//when I click right, move slides to the right
nextBtn.addEventListener('click', () => {
    const currentSlide = track.querySelector('.current-slide');
    const nextSlide = currentSlide.nextElementSibling;
    const currentDot = dotsNav.querySelector('.current-slide');
    const nextDot = currentDot.nextElementSibling;
    const nextIndex = slides.findIndex(slide => slide === nextSlide);

    moveToSlide(track, currentSlide, nextSlide);
    updateDots(currentDot, nextDot);
    hideShowArrows(slides, prevBtn, nextBtn, nextIndex);
});

//when I click the nav indicators, move to that slide
dotsNav.addEventListener('click', e => {
    const targetDot = e.target.closest('button');

    if (!targetDot) return;

    const currentSlide = track.querySelector('.current-slide');
    const currentDot = dotsNav.querySelector('.current-slide');
    const targetIndex = dots.findIndex(dot => dot === targetDot);
    const targetSlide = slides[targetIndex];

    moveToSlide(track, currentSlide, targetSlide);
    updateDots(currentDot, targetDot);
    hideShowArrows(slides, prevBtn, nextBtn, targetIndex);

});

//ingredient categories
var dropDownBtn = document.querySelectorAll('.body__category_list');
var categoryTitle = document.querySelectorAll('.body__category_title');
var downButton = document.querySelectorAll('#downBtn');
var dropDownMenu = document.querySelectorAll('.body__ingredients_list');

function bindButtons() {
    dropDownBtn.forEach((ingredientBtn) => {
        ingredientBtn.addEventListener('click', (event) => {
            if (event.target.classList.contains('body__category_list')) {
                let ingredientList = event.target.parentElement.querySelector('.body__ingredients_list');
                if (ingredientList.style.display !== 'block') {
                    ingredientList.style.display = 'block';
                } else {
                    ingredientList.style.display = 'none';
                }
            }
        });
    });
}

function bindTitleButton() {
    categoryTitle.forEach((ingredientBtn) => {
        ingredientBtn.addEventListener('click', (event) => {
            if (event.target.classList.contains('body__category_title')) {
                let ingredientList = event.target.parentElement.parentElement.querySelector('.body__ingredients_list');
                if (ingredientList.style.display !== 'block') {
                    ingredientList.style.display = 'block';
                } else {
                    ingredientList.style.display = 'none';
                }
            }
        });
    });
}

function bindDownButton() {
    downButton.forEach((ingredientBtn) => {
        ingredientBtn.addEventListener('click', (event) => {
            if (event.target.classList.contains('fa-chevron-down')) {
                let ingredientList = event.target.parentElement.parentElement.querySelector('.body__ingredients_list');
                if (ingredientList.style.display !== 'block') {
                    ingredientList.style.display = 'block';
                } else {
                    ingredientList.style.display = 'none';
                }
            }
        });
    });
}

export default function startSite() {
    dropDownBtn = document.querySelectorAll('.body__category_list');
    dropDownMenu = document.querySelectorAll('.body__ingredients_list');
    categoryTitle = document.querySelectorAll('.body__category_title');
    downButton = document.querySelectorAll('#downBtn');
    bindButtons();
    bindTitleButton();
    bindDownButton();
}
