console.log("hello world");
$(function () {
    $('.fichier').click(function (e) { 
        e.preventDefault();
        console.log("click");
    });
});