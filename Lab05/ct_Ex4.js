// in Ex2 to Ex8, change the name of the following function properly
// also, update pre/post conditions accordingly
function equation() {
   //precondition: 
   //	num1 represents a Real number. num2 represents a Real number
   //Postcondition:
   //	The sum of num1 and num2 has been outputted                                


   /* in Ex1, change the following two lines such that 
      num1 and num2 are parsed to integer before be 
      assigned to w and h, respectively.                   */
   /* in Ex 2, rename w and h to a and b, respectively.    */
   var a = parseInt(document.getElementById("num1").value);
   var b = parseInt(document.getElementById("num2").value);
   var c = parseInt(document.getElementById("num3").value);
   /* in Ex2, write a similar code to the above line
      to capture the value for c*/

   /* in Ex2 to Ex4, you need to replace the following line 
       with some other formulas */
   if((Math.pow(b,2)-(4*a*c))>0){
      document.getElementById("output").innerHTML = "it has 2 distinct roots";   
   }
   else if((Math.pow(b,2)-(4*a*c))==0){
      document.getElementById("output").innerHTML = "its roots are identical"; 
   }
   else{
      document.getElementById("output").innerHTML = "it has no roots in real numbers"; 
   }
   /* in Ex5, you should delete from Line 15 to this line */

   /*   //in Ex 5, uncomment this block
   switch (true){
    case (a>89): 
       answer="A+";
       break;
    case (a>79): 
       answer="A";
       break;
       // in Ex5, you need to add more cases for other letter grades
    default:
       answer="F";
   }
   */

   /* in Ex2 to Ex5, you need to renmae "sum" to make it more relevant
      to those problems, you may also need to rename s to a better 
      varibale that you have in your formulas above */
   

}
