function updateOptions() {
    const category = document.getElementById("category").value;
    const itemSelect = document.getElementById("item");
    const allOptions = itemSelect.querySelectorAll("option[data-category]");

    // 먼저 모든 옵션 숨기기
    allOptions.forEach(option => {
        option.style.display = "none";
    });

    // 선택된 단과대학과 일치하는 학과만 보이기
    allOptions.forEach(option => {
        if (option.getAttribute("data-category") === category) {
            option.style.display = "block";
        }
    });

    // 선택 초기화
    itemSelect.value = "";
}
