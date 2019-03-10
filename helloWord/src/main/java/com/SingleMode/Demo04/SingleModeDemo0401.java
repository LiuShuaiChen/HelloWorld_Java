package com.SingleMode.Demo04;

/**
 * 枚举方式
 * 枚举本身是单例的,一般用于项目定义
 *
 * 使用枚举方式实现单例模式
 *  优点:实现简单,枚举本身就是单例.由JVM从根本上提供保证!避免通过反射和序列化的漏洞
 *  缺点:没有延迟加载
 */

class User{
    public static User getInstance(){
        return singleModeUser.INSTANCE.getInstance();
    }

    private static enum singleModeUser{
        INSTANCE;
        private User user;

        private singleModeUser() {
            System.out.println("com.DesignMode.Demo04.User.singleModeDemo0401.singleModeDemo0401");
            user = new User();
        }

        public User getInstance(){
            return user;
        }
    }
}

public class SingleModeDemo0401 {

    public static void main(String[] args) {

        User user1 = User.getInstance();
        User user2 = User.getInstance();
        System.out.println(user1 == user2);

    }

}
