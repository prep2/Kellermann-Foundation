var winW = $(window).width();
var winH = $(window).height();

$(document).ready(function() {

    var Showcase = {
        menu: $('#MENUSIDE'),
        content: $('#CONTENTSIDE'),
        categoryLinks: $(".MainLinkText"),
        menuVisible: false,
        hiddenLogo: $("#hiddenLogoTextEl"),
        logo: $('#LOGO'),
        hiddenCategoryIcons: $('.hiddenIcons'),
        submenus: $('.SubMenuLinkContainer'),
        contentSideIndent: $('#CONTENTSIDEindent'),
        desktopContainer: $(document.body).children('.PC'),
        activeMenu: null,
        activeSubSubMenu: null,
        clearMenuAnimQueue: function() {
            this.menu.clearQueue();
            this.categoryLinks.clearQueue();
            this.logo.clearQueue();
            this.hiddenLogo.clearQueue();
            this.hiddenCategoryIcons.clearQueue();
            this.content.clearQueue();
        },
        onWinResize: function() {
            this.menu.height($(window).height());
        },
        hideSubMenus: function() {
            if (this.activeMenu) {
                $(this.activeMenu).removeClass('MenuSideMainLinkDark').next().hide();
                this.activeMenu = null;
            }

            if (this.activeSubSubMenu) {
                $(this.activeSubSubMenu).removeClass('openSubMenuLink');
                this.activeSubSubMenu = null;
            }
        },
        openSubMenu: function(header) {
            var headerJQ = $(header);

            if (this.activeSubSubMenu) {
                $(this.activeSubSubMenu).removeClass("openSubMenuLink");
                this.activeSubSubMenu = null;
            }

            if (this.activeMenu) {
                if (this.activeMenu === header) {
                    headerJQ.removeClass('MenuSideMainLinkDark').next().slideUp(700, "easeInOutQuint");
                    this.activeMenu = null;
                }
                else {
                    $(this.activeMenu).removeClass('MenuSideMainLinkDark').next().slideUp(700, "easeInOutQuint");
                    headerJQ.addClass("MenuSideMainLinkDark").next().slideDown(700, "easeInOutQuint");
                    this.activeMenu = header;
                }
            }
            else {
                headerJQ.addClass("MenuSideMainLinkDark").next().slideDown(700, "easeInOutQuint");
                this.activeMenu = header;
            }
        },
        openSubSubMenu: function(submenuLink) {
            if (this.activeSubSubMenu) {
                if (this.activeSubSubMenu === submenuLink) {
                    $(submenuLink).removeClass("openSubMenuLink");
                    this.activeSubSubMenu = null;
                } else {
                    $(this.activeSubSubMenu).removeClass("openSubMenuLink");
                    $(submenuLink).addClass("openSubMenuLink");
                    this.activeSubSubMenu = submenuLink;
                }
            }
            else {
                $(submenuLink).addClass("openSubMenuLink");
                this.activeSubSubMenu = submenuLink;
            }
        }

    };

    Showcase.onWinResize();
    $(window).on("resize", function() {
        Showcase.onWinResize();
    });

    Showcase.menu.perfectScrollbar({
        wheelSpeed: 40,
        suppressScrollX: true
    });

    // menu mouseenter & mouseleave actions start ----------------------------------
    Showcase.menu.on("mouseenter", function() {
        clearTimeout(Showcase.menuHideTimeout);
        Showcase.menuShowTimeout = setTimeout(function() {
            if (!Showcase.menuVisible) {
                Showcase.openMenu();
            }
        }, 250);
    })
            .on("mouseleave", function() {
        clearTimeout(Showcase.menuShowTimeout);
        Showcase.menuHideTimeout = setTimeout(function() {
            if (Showcase.menuVisible) {
                Showcase.hideMenu();
            }
            ;
        }, 250);
    });


    var sourceTabview = $('#SourceContentSide > div > span > span > div.ui-tabs'),
            lastTabHeader = sourceTabview.find('> ul > li:last');
    if (lastTabHeader.hasClass('tab-doc')) {
        lastTabHeader.one('click.load', function() {
            var classes = lastTabHeader.attr('class').split(' '),
                    slide = 0;

            for (var i = 0; i < classes.length; i++) {
                if (classes[i].indexOf('docslide-') === 0) {
                    slide = classes[i].split('-')[1];
                }
            }

            var content = sourceTabview.find('> .ui-tabs-panels > div:last ');
            content.html('<iframe frameborder="0" class="speakerdeck-iframe" style="border: 0px none; background: none repeat scroll 0% 0% transparent; margin: 0px; padding: 0px; width: 100%; height: 1440px;" src="http://speakerdeck.com/player/9d21c4d0bcc50131faee127b1bf32aaa?slide=' + slide + '"  allowfullscreen="true" mozallowfullscreen="true" webkitallowfullscreen="true"></iframe>');
        });

    }

    window.Showcase = Showcase;
});