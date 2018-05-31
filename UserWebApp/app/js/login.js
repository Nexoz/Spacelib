$(document).ready(function() {

    $("#login").click(function (evt) {
        evt.preventDefault();
        // Call function login
        // Mise en variable session de l'user id
        sessionStorage.setItem('userid', 1);
        sessionStorage.setItem('username', 'Test');
        window.location = "home.html";
    })
})