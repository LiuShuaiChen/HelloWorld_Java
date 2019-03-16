package com.alice.jmm;

/**
 * 配置堆内存大小
 * -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
 * -Xms20m -Xmx20m -Xmn5m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
 */
public class heapMemory {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        System.out.println("最大内存:" + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");
        System.out.println("可用内存:" + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
        System.out.println("已经使用内存:" + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");


        heapMemory heapMemory = new heapMemory();
        heapMemory.setName("HelloWorld");

        heapMemory = null;
//        System.gc();
        //[GC (Allocation Failure) [DefNew: 2560K->886K(3840K), 0.0015883 secs] 2560K->886K(19200K), 0.0016185 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        //[Full GC (System.gc()) [Tenured: 0K->890K(10240K), 0.0034807 secs] 2690K->890K(17920K), [Metaspace: 3369K->3369K(1056768K)], 0.0035294 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]

    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("FULL GC RUNING...");
    }
}
