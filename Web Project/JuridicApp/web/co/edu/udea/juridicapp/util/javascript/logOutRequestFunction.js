function handleLogoutRequest(xhr, status, args) {
   if (!args.loggedIn) {
        location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/work/list/worklist.xhtml';
   }
}