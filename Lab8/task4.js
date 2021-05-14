/* Task4.js - Add your Java Script Code Here */
function rollDise(){
    var dise1 = Math.floor((Math.random()*6)+1);
    var dise2 = Math.floor((Math.random()*6)+1);
    var dise3 = Math.floor((Math.random()*6)+1);
    var dise4 = Math.floor((Math.random()*6)+1);
    var dise5 = Math.floor((Math.random()*6)+1);
    var dise6 = Math.floor((Math.random()*6)+1);
    var avg = (dise1+dise2+dise3+dise4+dise5+dise6)/3;
    document.getElementById("mydata").innerHTML=dise1+" "+dise2+","+dise3+" "+dise4+","+dise5+" "+dise6+"<br/>Average = "+avg.toFixed(2);
}