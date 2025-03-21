function showDetails(index) {
    // 모든 연도 박스에서 active 클래스 제거
    const yearBoxes = document.querySelectorAll('.year-box');
    yearBoxes.forEach(box => box.classList.remove('active'));
  
    // 클릭한 연도 박스에 active 클래스 추가
    yearBoxes[index].classList.add('active');
  
    // 모든 세부 내용 숨기기
    const allDetails = document.querySelectorAll('.history-item');
    allDetails.forEach(detail => detail.style.display = 'none');
  
    // 클릭한 연도의 세부 내용만 보이기
    const detail = document.getElementById(`detail-${index}`);
    detail.style.display = 'block';
  }
  
  // 페이지 로딩 시 2025 연도 기본적으로 열리게 설정
  window.onload = function() {
    showDetails(0); // 0은 첫 번째 연도(2025)를 의미
  };