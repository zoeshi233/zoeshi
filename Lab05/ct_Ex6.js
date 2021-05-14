// in Ex2 to Ex8, change the name of the following function properly
// also, update pre/post conditions accordingly
function problem06() {
   //precondition: 
   //	num1 represents a Real number. num2 represents a Real number
   //Postcondition:
   //	The sum of num1 and num2 has been outputted                                


   /* in Ex1, change the following two lines such that 
      num1 and num2 are parsed to integer before be 
      assigned to w and h, respectively.                   */
   /* in Ex 2, rename w and h to a and b, respectively.    */
   var a = parseInt(document.getElementById("num1").value);
      if(a==0){
         document.getElementById("input").disabled = true;
      }
      else if(a>0){
         document.getElementById("output").innerHTML="The input is positive";
      }
      else{
         document.getElementById("output").innerHTML="The input is negative";
      }
   
    //in Ex 5, uncomment this block
   /*switch (true){
      case(a>100):
         answer="error";
      case (a>89): 
         answer="A+";
         break;
      case (a>79): 
         answer="A";
         break;
      case (a>74): 
         answer="B+";
         break;
      case (a>69): 
         answer="B";
         break;
      case (a>64): 
         answer="C+";
         break;
      case (a>59): 
         answer="C";
         break;
      case (a>54): 
         answer="D+";
         break;
      case (a>49): 
         answer="D";
         break;
      case (a>39): 
         answer="E";
         break;
       // in Ex5, you need to add more cases for other letter grades
      default:
         answer="F";
   }
   document.getElementById("output").innerHTML=answer; */
}

   /* in Ex2 to Ex5, you need to renmae "sum" to make it more relevant
      to those problems, you may also need to rename s to a better 
      varibale that you have in your formulas above */
   
