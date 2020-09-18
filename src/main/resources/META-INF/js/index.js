$(document).ready(function () {
     // menu
     $("#js-menu").on("click", function(){
          var status = $(this).attr("data-status");
          if(status == "close"){
               $(".content").attr("style", "margin-left: 300px");
               $("#js-sidebar").attr("style", "left: 0")
               $("#js-overlay").show();
               $(this).attr("data-status", "open");
          }else {
               $(".content").attr("style", "margin-left: 0");
               $("#js-sidebar").attr("style", "left: -300px")
               $("#js-overlay").hide();
               $(this).attr("data-status", "close");
          }
     })

     $("#js-overlay").on("click", function () {
          $(".content").attr("style", "margin-left: 0");
          $("#js-sidebar").attr("style", "left: -300px")
          $("#js-overlay").hide();
          $("#js-menu").attr("data-status", "close");
     })

     // action-todo
     $(".js-ctrlSet").on("click", function(){
          $(this).next().toggle();
     })

     // form-search
     $("#js-form-search input").on("focus", function(){
          $("#js-form-search").find("div.glyph-icon.flaticon-search").attr("style","color: #000!important; font-weight:bold")
          $(this).attr("style", "color: #000");
     })
     $("#js-form-search input").on("focusout", function () {
          $("#js-form-search").find("div.glyph-icon.flaticon-search").attr("style", "color: #ff!important")
          $(this).attr("style", "color: #fff");
     })
     
     // checkbox
     $(".js-checkbox").on("click", function(){
          if($(this).is(":checked")){
               $(this).parent().parent().next().find("div").addClass("line-through");
          }else {
               $(this).parent().parent().next().find("div").removeClass("line-through");
          }
          console.log($(this))
     })
     
//     show date
     var d = new Date();
     var mydate = "";
     switch(d.getDay()){
	     case 0:
	     	mydate += "Chủ nhật";break;
	     case 1:
	    	mydate += "Thứ hai";break;
	     case 2:
	    	 mydate += "Thứ ba";break;
	     case 3: 
	    	 mydate += "Thứ tư";break;
	     case 4: 
	    	 mydate += "Thứ năm";break;
	     case 5:
	    	 mydate += "Thứ sáu";break;
	     case 6:
	    	 mydate += "Thứ bảy";break;
	     default: mydate = "";
     }
     $(".today").html(mydate +", "+ d.getDate() + "/" + (d.getMonth()+1));
});