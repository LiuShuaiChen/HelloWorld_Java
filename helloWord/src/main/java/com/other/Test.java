package com.other;


import com.google.common.collect.Lists;
import org.apache.commons.lang3.ArrayUtils;

import java.util.List;

public class Test {

    private int instanceId;

    public int[] getInstanceIdArr() {
        return instanceIdArr;
    }

    public void setInstanceIdArr(int[] instanceIdArr) {
        this.instanceIdArr = instanceIdArr;
    }

    private int[] instanceIdArr;

    private String instanceIdStr;

    public String getInstanceIdStr() {
        return instanceIdStr;
    }

    public void setInstanceIdStr(String instanceIdStr) {
        this.instanceIdStr = instanceIdStr;
    }

    public int getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(int instanceId) {
        this.instanceId = instanceId;
    }

    public static void main(String[] args) {
//        ArrayUtils.getLength(["a", "b", "c"]);
        System.out.println(ArrayUtils.getLength(args));
        String[] strArray = {"1", "2", "3"};
        System.out.println(ArrayUtils.getLength(strArray));

        System.out.println(ArrayUtils.getLength(new String[]{"a", "b", "c"}));

        System.out.println();



        List<Integer> instances = Lists.newArrayList();

        Test test = new Test();
//        test.setInstanceIdStr((String) ArrayUtils.toPrimitive(strArray));
        test.setInstanceIdArr(ArrayUtils.toPrimitive(instances.toArray(new Integer[0])));
        System.out.println(test.getInstanceIdArr().length);

        test = null;

        System.gc();

    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("com.other.Test.finalize");

    }
}
