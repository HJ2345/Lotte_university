function filterDeptAndProf() {
    const selectedUniv = document.getElementById("univSelect").value;

    const deptOptions = document.querySelectorAll("#deptSelect option[data-univ]");
    const profOptions = document.querySelectorAll("#profSelect option[data-univ]");

    // 학과 옵션 필터링
    deptOptions.forEach(option => {
        const univ = option.getAttribute("data-univ");
        option.style.display = (univ === selectedUniv) ? "block" : "none";
    });

    // 교수 옵션 필터링
    profOptions.forEach(option => {
        const univ = option.getAttribute("data-univ");
        option.style.display = (univ === selectedUniv) ? "block" : "none";
    });

    // 선택 초기화
    document.getElementById("deptSelect").value = "";
    document.getElementById("profSelect").value = "";
}
