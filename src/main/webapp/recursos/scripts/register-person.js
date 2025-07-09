var current_classe_tab = 0;

window.onload = function() {
    showClasseTab(0);
};

function showClasseTab(n) {
    var tabs = document.getElementsByClassName("classe-tab");
    if (n >= tabs.length) {
        n = 0;
    }

    for (var i = 0; i < tabs.length; i++) {
        tabs[i].style.display = "none";
    }

    tabs[n].style.display = "block";


}