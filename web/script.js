$(document).ready(function(){
    $("#save").click(function () {
        alert('Employee Succesfully added!');
   //    $('.index').find('h1').load("Add Another Employee",function (responseTxt, statusTxt,xhr){
   //        if(statusTxt === "success"){
   //            alert('Employee Succesfully added!');
   //        }else {
   //            alert('Error: ',+xhr.status + ': ' + xhr.statusText);
   //        }
   //    });
   });

  $("#searchForm").keyup(function (e) {
     return e.which !== 13;
  });
});