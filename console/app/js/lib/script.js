(function() {
    $(document).on('focus', '.inputanimate', function(evt) {
        evt.stopPropagation();
        $(this).closest('.form-group').addClass('form-fill');
    });

    $(document).on('blur', '.inputanimate', function(evt) {
        evt.stopPropagation();
        if ($(this).val().trim().length === 0) {
            $(this).closest('.form-group').removeClass('form-fill');
        }
    });
})();

$(function() {
    var ink, d, x, y;

    $(".btn, .pagination li a, .entry_tab_nav li a, .jumpleft li a, .ripple, .btn-icon, .rhslink a, .table thead td").click(function(e) {
        if ($(this).find(".ink").length === 0) {
            $(this).prepend("<div class='ink'></div>");
        }

        ink = $(this).find(".ink");
        ink.removeClass("animate");

        if (!ink.height() && !ink.width()) {
            d = Math.max($(this).outerWidth(), $(this).outerHeight());
            ink.css({
                height: d,
                width: d
            });
        }

        x = e.pageX - $(this).offset().left - ink.width() / 2;
        y = e.pageY - $(this).offset().top - ink.height() / 2;

        ink.css({
            top: y + 'px',
            left: x + 'px'
        }).addClass("animate");
    });
});

$(document).ready(function() {
    $(document).on('click', '[data-toggle="dropdown"]', function(evt) {
        evt.stopPropagation();
        $(this).addClass('active');
        $(this).parent().toggleClass('open');
    });

    $(document).on('click', '.drop-down-menu li', function(evt) {
        evt.stopPropagation();
        $('.drop-down-menu .active').removeClass('active');
        $(this).closest('.drop-down-menu').removeClass('open');
    });

    $(document).on('click', '.dropdown-nav', function(evt) {
        evt.stopPropagation();
        $('.dropdown-nav').removeClass('open');
        $(this).toggleClass('open');
    });

    $(document).on('click', '.subMenu a', function(evt) {
        evt.stopPropagation();
        $(this).closest('.dropdown-nav').removeClass('open');
    });

    $(document).on('hover', '.dropdown-nav', function(evt) {
        evt.stopPropagation();
        $(this).addClass('open');
    });

    $(document).on('click', function(evt) {
        evt.stopPropagation();
        var clicked = $(evt.target);
        if (!clicked.parents().hasClass('open')) {
            $('.drop-down-menu').removeClass('open');
            $('.dropdown-nav').removeClass('open');
            $('.drop-down-menu .active').removeClass('active');
        }
    });

    $(document).on('click', '.accordian_heading', function(evt) {
        evt.stopPropagation();
        var accordian = $(this).closest('.accordian');
        $('.accordian').each(function() {
            if ($(this).attr('id') !== $(accordian).attr('id')) {
                $(this).removeClass('expanded');
                $(this).addClass('collapsed');
            }
        });
        if ($(accordian).hasClass('collapsed')) {
            $(accordian).removeClass('collapsed');
            $(accordian).addClass('expanded');
        } else {
            $(accordian).removeClass('expanded');
            $(accordian).addClass('collapsed');
        }
    });

    $(document).on('click', '.according .according_head', function(evt) {
        if (evt.target.className !== 'check' && evt.target.type !== 'checkbox') {
            evt.stopPropagation();
            evt.preventDefault();
            if ($(this).parent().hasClass('active')) {
                $(this).attr('data-state', 'inactive');
                $(this).parent().toggleClass('active');
                $(this).next().slideUp();
            } else {
                $(this).attr('data-state', 'active');
                $('.according .according_head').parent().removeClass('active');
                $('.according .according_head').next().slideUp();
                $(this).next().slideDown();
                $(this).parent().toggleClass('active');
            }
        }
    });

    $(document).on('click', '.close-modal', function(evt) {
        $(this).closest('.modal').hide();
    });

    $(document).on('click', '*[data-dismiss="modal"]', function() {
        $(this).closest('.modal').hide();
    });
});