d3.csv("../../자료분석/상권업종코드.csv", function(data){
    var businessTypeList = [];

    for(i=0;i<data.length;i++){
        if(i==0){
            businessTypeList.push(data[i]["중분류명"]);
        }
        else{
            if(businessTypeList[i-1]==data[i]["중분류명"]){
                continue;
            }
            else{
                businessTypeList.push(data[i]["중분류명"]);
            }
        }
    }

    for(i=0;i<businessTypeList.length;i++){
        document.write("<option>" + businessTypeList[i] + "</option>");
    }
});