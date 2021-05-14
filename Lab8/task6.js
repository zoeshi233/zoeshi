/* Task6.js - Add your Java Script Code Here */
var i = 20;
function countDown(){
    
    if(i<=0){
        document.getElementById("mydata").innerHTML="Liftoff!";
    }
    else{
        document.getElementById("mydata").innerHTML=i;
    }
    i=i-1;
}