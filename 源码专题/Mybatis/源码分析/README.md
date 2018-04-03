<p>2018/03/28<br />
1. org.apache.ibatis.binding.MapperProxy#invoke 这个类的53行什么时候执行？<br />
从源码上看，public、非static、非abstract的方法，并且此方法是在接口里面才可以执行。按照以前的思维接口里面的方法都是抽象方法，查阅资料后发现：JavaSE 8新特性接口可以定义非抽象方法但必须使用default或者staic关键字来修饰。 &nbsp;接口里面加入如下方法public default Test selectByPrimaryKey(Integer id){return null;}测试可以执行。<br />
2018/03/31<br />
1. TestMapper 作者为什么要设计这样的形式来做？为什么不是一个class而是一个interface?<br />
2.org.apache.ibatis.executor.BaseExecutor#queryFromDatabase 322行这行代码的意义<br />
3.MyBatis的plugin实现机制<br />
4.lazy loading 是怎么做到的？<br />
2018/04/01<br />
1. 手写1.0<br />
2. 2.0版本的基础上，用annotation</p>
