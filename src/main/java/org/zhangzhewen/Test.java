package org.zhangzhewen;

import lombok.Data;

public class Test {
    static{
        System.out.println(111);
    }
    {
        System.out.println(333);
    }

    // 主方法的快捷代码: m+回车
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("林森蝶到此一游!!!");

    }
    }
@Data
 class User {
    public static String name="Hydra";
    int age;
}
