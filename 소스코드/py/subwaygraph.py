#!python
#-*- coding: utf-8 -*-

import sys
import codecs
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
from matplotlib import font_manager, rc
sys.stdout=codecs.getwriter("utf-8")(sys.stdout.detach())
print("content-type: text/html; charset=utf-8\n")
rc('font', family='HCR Dotum') 
df = pd.read_csv("../DATA/지하철노선(5차가공).csv", encoding = 'UTF-8')         

station = "동대문"
data =df.loc[(df["지하철역"]==station),:]
morning = data["아침"]
lunch = data["점심"]
afternoon = data["오후"]
evening = data["저녁"]

x = np.arange(5)
times = ['아침','점심','오후','저녁','']
values = [morning,lunch,afternoon,evening,0]
plt.bar(x,values)
plt.xticks(x,times)
plt.savefig('my_plot.png')

