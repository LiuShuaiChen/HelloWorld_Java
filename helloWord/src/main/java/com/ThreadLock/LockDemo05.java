package com.ThreadLock;

import java.util.Date;

/**
 * 关于CAS无锁机制原理
 *  重要的关键点是:
 *
 *
 * 1)对死锁问题天生免疫 非阻塞性 并且线程间的相互影响也远远比基于锁的方式要小
 *  更为重要的是,使用无锁的方式完全没有锁的竞争带来的系统开销,也没有线程频繁调度带来的开销
 *  因此,它要比基于锁的方式拥有更优越的性能
 *
 * 2)无锁的好处
 *  a.在高并发的情况下,它比有锁的程序拥有更好的性能
 *  b.天生对死锁免疫
 *
 * 3)CAS算法的过程
 *  包含3个参数CAS(V,E,N):V表示要更新的变量,E表示预期值,N表示新值.
 *  仅当V值等于E值时,才会将V的值设为N,如果V值和E值不同,则说明已经有其他线程做了更新.则当前线程什么都不做.最后CAS返回当前V的真实值
 *
 * 4)CAS操作是抱着乐观的态度进行的,它总是认为自己可以成功完成操作的.
 *  当多个线程同时使用CAS操作一个变量时候,只有一个会胜出,并成功更新,其余均会失败.
 *  失败的线程不会被挂起,仅是被告知失败,并且允许再次尝试,当然也允许失败的线程放弃操作.
 *  基于这样的原理,CAS操作即使没有锁,也可以发现其他线程对当前线程的干扰,并进行恰当的处理.
 *
 * 5)简单来说:CAS需要你额外地给出一个期望值,也就是你认为这个变量现在应该是什么样子的.如果变量不是你想象的那样,那说明它已经被别人修改过了
 *  你就要重新读取,再次尝试修改即可.
 *
 * 6)在硬件层面:大部分的现代处理器已经支持原子化的CAS指令.在JDK5.0以后,虚拟机可以使用这个致命来实现并发操作和并发数据结构
 *
 *
 */
public class LockDemo05  {

    public static void main(String[] args) {

        Date date = new Date();

        System.out.println(date.getTime()+"");

        System.out.println(new Date().getTime() - Integer.valueOf(5) * 60000);

        System.out.println(new Date().getTime());

        System.out.println(System.currentTimeMillis());


    }

}