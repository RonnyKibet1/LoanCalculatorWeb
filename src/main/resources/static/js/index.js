$(document).ready(function(){

            $window = $(window);

            $(".tableContainer").hide();
            $("#closeButton").hide();
            $("#viewSchedule").click(function() {

                $(".tableContainer").show();
                $('html, body').animate({
                    scrollTop: $("#seperator1").offset().top
                }, 1000);


            });

            $("#calcButton").click(function(){
                $("#viewSchedule").show("slow");
                $(".tableContainer").hide();
                $("div .alert").show();
            });

            $("#closeButton").click(function(){

                $('html, body').animate({
                    scrollTop: $(".container").offset().top
                }, 2000);

                $(".tableContainer").hide("slow");
                $("#closeButton").hide();
                $("div .alert").hide();
                $("#viewSchedule").hide();

            });

            //check if scrroll is on amotization
            $($window).scroll(function(){
                $scroll_position = $window.scrollTop();
                if($scroll_position >= $("#seperator1").offset().top ){
                     $("#closeButton").show();
                }else if($scroll_position < $("#seperator1").offset().top){
                    $("#closeButton").hide();
                }

            });


            //listen to button click to navigate
            $(".desktopVersionButton").click(function(){
                window.location.href = '/desktop';
            });

            $(".androidVersionButton").click(function(){
                window.location.href = '/android';
            });

            $(".iosVersionButton").click(function(){
                window.location.href = '/ios';
            });


        });