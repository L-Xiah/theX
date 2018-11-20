


window.addEventListener('ajaxReadyStateChange', function (e) {
    console.log( "----------ajaxReadyStateChange---------" + e.detail); // XMLHttpRequest Object
});
window.addEventListener('ajaxAbort', function (e) {
    console.log("---------ajaxAbort---:" + e.detail.responseText); // XHR 返回的内容
});
window.addEventListener('ajaxLoadStart', function (e) {
    console.log("---------ajaxLoadStart---:" + e.detail.responseText); // XHR 返回的内容
});




const key = Symbol("key");
const $theK = $("#theK");
let theK = {[key]:null};

$("#theFile").on("click",function () {
    console.log("--theFile-theFileSystemFunc-" + window);
    //theFileSystemFunc();
    try{
        window.location.href = "/Download";
    }catch (e) {
        console.log("---------下载失败！！！");
    }

});

$("#theEvent").on("click",function () {
    console.log("----" + window);
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'infoJson');
    xhr.send();

    // 引入上边的js后，就可以调用生成文本的方法 另外ie下会有中文乱码的问题
    let blob = new Blob(["Hello, world!\t\n我是milo，你好啊"], {type: "text/plain;charset=utf-8"});
    saveAs(blob, "hello world.txt");


});


$theK.on("click",function () {

    MyClass("theKey");
    const t1 = new Date();
    let tCount = 0;
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
    return new Promise(function (resolve, reject) {        //做一些异步操作
        setTimeout(function () {
            console.log('做饭完毕！' + reject );
            resolve('鸡蛋炒饭');
        }, 1000);
    });
}

//吃饭
function eat(data){
    console.log('开始吃饭：' + data);
    return new Promise(function (resolve, reject) {        //做一些异步操作
        setTimeout(function () {
            console.log('吃饭完毕!' + reject);
            resolve('一块碗和一双筷子');
        }, 2000);
    });
}

function wash(data){
    console.log('开始洗碗：' + data);
    return new Promise(function (resolve, reject) {        //做一些异步操作
        setTimeout(function () {
            console.log('洗碗完毕!' + reject);
            resolve('干净的碗筷');
        }, 2000);
    });
}


