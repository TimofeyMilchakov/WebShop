/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function getOps(st)
       {
           var massId = ["buy","ots","ops","opsAndImj"];
           for(var i =0; i<massId.length;i++)
           {
               document.getElementById(massId[i]).style.display="none";
//               document.getElementById(massId[i]+"Li").class = document.getElementById("gl").class; 
               if(st==massId[i])
               {
                   document.getElementById(massId[i]).style.display="block";
//                   document.getElementById(massId[i]+"Li").class = "active";
               }
               
           }
           if(st!="ots")
           {
                document.getElementById('opsAndImj').style.display="block";
           }
           
//            if(num== 1){               
//                document.getElementById('buy').style.display="block";
//                document.getElementById('ots').style.display="none";
//                document.getElementById('opsAndImj').style.display="block";
//                document.getElementById('ops').style.display="none";
//            }
//            if(num== 2){
//                document.getElementById('buy').style.display="none";
//                document.getElementById('ots').style.display="none";
//                document.getElementById('opsAndImj').style.display="block";
//                document.getElementById('ops').style.display="block";
//            }
//            if(num== 3){
//                document.getElementById('buy').style.display="none";
//                document.getElementById('ots').style.display="block";
//                document.getElementById('opsAndImj').style.display="none";
//                document.getElementById('ops').style.display="none";
//            }
                
        }

