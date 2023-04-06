package org.zhangzhewen;

import lombok.Data;

public class Test {
    static{
        System.out.println(111);
    }
    {
        System.out.println(333);
    }
}
@Data
 class User {
    public static String name="Hydra";
    int age;
}
