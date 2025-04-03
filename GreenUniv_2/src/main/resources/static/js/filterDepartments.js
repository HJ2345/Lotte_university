function filterDepartments() {
    const selectedUniv = document.getElementById("univSelect").value;
    const deptSelect = document.getElementById("deptSelect");
    const deptOptions = deptSelect.querySelectorAll("option[data-univ]");

    deptOptions.forEach(option => {
        const univ = option.getAttribute("data-univ");
        option.style.display = (univ === selectedUniv) ? "block" : "none";
    });

    deptSelect.value = "";
}
