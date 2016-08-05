$(document).ready(function () {

    $('.trigger').click(function () {
        $('#myModal').modal('show');
    });

    $(".datepicker").datepicker({
        dateFormat: 'yy-mm-dd',
        changeMonth: true,
        changeYear: true,
        minDate: 1
    });

    $(".calImg").click(function () {
        $(".datepicker").datepicker("show");
    });
});

			