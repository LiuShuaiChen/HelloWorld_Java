package com.alice.jmm;

import com.SingleMode.Demo03.entity.Student;

import java.util.ArrayList;

/**
 * 内存溢出问题
 * -Xms5m -Xmx10m -Xmn5m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
 * 垃圾回收的基本原则:内存不足的时候就会去回收垃圾,内容富裕则不会触发回收垃圾
 */
public class heapMemory01 {

    public static void main(String[] args) {
        ArrayList<Student> studentsList = new ArrayList<>();
        for (int i = 0; i < 20000; i++) {
            Student student = new Student();
            student.setAddress("beijing");
            student.setAge(i);
            student.setId(i);
            student.setName("alice_"+i);
            studentsList.add(student);
        }

        System.out.println("add All student...");
        System.gc();

    }

    /**
     * [GC (Allocation Failure) [PSYoungGen: 3072K->1016K(4096K)] 3072K->1160K(5120K), 0.0010200 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [GC (Allocation Failure) [PSYoungGen: 4088K->1018K(4096K)] 4232K->2878K(6144K), 0.0019393 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [Full GC (Ergonomics) [PSYoungGen: 1018K->1000K(4096K)] [ParOldGen: 1860K->1739K(5120K)] 2878K->2740K(9216K), [Metaspace: 3460K->3460K(1056768K)], 0.0151947 secs] [Times: user=0.09 sys=0.00, real=0.01 secs]
     * add All student...
     * Heap
     *  PSYoungGen      total 4096K, used 1212K [0x00000000ffb00000, 0x0000000100000000, 0x0000000100000000)
     *   eden space 3072K, 6% used [0x00000000ffb00000,0x00000000ffb35120,0x00000000ffe00000)
     *   from space 1024K, 97% used [0x00000000fff00000,0x00000000ffffa060,0x0000000100000000)
     *   to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
     *  ParOldGen       total 5120K, used 1739K [0x00000000ff600000, 0x00000000ffb00000, 0x00000000ffb00000)
     *   object space 5120K, 33% used [0x00000000ff600000,0x00000000ff7b2fa0,0x00000000ffb00000)
     *  Metaspace       used 3467K, capacity 4564K, committed 4864K, reserved 1056768K
     *   class space    used 376K, capacity 388K, committed 512K, reserved 1048576K
     */


    /**
     * [GC (Allocation Failure) [PSYoungGen: 3072K->1016K(4096K)] 3072K->1264K(5120K), 0.0009589 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [GC (Allocation Failure) [PSYoungGen: 4088K->1018K(4096K)] 4336K->2874K(6656K), 0.0017715 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [Full GC (Ergonomics) [PSYoungGen: 1018K->499K(4096K)] [ParOldGen: 1856K->2233K(5120K)] 2874K->2732K(9216K), [Metaspace: 3460K->3460K(1056768K)], 0.0191650 secs] [Times: user=0.19 sys=0.00, real=0.02 secs]
     * add All student...
     * [GC (System.gc()) [PSYoungGen: 739K->688K(4096K)] 2972K->2921K(9216K), 0.0008920 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [Full GC (System.gc()) [PSYoungGen: 688K->0K(4096K)] [ParOldGen: 2233K->2805K(5120K)] 2921K->2805K(9216K), [Metaspace: 3461K->3461K(1056768K)], 0.0114657 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     * Heap
     *  PSYoungGen      total 4096K, used 31K [0x00000000ffb00000, 0x0000000100000000, 0x0000000100000000)
     *   eden space 3072K, 1% used [0x00000000ffb00000,0x00000000ffb07c58,0x00000000ffe00000)
     *   from space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
     *   to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
     *  ParOldGen       total 5120K, used 2805K [0x00000000ff600000, 0x00000000ffb00000, 0x00000000ffb00000)
     *   object space 5120K, 54% used [0x00000000ff600000,0x00000000ff8bd6c0,0x00000000ffb00000)
     *  Metaspace       used 3467K, capacity 4564K, committed 4864K, reserved 1056768K
     *   class space    used 376K, capacity 388K, committed 512K, reserved 1048576K
     */
}
