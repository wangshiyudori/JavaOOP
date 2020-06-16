$(function () {

    //json数据的3种格式：
    //1.json格式的user对象
    var j1 = {
        ID: 1,
        "name": "zs",
        age: 22
    };
    console.log(j1);
    console.log(j1.name);
    console.log(j1.age);

    //2.json格式的字符串数组
    var arr1 = ["aa", "aaa", "ddd"];
    console.log(arr1);
    console.log(arr1[0]);

    //3.json格式的user对象数组
    var students = [
        {
            name: "zs",
            age: 21
        }, {
            name: "ls",
            age: 55
        }
    ];
    console.log(students);
    console.log(students[0].name);




});