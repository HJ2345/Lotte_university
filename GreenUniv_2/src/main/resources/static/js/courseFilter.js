// 강의 등록

function filterDeptByUniv() {
    const selectedUniv = document.getElementById("univSelect").value;
    const deptOptions = document.querySelectorAll("#deptSelect option[data-univ]");

    deptOptions.forEach(option => {
        const univ = option.getAttribute("data-univ");
        option.style.display = (univ === selectedUniv) ? "block" : "none";
    });

    document.getElementById("deptSelect").value = "";
}
