import pandas as pd
import numpy as np
from haversine import haversine, Unit
import time
sd = pd.read_csv("D:/GIT_Project/OpenSourceProject/자료분석/지하철노선(3차가공).csv", encoding = 'euc-kr')
print("input district")
a=input()
print("input commercial")
b=input()

data=sd.loc[(sd["자치구"]== a) ,:]

station=data["지하철역"]
x=data["X좌표값"]
y=data["Y좌표값"]

ca=pd.read_csv("D:/GIT_Project/OpenSourceProject/자료분석/상권정보(칸분리).csv",encoding='UTF-8')
commercialData=ca.loc[(ca["시군구명"]==a),:]
staX=commercialData["경도"]
staY=commercialData["위도"]
commer=commercialData["상호명"]
Classification=commercialData["상권업종중분류명"]

for i in range(len(x)):
   a=(float(x.iloc[i]),float(y.iloc[i]))
   selcount=0
   count=0
   for j in range(len(commercialData)):
      c=(float(staX.iloc[j]),float(staY.iloc[j]))
      
      if haversine(a,c)<=0.4:
         if Classification.iloc[j]==b:
            selcount+=1
         else :
            count+=1

   print(station.iloc[i],"역 비율=",count/selcount)   
      
