
function handleDeleteRequest(xhr, status, args) {
   // if (args.deleted) {
       location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/user/delete/deleteuser.xhtml';
   // }
}

function handleLoginRequest(xhr, status, args){
    location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/work/list/worklist.xhtml';
}

function handleLogoutRequest(xhr, status, args) {
   // if (!args.loggedIn) {
        location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/work/list/worklist.xhtml';
   // }
}

function onSelectedAuthorWorkRequest(xhr, status, args) {
   //if (args.onSelected) {
        location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/work/list/selectedwork.xhtml';
   //}
}

function handlePasswordChangedRequest(xhr, status, args) {
   // if (args.changed) {
        location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/user/login/loggeduser.xhtml';
   // }
}

function handleRegistryOkRequest(xhr, status, args) {
   // if (args.loggedIn) {
        location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/work/list/worklist.xhtml';
   // }
}

function handleUpdateRequest(xhr, status, args) {
   // if (!args.loggedIn) {
        location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/user/update/updateinfouser.xhtml';
   // }
}
