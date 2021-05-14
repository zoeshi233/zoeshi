function problem01(){
    var num = prompt("type in a positive integer","");
    var prime =true;
    var d = 2;
    while(prime==true&&d<=num/2){
        if(num%d==0){
            prime=false;
        }
        d+=d+1;
    }
    if(prime==true){
        alert(num+" is prime");
    }
    else{
        alert("is not prime");
    }
}
function problem02(){
    var sum1 = 0;
    var sum2 = 0;
    for(i=1;i<=4;i++){
        var num = prompt("type in a real number","");
        sum1+=num;
    }
    for(i=1;i<=4;i++){
        var num = prompt("type in a real number","");
        sum2+=num;
    }
    if(sum1==sum2){
        alert("yes");
    }
    else{
        alert("no");
    }
}
function problem03(){
    var p = 0;
    var n = 0;
    do{
        var num = prompt("type in a real number","");
        if(num>0){
            p+=1;
        }
        else if(num<0){
            n+=1;
        }
    }
    while(num!=0&&p<=2*n);
}
function problem04(){
    var cnt1 = 0;
    var cnt2 = 0;
    for(i=1;i<=4;i++){
        var num = prompt("type in a real number","");
        if(num<0){
            cnt1+=1;
        }
    }
    for(i=1;i<=4;i++){
        var num = prompt("type in a real number","");
        if(num>0){
            cnt2+=1;
        }
    }
        if(cnt1==cnt2){
            alert("yes");
        }
        else{
            alert("no");
        }
}
function problem05(){
    var num = prompt("","");
    for(i=2;i<=num;i++){
        if(prime(i)==true){
            alert(i);
        }
    }
    
}
function prime(num){
    var flag = true;
    var d = 2;
    while(flag==true&&d<=num/2){
        if(num%d==0){
            flag=false;
        }
        d++;
    }
    return flag;
}
function problem06(){
    var n = parseInt(prompt("type a positive number",""));
    var output="";
    for(i=2;i<=n;i++){
        if(hasSeven(i)==true&&prime(i)==true){
            output=output+i+",";
        }
    }
    alert(output);
}
function hasSeven(m){
    var flag=false; 
    while(m>0&&flag==false){
        r = m%10;
        m = (m-r)/10;
        if(r==7){
            flag=true;
        }
    }
    return flag;
  }
function prime(m){
    var flag=true;
    var k=2;
    while(flag==true&&k<=m/2){
        if(m%k==0){
            flag=false;
        }
        k=k+1;
    }
    return flag;
}