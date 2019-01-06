package com.ThreadCurrentPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2019-1-6 19:29:33
 * 利用callable创建多线程
 * 可以return返回值
 * <p>
 * 主线程可以通过callable获得子线程的执行结果
 *
 *
 * Future模式 ajax模式
 * Future模式的核心在于：去除了主函数的等待时间，并使得原本需要等待的时间段可以用于处理其他业务逻辑
 * Futrure模式:对于多线程，如果线程A要等待线程B的结果，那么线程A没必要等待B，直到B有结果，可以先拿到一个未来的Future，等B有结果是再取真实的结果。
 */
public class ThreadPoolDemo06 {

    public static void main(String[] args) {

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        try {
            // Future 获取多线程执行的结果
            Future<String> submit = newCachedThreadPool.submit(new ThreadFutureDemo06());
            //获取异步执行的结果，如果没有结果可用，此方法会阻塞直到异步计算完成。
            String str01 = submit.get();

            //获取异步执行结果，如果没有结果可用，此方法会阻塞，但是会有时间限制，如果阻塞时间超过设定的timeout时间，该方法将抛出异常。
            String str02 = submit.get(10, TimeUnit.SECONDS);

            System.out.println(str01);
            System.out.println(str02);

            /**
             *
             * boolean isDone() ：如果任务执行结束，无论是正常结束或是中途取消还是发生异常，都返回true。
             * boolean isCanceller() ：如果任务完成前被取消，则返回true。
             * boolean cancel(boolean mayInterruptRunning) ：如果任务还没开始，执行cancel(...)方法将返回false；如果任务已经启动，执行cancel(true)方法将以中断执行此任务线程的方式来试图停止任务，如果停止成功，返回true；当任务已经启动，执行cancel(false)方法将不会对正在执行的任务线程产生影响(让线程正常执行到完成)，此时返回false；当任务已经完成，执行cancel(...)方法将返回false。mayInterruptRunning参数表示是否中断执行中的线程。
             *
             */

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            newCachedThreadPool.shutdown();
        }


    }
}


class ThreadFutureDemo06 implements Callable<String> {

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {

        System.out.println("正在执行任务 需要等待3秒...");
        Thread.sleep(3000);
        System.out.println("执行任务结束...");

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("HelloWorld ")
                .append(new AtomicInteger().incrementAndGet());

        return stringBuffer.toString();
//        return null;
    }
}
