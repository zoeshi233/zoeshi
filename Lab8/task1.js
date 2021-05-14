/* Task1.js - Add your Java Script Code Here */
function myFunction()
{
  var p = document.getElementById("mydata");
  var num = Math.random();
  // set p.innerHTML equal to heads or tails
  if(num>=0.5){
    p.innerHTML="heads";
  }
  else{
    p.innerHTML="tails";
  }
}
