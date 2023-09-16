async function goEdit(id) {
    window.location.replace("/time.do?edit=" + id);
}

async function edit() {
    const formData = document.getElementById("timeEdit");

    const idTxt = document.getElementById("idTxt");
    const dayTxt = document.getElementById("dayTxt");
    const startTimeTxt = document.getElementById("startTimeTxt");
    const endTimeTxt = document.getElementById("endTimeTxt");
    const beautyTxt = document.getElementById("beautyTxt");
    const response = await fetch("/timing.do?" + new URLSearchParams({
        id: idTxt.value,
        dayTxt: dayTxt.value,
        startTimeTxt: startTimeTxt.value,
        endTimeTxt: endTimeTxt.value,
        beautyTxt: beautyTxt.value,
    }),
        {
            method: "PUT"
        });
}

async function remove(id) {
    const response = await fetch("/timing.do?" + new URLSearchParams({
        id: id
    }),
        {
            method: "Delete"
        });
    window.location.replace("/timing.do")
}

