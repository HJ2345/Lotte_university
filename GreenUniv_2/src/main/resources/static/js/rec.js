document.addEventListener("DOMContentLoaded", function () {
    const steps = document.querySelectorAll(".steps li");
    const stepText = document.querySelector(".step");
    const subtitle = document.querySelector(".subtitle");
    const content = document.querySelector(".content");
    const date = document.querySelector(".date");
    const img = document.querySelector(".img img");

    const stepData = [
        {
            step: "STEP 01",
            title: "모집요강확인",
            content: "2025학년도 수시1차 모집요강을 확인하세요.",
            imgSrc: "/images/step1.png"
        },
        {
            step: "STEP 02",
            title: "입학원서작성",
            content: "대학 자체 접수 사이트 이용 시 전형료 무료",
            date: "2024-09-09(월) ~ 2024-10-02(수)",
            imgSrc: "/images/step2.png"
        },
        {
            step: "STEP 03",
            title: "서류제출",
            content: "해당 기간 동안 대학 도착 서류만 유효함",
            date: "2024-09-09(월) ~ 2024-10-03(목)",
            imgSrc: "/images/step3.png"
        },
        {
            step: "STEP 04",
            title: "합격자발표",
            content: "2024.10.25(금) 16:00 예정",
            imgSrc: "/images/step4.png"
        },
        {
            step: "STEP 05",
            title: "예치금납부",
            content: "2024.12.16.(월) ~ 12.18.(수) 17:00까지",
            imgSrc: "/images/step5.png"
        },
        {
            step: "STEP 06",
            title: "추가합격",
            content: "추가 합격자를 발표합니다.",
            date: "2024-11-15(금) ~ 2024-11-20(수)",
            imgSrc: "/images/step6.png"
        },
        {
            step: "STEP 07",
            title: "본 등록",
            content: "▶ 추가합격 발표",
            date: "2024.12.18.(수)~12.30.(월) 21:00까지",
            imgSrc: "/images/step7.png"
        }
    ];

    steps.forEach((step, index) => {
        step.addEventListener("click", function () {
            steps.forEach(item => item.classList.remove("thisStep"));

            this.classList.add("thisStep");

            stepText.textContent = stepData[index].step;
            subtitle.textContent = stepData[index].title;
            content.textContent = stepData[index].content;
            date.textContent = stepData[index].date;

            img.src = stepData[index].imgSrc;
        });
    });
});
