
function theFileSystemFunc() {
    var fso = new ActiveXObject("Scripting.FileSystemObject");
    var f1 = fso.createtextfile("E:\\myjstest.txt",true);// var f1 = fso.GetFile("E:\\myjstest.txt");
// 填写数据，并增加换行符
    f1.WriteLine("Testing 1, 2, 3.") ;
// 增加3个空行
    f1.WriteBlankLines(3);
// 填写一行，不带换行符
    f1.Write ("Hello World!");
    f1.Write ("我是...");
    f1.Write ("我是...");
// 关闭文件
    f1.Close();
}
