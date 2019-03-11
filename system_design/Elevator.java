package system_design;
/*
理论上应该先黑盒用例，分析需要求，系统边界的输入输出，再白盒类图。 但是对于现实世界模拟的OO，个人感觉先emulate现实世界，初步识别类和类之间的关系，再用用例和顺序图丰富、修正类图。
识别类，最主要的原则是封装，数据和数据的操作封装成一个类：
轿厢 box：封装轿厢的状态：位置、方向、静止还是运动，capacity,  pickup列表，目的地列表
楼building：用户请求电梯的媒介，和轿厢box有个一对一关联关系，向轿厢box发call消息，轿厢到达某层，向building发某层open的消息。
从控制驱动的角度，有2种控制流（主动对象）
1）轿厢box：不停地运转，根据请求的情况，运行或者停止等待信号
2）人：1是人向building发消息，building再 forward到box；2）是人向轿厢发消息，设置要去的目的地楼层
和VODController类似，内部一个驻留线程，类似一个状态机运行着，同时多个点可以接收异步消息更新数据。
亮点是一个事件机制，每经过一层，触发一个positionChanged的事件
总结：OO系统，就是一个互相发消息的对象系统，对象之间靠消息交互
常见的控制流模型:
1) 顺序执行，exit
2）无专门驻留线程，完全消息驱动，类似一般的web service，request/response模式。
3) 有一个驻留线程在run, (定时运行或者受信号控制），同时也可以接受异步消息更新数据，为社么说是异步消息，因为它只是通过update数据来影响状态机的运行，不需要返回什么结果。基于工作队列的处理系统也属于这种模型，但更简单，FIFO处理就行，电梯模型的复杂在于，系统会根据当前所有request的情况做一个调度，并不是简单的FIFO。

---------------------

本文来自 binling 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/binling/article/details/48520391?utm_source=copy 
 */
public class Elevator {
// https://blog.csdn.net/binling/article/details/48520391
}
