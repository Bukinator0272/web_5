let nameInput = document.getElementById("inputName");

window.onload = function () {
    nameInput.placeholder = "например, Иванов";
}

inputName.onblur = function () {
    nameInput.placeholder = "например, Иванов";
}

inputName.onfocus = function () {
    nameInput.placeholder = "";
}

function task_2() {
    if (isNaN(document.input_id.id.value) || document.input_id.id.value === "") {
        alert("Enter Numeric value only");
        return false;
    }
    document.getElementById('input_temp').submit();
    return true;
}

function task_3(id) {
    if (confirm("Удалить?")) {
        document.getElementById("table_" + id).style.display = "none";
    }
}
