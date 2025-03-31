document.addEventListener("DOMContentLoaded", function () {
    const admissionSelect = document.getElementById("admissionYear");
    const graduationSelect = document.getElementById("graduationYear");
    const currentYear = new Date().getFullYear();

    // 1. 입학년도 옵션 채우기 (1980~현재)
    for (let year = currentYear; year >= 1980; year--) {
        const option = document.createElement("option");
        option.value = year;
        option.text = year + "년";
        admissionSelect.appendChild(option);
    }

    // 2. 입학년도 변경 시 → 졸업년도 자동 설정 (4~6년 후)
    admissionSelect.addEventListener("change", function () {
        const selectedYear = parseInt(this.value);

        // 기존 졸업년도 옵션 초기화
        graduationSelect.innerHTML = "";

        // placeholder 옵션 다시 추가
        const defaultOption = document.createElement("option");
        defaultOption.text = "졸업년도 선택";
        defaultOption.value = "";
        defaultOption.disabled = true;
        defaultOption.selected = true;
        graduationSelect.appendChild(defaultOption);

        // 4~6년 후 졸업년도 추가
        for (let i = 4; i <= 6; i++) {
            const gradYear = selectedYear + i;
            const option = document.createElement("option");
            option.value = gradYear;
            option.text = gradYear + "년";
            graduationSelect.appendChild(option);
        }
    });
});
