function onViewContractRequest(xhr, status, args) {
    if (args.selectedContract) {
        window.open('/Juridicapp/faces/co/edu/udea/juridicapp/web/contract/contractvisor.xhtml', 'Contrato');
    }
}

function onViewProductRequest(xhr, status, args) {
    if (args.selectedProduct) {
        window.open('/Juridicapp/faces/co/edu/udea/juridicapp/web/product/authoroeuvrefilelist.xhtml', 'Productos');
    }
}

function handleDeleteRequest(xhr, status, args) {
    // if (args.deleted) {
    location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/admin/creator/entitiescreator.xhtml';
    // }
}

function handleLogoutRequest(xhr, status, args) {
    if (!args.loggedIn) {
        location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/index.xhtml';
    }
}

function handleLoginRequest(xhr, status, args) {
    if (args.loggedIn) {
        location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/oeuvre/list/oeuvrelist.xhtml';
    }
}

function handleOeuvreCreatedRequest(xhr, status, args) {
    //  if (!args.loggedIn) {
    location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/oeuvre/list/oeuvrelist.xhtml';
    // }
}

function onSelectedAuthorOeuvreRequest(xhr, status, args) {
    if (args.onSelected) {
        location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/oeuvre/list/selectedoeuvre.xhtml';
    }
}

function createAuthorRequest(xhr, status, args) {
    location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/admin/creator/entitiescreator.xhtml';
}

function handlePasswordChangedRequest(xhr, status, args) {
    if (args.changed) {
        location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/oeuvre/list/oeuvrelist.xhtml';
    }
}

function handleRegistryOkRequest(xhr, status, args) {
    // if (args.loggedIn) {
    location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/oeuvre/list/oeuvrelist.xhtml';
    // }
}

function handleUpdateRequest(xhr, status, args) {
    if (args.changed) {
        location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/oeuvre/list/oeuvrelist.xhtml';
    }
}

function onSelectedContractRequest(xhr, status, args) {
    location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/contract/contractvisor.xhtml';
}

function onShowAuthorOeuvreFileListRequest(xhr, status, args) {
    location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/product/authoroeuvrefilelist.xhtml';
}

function onShowProductsRequest(xhr, status, args) {
    location.href = '/Juridicapp/faces/co/edu/udea/juridicapp/web/product/authoroeuvreproductvisor.xhtml';
}