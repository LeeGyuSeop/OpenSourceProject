var selectLargeValue;

function showBusiness(typeClass){
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
        showBusiness(food);
    }
    else if(value == "생활서비스"){
        showBusiness(lifeService);
    }
    else if(value == "소매"){
        showBusiness(retail);
    }
    else if(value == "관광/여가/오락"){
        showBusiness(tourismLeisureEntertainment);
    }
    else if(value == "스포츠"){
        showBusiness(sports);
    }
    else if(value == "학문/교육"){
        showBusiness(academicEducation);
    }
}

function showChart(){
    var chartSpace = document.getElementById("chart");
    var select = document.getElementById("selectBox2");

    var value = select.options[select.selectedIndex].value;

    for(var i = 1;i<select.length;i++){
        if(select.selectedIndex == i){
            chartSpace.innerHTML = "<img src ='../chart/my_plot" + i + ".png'>";
        }
    }
}

var selectAreaValue;

function showStation(areaClass){
    if(selectAreaValue != null){
        for(var i = 0; i<selectAreaValue.length;i++){
            selectAreaValue[i].hidden = true;
        }
        for(var i = 0; i<areaClass.length;i++){
            areaClass[i].hidden = false;
        }
    }
    else{
        for(var i = 0; i<areaClass.length;i++){
            areaClass[i].hidden = false;
        }
    }
    selectAreaValue = areaClass;
}

function selectStaion(){
    var area = document.getElementById("areaBox2");
    var gangnam = document.getElementsByClassName("gangnam");
    var gangdong = document.getElementsByClassName("gangdong");
    var gangbuk = document.getElementsByClassName("gangbuk");
    var gangseo = document.getElementsByClassName("gangseo");
    var gwanak = document.getElementsByClassName("gwanak");
    var gwangjin = document.getElementsByClassName("gwangjin");
    var guro = document.getElementsByClassName("guro");
    var geumcheon = document.getElementsByClassName("geumcheon");
    var noweon = document.getElementsByClassName("noweon");
    var dobong = document.getElementsByClassName("dobong");
    var dogndaemun = document.getElementsByClassName("dogndaemun");
    var dongjak = document.getElementsByClassName("dongjak");
    var mapo = document.getElementsByClassName("mapo");
    var seodaemun = document.getElementsByClassName("seodaemun");
    var seocho = document.getElementsByClassName("seocho");
    var seongdong = document.getElementsByClassName("seongdong");
    var seongbuk = document.getElementsByClassName("seongbuk");
    var songpa = document.getElementsByClassName("songpa");
    var yangcheon = document.getElementsByClassName("yangcheon");
    var yeongdeungpo = document.getElementsByClassName("yeongdeungpo");
    var yongsan = document.getElementsByClassName("yongsan");
    var eunpyeong = document.getElementsByClassName("eunpyeong");
    var jongno = document.getElementsByClassName("jongno");
    var jung = document.getElementsByClassName("jung");
    var jungnang = document.getElementsByClassName("jungnang");

    var value = area.options[area.selectedIndex].value;

    if(value == "강남구"){
        showStation(gangnam);
    }
    else if(value == "강동구"){
        showStation(gangdong);
    }
    else if(value == "강북구"){
        showStation(gangbuk);
    }
    else if(value == "강서구"){
        showStation(gangseo);
    }
    else if(value == "관악구"){
        showStation(gwanak);
    }
    else if(value == "광진구"){
        showStation(gwangjin);
    }
    else if(value == "구로구"){
        showStation(guro);
    }
    else if(value == "금천구"){
        showStation(geumcheon);
    }
    else if(value == "노원구"){
        showStation(noweon);
    }
    else if(value == "도봉구"){
        showStation(dobong);
    }
    else if(value == "동대문구"){
        showStation(dogndaemun);
    }
    else if(value == "동작구"){
        showStation(dongjak);
    }
    else if(value == "마포구"){
        showStation(mapo);
    }
    else if(value == "서대문구"){
        showStation(seodaemun);
    }
    else if(value == "서초구"){
        showStation(seocho);
    }
    else if(value == "성동구"){
        showStation(seongdong);
    }
    else if(value == "성북구"){
        showStation(seongbuk);
    }
    else if(value == "송파구"){
        showStation(songpa);
    }
    else if(value == "양천구"){
        showStation(yangcheon);
    }
    else if(value == "영등포구"){
        showStation(yeongdeungpo);
    }
    else if(value == "용산구"){
        showStation(yongsan);
    }
    else if(value == "은평구"){
        showStation(eunpyeong);
    }
    else if(value == "종로구"){
        showStation(jongno);
    }
    else if(value == "중구"){
        showStation(jung);
    }
    else if(value == "중랑구"){
        showStation(jungnang);
    }

}