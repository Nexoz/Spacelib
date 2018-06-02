(function($){
  $(function(){

    $('.sidenav').sidenav();
    $("h4").append(' ' + sessionStorage.getItem('nomstation'));

  }); // end of document ready
})(jQuery); // end of jQuery name space
