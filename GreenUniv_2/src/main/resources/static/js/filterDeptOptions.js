function filterDeptOptions() {
    const selectedUniv = document.getElementById("univSelect").value;
    const deptOptions = document.querySelectorAll("#deptSelect option[data-univ]");

    deptOptions.forEach(option => {
        const univ = option.getAttribute("data-univ");
        option.style.display = (univ === selectedUniv) ? "block" : "none";
    });

    // 학과 선택 초기화
    document.getElementById("deptSelect").value = "";
}
