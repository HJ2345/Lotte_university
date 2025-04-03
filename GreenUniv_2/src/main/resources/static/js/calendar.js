document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        headerToolbar: {
            left: 'prev',
            center: 'title',
            right: 'next'
        },
        initialView: 'dayGridMonth',
        locale : "ko",
        timeZone: 'UTC',
        dayCellContent: function (arg) {
            const { date } = arg;
            return date.getDate();
        },
    });
    calendar.render();
});