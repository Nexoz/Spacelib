(function($){
  $(function(){

    $('.sidenav').sidenav();
    $('select').formSelect();
    $('.datepicker').datepicker({
      autoClose : true,
      defaultDate : new Date(),
      minDate : new Date(),
      format : 'dd/mm/yy'
    });

  }); // end of document ready
})(jQuery); // end of jQuery name space
