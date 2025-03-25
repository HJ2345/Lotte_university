const data = {
    humanitiesSociety: ["국어국문학과", "영어영문학과", "일어일문학과", "중어중문학과", "역사학과", "경제학과", "경영학과", "법학과", "철학과", "정치외교학과", "행정학과", "사회복지학과", "유아교육학과"],
    naturalScience: ["수학과", "물리학과", "화학과", "천문학과", "지구과학학과", "생명과학과", "미생물학과", "해양학과"],
    engineering: ["기계공학과", "전자공학과", "전기공학과", "컴퓨터공학과", "건축공학과", "재료공학과", "화학공학과"],
    education: ["국어교육과", "영어교육과", "수학교육과", "윤리학과", "교육학과", "사회교육과", "역사교육과", "체육교육과", "특수교육과"],
    graduate: ["경영대학원", "경제대학원", "행졍대학원", "교육대학원", "산업대학원"]
};

function updateOptions() {
    const category = document.getElementById("category").value;
    const itemSelect = document.getElementById("item");

    itemSelect.innerHTML = '<option value="" disabled selected>항목을 선택하세요</option>';

    if (category && data[category]) {
        data[category].forEach(item => {
            let option = document.createElement("option");
            option.value = item;
            option.textContent = item;
            itemSelect.appendChild(option);
        });
    }
}