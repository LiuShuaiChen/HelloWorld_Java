package com.ThreadLock;

/**
 * 2019-1-10 19:04:25
 * 悲观锁
 * CAS--SSO单点登录
 *
 * 总是假设最坏的情况，每次取数据时都认为其他线程会修改，所以都会加锁（读锁、写锁、行锁等），当其他线程想要访问数据时，都需要阻塞挂起。
 * 可以依靠数据库实现，如行锁、读锁和写锁等，都是在操作之前加锁，
 * 在Java中，synchronized的思想也是悲观锁。
 *
 *
 *
 */
public class LockDemo03 {

    public static void main(String[] args) {

    }
}