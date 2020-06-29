let name = document.getElementById("name");
let area = document.getElementById("area");
let population = document.getElementById("population");
let gdp = document.getElementById("gdp");

let nameError = document.getElementById("nameError");
let areaError = document.getElementById("areaError");
let populationError = document.getElementById("populationError");
let gdpError = document.getElementById("gdpError");

let namePattern = "^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ" +
    "ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ" +
    "ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$";

name.addEventListener("blur", nameVerify, true);
area.addEventListener("blur", areaVerify, true);
population.addEventListener("blur", populationVerify, true);
gdp.addEventListener("blur", gdpVerify, true);

function validate() {
    if (name.value == "") {
        nameError.textContent = "Không được để trống Tên";
        name.focus();
        return false;
    } else if (!name.value.match(namePattern)) {
        nameError.textContent = "Tên bắt đầu bằng chứ cái";
        name.focus();
        return false;
    }
    if (area.value == "") {
        areaError.textContent = "Không được để trống Quốc gia";
        area.focus();
        return false;
    } else if (area.value < 0 || area.value == 0) {
        areaError.textContent = "Diện tích quốc gia phải lớn hơn 0";
        area.focus();
        return false;
    }
    if (population.value == "") {
        populationError.textContent = "Không được để trống Dân số";
        population.focus();
        return false;
    } else if (population.value < 0 || population.value == 0 ) {
        populationError.textContent = "Dân số phải lớn hơn 0";
        population.focus();
        return false;
    }
    if (gdp.value == "") {
        gdpError.textContent = "Không được để trống GDP";
        gdp.focus();
        return false;
    } else if (gdp.value < 0 || gdp.value == 0) {
        gdpError.textContent = "GDP phải lớn hơn 0";
        gdp.focus();
        return false;
    }
}

function nameVerify() {
    if (name != "") {
        nameError.innerHTML = "";
        return true;
    }
}

function areaVerify() {
    if (area != "") {
        areaError.innerHTML = "";
        return true;
    }
}

function populationVerify() {
    if (population != "") {
        populationError.innerHTML = "";
        return true;
    }
}

function gdpVerify() {
    if (gdp != "") {
        gdpError.innerHTML = "";
        return true;
    }
}