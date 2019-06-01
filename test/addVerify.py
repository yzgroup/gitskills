# encoding:utf-8
#import sys
#print sys.getdefaultencoding()
#sys.setdefaultencoding('utf-8')
def jiafa( a, b ):
   #2019.03.24调试成功。<10的加法，调整random.randrang范围，并且修改print语句中的错位提示信息。
   # 返回2个参数的和.
   total = a + b
   return total






# 调用sum函数
import random
a=random.randrange(10)
b=random.randrange(10)
print(a,"+",b,"=?")
total =jiafa( a, b)

import numpy as np 
x = np.array([(1,10,100,1000,10000)])
a = np.array(a*x)
b = np.array(b*x)



d=float(input("您的运算结果="))


if  d == (a[:,0]+b[:,0]):
        print("正确结果为:%d"%(int(total)))
        print("结果正确!")
        
elif d==(a[:,0]+b[:,1]):   
        print("正确结果为:%d"%(int(total)))
        print('您的结果为:',int(d),"不正确——加数",b[:,0],"是个位数，被错误地放在了百位数的位置了。")   
        #print("正确结果为:%d"%(int(total)))
        #print("您的结果为:%d"%(int(d))+" 不正确加数:%d"%int(b[0:,1])+" 是个位数被错误地放在了十位数的位置了。")
        #print("不正确加数:%d"%int(b[0:,1]))
        #print("是个位数被错误地放在了十位数的位置了"）
elif d==(a[:,0]+b[:,2]):
        print("正确结果为:%d"%(int(total)))
        print('您的结果为:',int(d),"不正确——加数",b[:,0],"是个位数，被错误地放在了百位数的位置了。")

elif  d==(a[:,0]+b[:,3]):
        print("正确结果为:%d"%(int(total)))
        print('您的结果为:',int(d),"不正确——加数",b[:,0],"是个位数，被错误地放在了千位数的位置了。")
elif d==(a[:,0]+b[:,4]):
        print("正确结果为:%d"%(int(total)))
        print('您的结果为:',int(d),"不正确——加数",b[:,0],"是个位数，被错误地放在了万位数的位置了。")
    
elif  d==(a[:,1]+b[:,0]):      
        print("正确结果为:%d"%(int(total)))
        print('您的结果为:',int(d),"不正确——加数",a[:,0],"是个位数，被错误地放在了十位数的位置了。")
elif  d==(a[:,2]+b[:,0]):
        print("正确结果为:%d"%(int(total)))
        print('您的结果为:',int(d),"不正确——加数",a[:,0],"是个位数，被错误地放在了百位数的位置了。")
elif  d==(a[:,3]+b[:,0]):
        print("正确结果为:%d"%(int(total)))
        print('您的结果为:',int(d),"不正确——加数",a[:,0],"是个位数，被错误地放在了千位数的位置了。")
elif  d==(a[:,4]+b[:,0]):
        print("正确结果为:%d"%(int(total)))
        print('您的结果为:',int(d),"不正确——加数",a[:,0],"是个位数，被错误地放在了万位数的位置了。")
                            
elif  d != (a[:,0]+b[:,0]):
        print("正确结果为:%d"%(int(total)))
        print("结果错误!")
