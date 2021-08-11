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

//when I click left, move slides to the left


//when I click right, move slides to the right
nextBtn.addEventListener('click', () => {
    const currentSlide = track.querySelector('.current-slide');
    const nextSlide = currentSlide.nextElementSibling;
    const amountToMove = nextSlide.style.left;
    track.style.transform = 'translateX(-' + amountToMove + ')';
});

//when I click the nav indicators, move to that slide