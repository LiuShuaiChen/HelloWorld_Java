package com.DesignMode.Demo04;

/**
 * 设计模式 结合业务需求 或者自己搭建框架
 * 23种设计模式 方便维护 扩展性 减少冗余代码 降低耦合度 方便扩展开发
 *
 * 在做项目的时候,首先了解需求,不要立马写代码,封装代码
 * 拿到需求之后,第一步 "应该思考" 怎么重构代码
 *
 *
 * 使用分布式配置中心,特点:解决动态获取配置文件信息
 * eg:使用zookeeper搭建分布式配置中心
 * SpringCloud 自带分布式配置中心
 * 修改配置自动重启JVM
 *
 *
 * 什么是单例设计模式?
 *  保证在JVM中,只能存在一个实例,保证对象的唯一性.
 *
 * 单例设计模式应用场景
 *  servlet springMVC struts2 spring 连接池 线程池 枚举 常量
 *
 * 为什么要设计成单例模式? 单例的优缺点?
 *  单例的优点
 *      节约内存 重复利用 方便管理
 *  单例的缺点
 *      线程安全问题
 *
 * 单例有几种创建方式? 总共有5种创建方式
 *  饿汉式: 类初始化时,会立即加载该对象,线程天生安全,调用效率搞
 *  懒汉式: 类初始化时,不会初始化该对象,真正需要使用的时候才会创建该对象,具备赖加载功能
 *  静态内部方式: 结合了懒汉和饿汉各自的优点,真正需要对象的时候才会加载,加载类是线程安全的.
 *  枚举单例: 使用枚举实现单例模式 优点:实现简单,调用效率高,枚举本身就是单例,由JVM从根本上提供保障.避免通过反射和反序列化的漏洞. 缺点:没有延迟加载.
 *  双重检测锁: 因为JVM本质重排序的原因,可能会被初始化多次,因此不推荐使用
 *
 *
 * 如何选择单例的创建方式?
 *  如果不需要延迟加载单例,可以使用枚举或者饿汉式,相对来说枚举性能要好于饿汉式
 *  如果需要延迟加载单例,可以使用静态内部类或者懒汉式,相对来说静态内部类性能要好于饿汉式
 *
 */
public class HelloWorld {

    public static void main(String[] args) {
        SingleModeDemo01 singleModeDemo01=SingleModeDemo01.GetInstance();

        SingleModeDemo02 singleModeDemo02 = SingleModeDemo02.getInstance();

        SingleModeDemo03 singleModeDemo03 = SingleModeDemo03.getInstance();

    }

}
