function onSelectedAuthorOeuvreRequest(xhr, status, args) {
   if (args.onSelected) {
        location.href = '/obras/faces/co/edu/udea/obras/web/oeuvre/list/selectedoeuvre.xhtml';
   }
}