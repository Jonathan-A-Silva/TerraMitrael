document.addEventListener("DOMContentLoaded", function() {
    var menuIcon = document.querySelector('.navbar .menu');
    var menuHamburger = document.querySelector('.menu-hamburger');

    menuIcon.addEventListener('click', function() {
        menuHamburger.classList.toggle('active');
    });
});