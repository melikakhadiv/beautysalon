async function showModal(id) {
    $("#modalSubscriptionForm").modal('toggle');
    console.log(id);
    let response = await fetch("/user.do?" + new URLSearchParams({edit: id}), {method: "Get"});

    // const response = await fetch("/api/user?" + new URLSearchParams({id: id})
    //     , {method: "Get"});
    // const data = await response.json();
    // console.log(data)
    // let idTxt = document.getElementById("idTxt");
    // let usernameTxt = document.getElementById("usernameTxt");
    // let passwordTxt = document.getElementById("passwordTxt");
    // let nameTxt = document.getElementById("nameTxt");
    // let familyTxt = document.getElementById("familyTxt");
    // let phoneNumberTxt = document.getElementById("phoneNumberTxt");
    // let roleTxt = document.getElementById("roleTxt");
    // let statusTxt = document.getElementById("statusTxt");
    // idTxt.value = data.id;
    // usernameTxt.value = data.userName;
    // passwordTxt.value = data.password;
    // nameTxt.value = data.name;
    // familyTxt.value = data.family;
    // phoneNumberTxt.value = data.phoneNumber;
    // roleTxt.value = data.role;
    // statusTxt.value = data.status;
}
function resetData(){
    document.getElementById("userEdit").value().reset();
    document.getElementById("idTxt").value().reset();
    document.getElementById("usernameTxt").value().reset();
    document.getElementById("passwordTxt").value().reset();
    document.getElementById("nameTxt").value().reset();
    document.getElementById("familyTxt").value().reset();
    document.getElementById("roleTxt").value().reset();
    document.getElementById("phoneNumberTxt").value().reset();
    document.getElementById("statusTxt").value().reset();
}
// async function edit(id) {
//
//     const response = await fetch("user.do?edit=" + id , {method: "Get"}) ;
//     const data = await response.json();
//     const modal = document.getElementById("modal");
//
//     modal.style.display = "block";
// }



// async function edit() {
//     const formData = document.getElementById("userForm");
//
//     const idTxt = document.getElementById("idTxt");
//     const usernameTxt = document.getElementById("usernameTxt");
//     const passwordTxt = document.getElementById("passwordTxt");
//     const nameTxt = document.getElementById("nameTxt");
//     const familyTxt = document.getElementById("familyTxt");
//     const phoneNumberTxt = document.getElementById("phoneNumberTxt");
//     const roleTxt = document.getElementById("roleTxt");
//     const statusTxt = document.getElementById("statusTxt");
//     const response = await fetch("/user.do?" + new URLSearchParams({
//         id: idTxt.value,
//         username: usernameTxt.value,
//         password: passwordTxt.value,
//         name: nameTxt.value,
//         family: familyTxt.value,
//         phoneNumber: phoneNumberTxt.value,
//         role: roleTxt.value,
//         status: statusTxt.value
//     }),
//         {
//             method: "PUT"
//         });
// }

async function remove(id) {
    const response = await fetch("/user.do?" + new URLSearchParams({
        id: id
    }),
        {
            method: "DELETE"
        })

    window.location.replace("/user.do");
}

