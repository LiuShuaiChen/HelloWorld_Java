package com.ThreadLock;

/**
 * 乐观锁
 *
 * 本质没有锁 效率比较高 无阻塞 无等待 重试  CAS无锁机制
 * 设计表: Version字段 update add操作的时候
 * update table set x=x+1,version=version+1 where id = #{id} and version = #{version}
 * 如果能够使用到版本(version和id) 如果能查到,就是之前没有更改过的记录.
 * 反之 查不到的情况下-- 版本已经发生改变了 这样的话去修改值已经无法修改.
 *
 * 乐观锁不会产生死锁 因为乐观锁没有锁
 *
 * select version from table where id = #{id}
 * update table set version=version+1, name=name where id = #{id} and version version=#{version}
 *
 * 如果查不到就会不断重试
 *
 */
public class LockDemo04 {

    public static void main(String[] args) {

        System.out.println("HelloWorld");

    }
}