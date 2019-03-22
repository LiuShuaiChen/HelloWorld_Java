package com.SingleMode.Demo04;

/**
 * 枚举方式
 * 枚举本身是单例的,一般用于项目定义
 *
 * 使用枚举方式实现单例模式
 *  优点:实现简单,枚举本身就是单例.由JVM从根本上提供保证!避免通过反射和序列化的漏洞
 *  缺点:没有延迟加载
 */

enum userEnum {
    HTTP_200(200, "请求成功"), HTTP_500(500, "请求失败");


    private Integer code;
    private String name;

    userEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class SingleModeDemo04 {

    public static void main(String[] args) {
        System.out.println(userEnum.HTTP_500.getCode());
        System.out.println(userEnum.HTTP_500.getName());
        System.out.println(userEnum.HTTP_200.getCode());
        System.out.println(userEnum.HTTP_200.getName());
    }

}
