function checkOnlyOne(element) {
    const checkboxes = document.getElementsByClassName("checked");
    Array.from(checkboxes).forEach((cb) => {
        cb.checked = false;
    });
    element.checked = true;
}
