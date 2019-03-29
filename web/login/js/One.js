window.onload=function () {
    var oDiv1=document.getElementById("sidebar");
    var oDiv2=document.getElementById("l_sidebar");
    var aLi1=oDiv1.getElementsByTagName("li");
    var aDiv=oDiv2.getElementsByTagName("div");





    for (var i=0;i<aDiv.length;i++){
        aDiv[i].style.display="none";
    }
    aDiv[0].style.display="block";
    oDiv2.style.display="block";

    aLi1[0].onclick=function(){
        for (var i=0;i<aDiv.length;i++){
            aDiv[i].style.display="none";
        }
        aDiv[0].style.display="block";
        oDiv2.style.display="block";

    }
    aLi1[2].onclick=function(){
        aDiv[0].style.display="none";
        for (var i=1;i<aDiv.length-2;i++){
            aDiv[i].style.display="block";
        }

    }
    aLi1[3].onclick=function(){
        for (var i=0;i<aDiv.length-1;i++){
            aDiv[i].style.display="none";
        }
        aDiv[aDiv.length-1].style.display="block";
    }
    var ALi=oDiv2.getElementsByClassName("droplink");
    var AUl1=oDiv2.getElementsByClassName("jczl_ul1");
    var aIco = oDiv2.getElementsByClassName("arrow");
    var oUl=document.getElementById("time");

    for (var i=0;i<ALi.length;i++){
        ALi[i].index=i;
        ALi[i].onclick=function () {
            // alert('成功')
            for (var j=0;j<AUl1.length;j++){
                AUl1[j].style.display="none"
            }
            AUl1[this.index].style.display="block";

        }
    }
    hour02();
    hour();
    function hour() {

        var timer=null;
        clearInterval(timer);
        timer=setInterval(hour02,1000);

    }
   function hour02(){
       var myDate = new Date();
       var year=myDate.getFullYear(); //获取完整的年份(4位,1970-????)
       var month=myDate.getMonth()+1; //获取当前月份(0-11,0代表1月)
       var date=myDate.getDate(); //获取当前日(1-31)

       var day=myDate.getDay(); //获取当前星期X(0-6,0代表星期天)
       var weeks = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");

       var h=myDate.getHours(); //获取当前小时数(0-23)
       var m=myDate.getMinutes(); //获取当前分钟数(0-59)
       var s=myDate.getSeconds(); //获取当前秒数(0-59)
       var str=year+"年"+num(month)+"月"+num(date)+"日"+"&nbsp;&nbsp;"+"【"+weeks[day]+"】"+"&nbsp;&nbsp;"+(h)+":"+num(m)+":"+num(s);
       oUl.innerHTML=str;
   }


function num(a) {
    return a<10?"0"+a:""+a;
}

}