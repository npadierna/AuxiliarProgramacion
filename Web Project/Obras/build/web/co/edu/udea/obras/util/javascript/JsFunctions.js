function onViewContractRequest(xhr, status, args) {
    if (args.selectedContract) {
        window.open('/obras/faces/co/edu/udea/obras/web/contract/contractvisor.xhtml', 'Contrato');
    }
}

function recoverPasswordRequest(xhr, status, args) {
    location.href = '/obras/faces/co/edu/udea/obras/web/client/update/recoverclientpassword.xhtml';
}

function onViewProductRequest(xhr, status, args) {
    if (args.selectedProduct) {
        window.open('/obras/faces/co/edu/udea/obras/web/product/authoroeuvrefilelist.xhtml', 'Productos');
    }
}

function handleSentRequest(xhr, status, args) {
    if (args.sent) {
        location.href = '/obras/faces/co/edu/udea/obras/web/index.xhtml';
    }
}

function handleDeleteRequest(xhr, status, args) {
    // if (args.deleted) {
    location.href = '/obras/faces/co/edu/udea/obras/web/admin/creator/entitiescreator.xhtml';
    // }
}

function handleLogoutRequest(xhr, status, args) {
    if (!args.loggedIn) {
        location.href = '/obras/faces/co/edu/udea/obras/web/index.xhtml';
    }
}

function handleLoginRequest(xhr, status, args) {
    if (args.loggedIn) {
        location.href = '/obras/faces/co/edu/udea/obras/web/oeuvre/list/oeuvrelist.xhtml';
    }
}

function handleOeuvreCreatedRequest(xhr, status, args) {
    if (args.onCreated) {
        location.href = '/obras/faces/co/edu/udea/obras/web/oeuvre/list/oeuvrelist.xhtml';
    }
}


function handleOeuvreUpdateRequest(xhr, status, args) {
    //if (args.onUpdate) {
    location.href = '/obras/faces/co/edu/udea/obras/web/oeuvre/list/oeuvrelist.xhtml';
    // }
}


function onSelectedAuthorOeuvreRequest(xhr, status, args) {
    if (args.onSelected) {
        location.href = '/obras/faces/co/edu/udea/obras/web/oeuvre/list/selectedoeuvre.xhtml';
    }
}

function onEditAuthorOeuvreRequest(xhr, status, args) {
    if (args.onEdit) {
        location.href = '/obras/faces/co/edu/udea/obras/web/oeuvre/update/updateauthoroeuvre.xhtml';
    }
}

function createAuthorRequest(xhr, status, args) {
    location.href = '/obras/faces/co/edu/udea/obras/web/admin/creator/entitiescreator.xhtml';
}

function handlePasswordChangedRequest(xhr, status, args) {
    if (args.changed) {
        location.href = '/obras/faces/co/edu/udea/obras/web/oeuvre/list/oeuvrelist.xhtml';
    }
}

function handleRegistryOkRequest(xhr, status, args) {
    // if (args.loggedIn) {
    location.href = '/obras/faces/co/edu/udea/obras/web/oeuvre/list/oeuvrelist.xhtml';
    // }
}

function handleUpdateRequest(xhr, status, args) {
    if (args.changed) {
        location.href = '/obras/faces/co/edu/udea/obras/web/oeuvre/list/oeuvrelist.xhtml';
    }
}

function onSelectedContractRequest(xhr, status, args) {
    location.href = '/obras/faces/co/edu/udea/obras/web/contract/contractvisor.xhtml';
}

function onShowAuthorOeuvreFileListRequest(xhr, status, args) {
    location.href = '/obras/faces/co/edu/udea/obras/web/product/authoroeuvrefilelist.xhtml';
}

function onShowProductsRequest(xhr, status, args) {
    location.href = '/obras/faces/co/edu/udea/obras/web/product/authoroeuvreproductvisor.xhtml';
}