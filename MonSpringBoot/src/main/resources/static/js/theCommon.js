
(function () {

//region unUsed
    function getParamName() {}
    function fn() {
        var param1 = 0;
        var paramThe = 1;
        console.log(getParamName(param1));
        console.log(getParamName(paramThe));
    }

    function callWithVariableName(fn) {
        eval('(' + fn.toString().replace(/\bgetParamName\s*\(([a-zA-Z_$][\w_$]*)\)/g, function(u, v) {
            return "'" + v + "'"
        }) + '())')
    }

    var unUsedFunc = function (param) {
        //console.log("--thePk--unUsedFunc------/" + param);
        if(!param && !!param) {
            console.log("--unUsedFunc--" + param);
            callWithVariableName(fn);
        }
    };

//endregion

//region Number
    function accAdd(arg1,arg2){
        var r1,r2,m;
        try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
        try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
        m=Math.pow(10,Math.max(r1,r2));
        return (arg1*m+arg2*m)/m
    }

//给Number类型增加一个add方法，调用起来更加方便。
    Number.prototype.add = function (arg){
        return accAdd(arg,this);
    };

//endregion

    Date.prototype.Format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1,                 //月份
            "d+": this.getDate(),                    //日
            "H+": this.getHours(),                   //小时
            "m+": this.getMinutes(),                 //分
            "s+": this.getSeconds(),                 //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds()             //毫秒
        };
        if (/(y+)/.test(fmt))
            fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    };


    Date.prototype.Mon = function () {
        //这周一
        let rel = this;
        rel.setDate(rel.getDate()-(this.getDay()?this.getDay()-1:6));
        return rel;
    }



}());








