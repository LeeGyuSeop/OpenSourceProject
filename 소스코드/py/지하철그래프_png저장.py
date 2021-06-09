#!/usr/bin/env python
# coding: utf-8

# In[20]:


import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
from matplotlib import font_manager, rc
rc('font', family='HCR Dotum')
df = pd.read_csv("C:/Users/kidst/python code/지하철노선(5차가공).csv", encoding = 'euc-kr')
df


# In[29]:


station = input()


# In[30]:


data =df.loc[(df["지하철역"]==station),:]
morning = data["아침"]
lunch = data["점심"]
afternoon = data["오후"]
evening = data["저녁"]


# In[31]:


x = np.arange(5)

times = ['아침','점심','오후','저녁','']
values = [morning,lunch,afternoon,evening,0]
plt.bar(x,values)
plt.xticks(x,times)
plt.savefig('my_plot.png')


# In[ ]:




