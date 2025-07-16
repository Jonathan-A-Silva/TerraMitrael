var classe_tabs = document.getElementsByClassName("classe-tab");
var race_tabs = document.getElementsByClassName("race-tab");

const nextbuttonClasse = document.querySelector(".proxima-classe");
const prevbuttonClasse = document.querySelector(".volta-classe");

const nextbuttonRace = document.querySelector(".proxima-race");
const prevbuttonRace = document.querySelector(".volta-race");

var current_classe_tab = 0;
var current_race_tab = 0;

window.onload = function () {
    showClasseTab(current_classe_tab);
    showRaceTab(current_race_tab);
};

nextbuttonClasse.addEventListener("click", function () {
    current_classe_tab = (current_classe_tab + 1) % classe_tabs.length;
    showClasseTab(current_classe_tab);
});

prevbuttonClasse.addEventListener("click", function () {
    current_classe_tab = (current_classe_tab - 1 + classe_tabs.length) % classe_tabs.length;
    showClasseTab(current_classe_tab);
});

nextbuttonRace.addEventListener("click", function () {
    current_race_tab = (current_race_tab + 1) % race_tabs.length;
    showRaceTab(current_race_tab);
});

prevbuttonRace.addEventListener("click", function () {
    current_race_tab = (current_race_tab - 1 + race_tabs.length) % race_tabs.length;
    showRaceTab(current_race_tab);
});

function showClasseTab(n) {
    for (var i = 0; i < classe_tabs.length; i++) {
        classe_tabs[i].style.display = "none";
    }
    classe_tabs[n].style.display = "block";
}

function showRaceTab(n) {
    for (var i = 0; i < race_tabs.length; i++) {
        race_tabs[i].style.display = "none";
    }
    race_tabs[n].style.display = "block";
}
