关于实训项目的所有源代码：
一、ourmr是MapReduce的代码：
主要运用的是MapReduce将超市的订单数据提取出每个市的销售量，每月订单数量，每个省的销售数量，每种标准的销售量，每月每种邮寄类型的数量，每月每种产品的数量并各自生成对应的表存入数据库中
mr文件夹里是每种MapReduce操作的具体代码，bean里是类的定义
二、ourweb是数据库前端可视化的代码
后端主要利用SSM框架，前端有几个用了springboot框架，通过SSM框架连接MySQL数据库并在前端利用echars将数据用json在前端可视化出来，并简单加入了登录注册功能，并利用echars绘制出了3D地图（echars官网有的js包不全，缺什么直接百度就可以，甚至有一个省的经纬度还是俺们手打上去的），具体可见内部代码（每种对比都用echars绘制了很多种图，如条形，饼状，折线，所以前端上有20多种图，在这里不一一描述了，有兴趣可以下载看看）
emmm前端的主要框架是从源码之家下载并按自己的需求改进的，echars也是echars官网就有的代码，主要难一点的是json的调用，和后端相关代码的编写。
