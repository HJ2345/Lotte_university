function filterProfessors() {
    const selectedUniv = document.getElementById("univSelect").value;
    const profSelect = document.getElementById("profSelect");
    const options = profSelect.querySelectorAll("option[data-univ]");

    options.forEach(option => {
        option.style.display = "none"; // 전체 숨김
        if (option.getAttribute("data-univ") === selectedUniv) {
            option.style.display = "block"; // 선택한 대학 교수만 보임
        }
    });

    // 선택 초기화
    profSelect.value = "";
}