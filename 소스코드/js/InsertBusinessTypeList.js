d3.csv("../../자료분석/상권업종코드.csv", function(error,data){
    var businessTypeList = [];
    if(error) throw error;

    for(var i=0;i<data.length;i++){
        if(i == 0){
            businessTypeList.push(data[i]["대분류명"]);
        }
        else{
            if(businessTypeList[i-1] == data[i]["대분류명"]){
                continue;
            }
            else{
                businessTypeList.push(data[i]["대분류명"]);
            }
        }
    }
    for(var i=0;i<businessTypeList.length;i++){
        document.write("<option>" + businessTypeList[i] + "</option>");
    }
});