



const key = Symbol("key");
const $theK = $("#theK");
let theK = {[key]:null};

$theK.click(function () {
    MyClass("theKey");
    const t1 = new Date();
    var tCount = 0;
    console.log("--------------" + $(this) + "= " + tCount + "--" + t1.Format("yyyy-MM-dd HH:mm:ss") +  "--"  + "--" + theK[key]);
    cook()
        .then(eat)
        .then(function(data){
            tCount.add(10);
            console.log(data + "------------");
            return "----d---";
        })
        .then(wash)
        .catch(function(data){
            tCount.add(100);
            console.log(data + '没法吃!');
        });
    console.log("--------------" + $(this) + "" + "--" + t1.Mon().Format("yyyy-MM-dd HH:mm:ss") + "--"  + "--" + theK[key]);

});



function MyClass(privateData) {
    theK[key] = privateData;
}



//做饭
function cook(){
    console.log('开始做饭。');
    var p = new Promise(function(resolve, reject){        //做一些异步操作
        setTimeout(function(){
            console.log('做饭完毕！');
            resolve('鸡蛋炒饭');
        }, 1000);
    });
    return p;
}

//吃饭
function eat(data){
    console.log('开始吃饭：' + data);
    var p = new Promise(function(resolve, reject){        //做一些异步操作
        setTimeout(function(){
            console.log('吃饭完毕!');
            resolve('一块碗和一双筷子');
        }, 2000);
    });
    return p;
}

function wash(data){
    console.log('开始洗碗：' + data);
    var p = new Promise(function(resolve, reject){        //做一些异步操作
        setTimeout(function(){
            console.log('洗碗完毕!');
            resolve('干净的碗筷');
        }, 2000);
    });
    return p;
}


