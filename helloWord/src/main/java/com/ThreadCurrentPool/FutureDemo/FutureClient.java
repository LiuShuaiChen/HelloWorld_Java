package com.ThreadCurrentPool.FutureDemo;

/**
 * Future客户端
 */
public class FutureClient {
    public DataDemo request(String query) {
        FutureDataDemo futureDataDemo = new FutureDataDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                RealDataDemo realDataDemo = new RealDataDemo(query);
                futureDataDemo.setRealDataDemo(realDataDemo);

            }
        }).start();

        return futureDataDemo;
    }
}
