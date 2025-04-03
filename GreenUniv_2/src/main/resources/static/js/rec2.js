document.addEventListener("DOMContentLoaded", function () {
    const steps = document.querySelectorAll(".steps li");
    const stepText = document.querySelector(".step");
    const subtitle = document.querySelector(".subtitle");
    const subcontent = document.querySelector(".subcontent");
    const content = document.querySelector(".content");
    const date = document.querySelector(".date");
    const img = document.querySelector(".img img");

    const stepData = [
        {
            step: "STEP 01",
            title: "모집요강확인",
            content: "2025학년도 정시 모집요강을 확인하세요.",
            imgSrc: "/images/step1.png"
        },
        {
            step: "STEP 02",
            title: "입학원서작성",
            subcontent: "3회까지 복수 지원 가능",
            content: "대학 자체 접수 사이트 이용 시 전형료 무료",
            date: "2024-12-31(화) ~ 2025-01-14(화)",
            imgSrc: "/images/step2.png"
        },
        {
            step: "STEP 03",
            title: "서류제출",
            content: "해당 기간 동안 대학 도착 서류만 유효함",
            date: "2024-12-31(화) ~ 2025-01-15(수)",
            imgSrc: "/images/step3.png"
        },
        {
            step: "STEP 04",
            title: "합격자발표",
            content: "2025.01.24.(금) 16:00 예정",
            imgSrc: "/images/step4.png"
        },
        {
            step: "STEP 05",
            title: "본 등록",
            date: "2025.02.10.(월) ~ 02.12.(수) 17:00까지",
            imgSrc: "/images/step7.png"
        }
    ];

    steps.forEach((step, index) => {
        step.addEventListener("click", function () {
            steps.forEach(item => item.classList.remove("thisStep"));

            this.classList.add("thisStep");

            stepText.textContent = stepData[index].step;
            subtitle.textContent = stepData[index].title;
            subcontent.textContent = stepData[index].subcontent;
            content.textContent = stepData[index].content;
            date.textContent = stepData[index].date;

            img.src = stepData[index].imgSrc;
        });
    });
});
