console.log("hello world");
$(function () {
    $('.path').hide();
    $('.fichier').click(function (e) { 
        e.preventDefault();
        console.log("click");
        var nom=$($(this).children()[1]).html();
        var path =$($(this).children()[2]).html();
        
        $.ajax({
            type: "GET",
            url: "/click",
            data: {nom:nom},
            dataType: "text",
            success: function (res) {
                $('body').html(res);
                
                window.open(path,"_blank")
            }
        });
    });


    $(".fichier").draggable({appendTo: 'body', // Append to the body.
    zIndex: 1,
    containment: $('document'),
    helper: 'clone'})

    $( "moyen " ).droppable({
        drop: function( event, ui ) {
            console.log(this);
          $( this )
            .addClass( "moyen" )
            
        }
      });
});