document.addEventListener('DOMContentLoaded', function() {

    const items = document.querySelectorAll('.item');
    const dropdowns = document.querySelectorAll('.dropdown');

    // 각 item에 대해 이벤트 리스너 추가
    items.forEach((item, index) => {
        const dropdown = dropdowns[index];

        item.addEventListener('mouseenter', () => {
            dropdown.style.zIndex = 10;
        });

        item.addEventListener('mouseleave', () => {
            setTimeout(() => {
            dropdown.style.zIndex = 0;
            }, 300);
        });
    });
})