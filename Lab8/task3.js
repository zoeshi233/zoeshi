/* Task3.js - Add your Java Script Code Here */
var sum = 0;
function getValue(num){
    sum = sum+num;
    document.getElementById("mydata").innerHTML="Amount = $"+sum.toFixed(2);
}
