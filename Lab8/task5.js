/* Task5.js - Add your Java Script Code Here */
function todayDate(){
    var d = new Date;
    var month = ["January","February","March","April","May","June","July","August","September","October","November","December"];
    var date = ["Sun","Mon","Tue","Wed","Thu","Fri","Sat"];
    document.getElementById("mydata").innerHTML="Today is "+date[d.getDay()]+",<br/>"+month[d.getMonth()]+" "+d.getDate()+", "+d.getFullYear();
}