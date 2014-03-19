function onSelectedAuthorOeuvreRequest(xhr, status, args) {
   if (args.onSelected) {
        location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/oeuvre/list/selectedoeuvre.xhtml';
   }
}