var selectLargeValue;

function show(typeClass){
    if(selectLargeValue != null){
        for(var i = 0; i<selectLargeValue.length;i++){
            selectLargeValue[i].hidden = true;
        }
        for(var i = 0; i<typeClass.length;i++){
            typeClass[i].hidden = false;
        }
    }
    else{
        for(var i = 0; i<typeClass.length;i++){
            typeClass[i].hidden = false;
        }
    }
    selectLargeValue = typeClass;
}

function selectBusinessType(){
    var largeType = document.getElementById("selectBox1");
    var middleType = document.getElementById("selectBox2");
    var food = document.getElementsByClassName("food");
    var lifeService = document.getElementsByClassName("lifeService");
    var retail = document.getElementsByClassName("retail");
    var tourismLeisureEntertainment = document.getElementsByClassName("tourismLeisureEntertainment");
    var sports = document.getElementsByClassName("sports");
    var academicEducation = document.getElementsByClassName("academicEducation");
    var lodgment = document.getElementsByClassName("lodgment");
    var estate = document.getElementsByClassName("estate");

    var value = largeType.options[largeType.selectedIndex].value;
    if(value == "음식"){
        show(food);
    }
    else if(value == "생활서비스"){
        show(lifeService);
    }
    else if(value == "소매"){
        show(retail);
    }
    else if(value == "관광/여가/오락"){
        show(tourismLeisureEntertainment);
    }
    else if(value == "스포츠"){
        show(sports);
    }
    else if(value == "학문/교육"){
        show(academicEducation);
    }
    else if(value == "숙박"){
        show(lodgment);
    }
    else if(value == "부동산"){
        show(estate);
    }
}