$(document).ready(function(){
    $("#save").click(function () {
        alert('Employee Succesfully added!');
   });
//annuler la touche enter
  $("#searchForm").keyup(function (e) {
     return e.which !== 13;
  });

  // $("#progress").hide();
//     var value = 1;
//     function ProgressBar() {
//        $('#progress').show();
//         var progressBar = document.getElementById('progress');
//         setInterval(function () {
//             if(value < 100){
//                 value++;
//                 progressBar.value = value;
//             }
//             ProgressBar();
//         }, 1000);
//     }
    $(function () {
       $('#datepicker-1').datepicker({
           dateFormat:"yy-mm-dd",
           altField: "#datepicker-1",
           altFormat: "DD, d MM, yy"
       });
    });
});