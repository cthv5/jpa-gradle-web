$(function(){
    console.log('hello,Welcome to the MorFans Lab!');
    console.info('信息:cth欢迎您！');
    console.error('错误：这是cth的错误信息！');
    console.warn('警告：cth不见了！');
    var info = {
        message:"cth欢迎你 ..."
    };
    console.dir(info);
    console.group("第一组信息");
        console.log("第一组第一条:cth 1");
        console.log("第一组第二条:cth 11");
    console.groupEnd();
        console.group("第二组信息");
        console.log("第二组第一条:cth 2");
        console.log("第二组第二条:cth 22");
    console.groupEnd();
    console.time("计时器一");
    for(var i=0;i<1000;i++){
        for(var j=0;j<1000;j++){}
    }
    console.timeEnd("计时器一");

    $('#startDate').datetimepicker({
        language:"zh-CN", //汉化
        todayBtn : "true",  //显示今天按钮
        autoclose : true,   //选择日期后自动关闭日期选择框
        todayHighlight : true,   //当天高亮显示
        minView: 2,   //不显示时分秒
        format: 'yyyy-mm-dd',
        pickerPosition: "bottom-left"
    }).on('click',function(e){
        $("#startDate").datetimepicker("setEndDate", $("#endDate").val());
    });

    $('#endDate').datetimepicker({
        language:"zh-CN",
        todayBtn : "true",
        autoclose : true,
        todayHighlight : true,
        minView: 2,
        format: 'yyyy-mm-dd',
        pickerPosition: "bottom-left"
    }).click(function(){
        $("#endDate").datetimepicker("setStartDate", $("#startDate").val());
    });
});