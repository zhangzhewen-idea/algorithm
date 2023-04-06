package org.zhangzhewen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

import org.zhangzhewen.User;

import javax.sound.sampled.AudioInputStream;

/**
 * t
 *
 * @author zhangzhewen
 * @date 2020/6/12
 */

@Data
public class Practise {
    /*

    1、任意一个偶数（大于2）都可以由2个素数组成，而且组合情况有多种，编程实现输入一个偶数输出两个素数差值最小的素数对 ****
    备注：质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数；否则称为合数（规定1既不是质数也不是合数）。
    举例：输入：10；有2个素数对：3,7 以及 5 5；；；输出：5 - 5 = 0

    2、用2种方式 实现 单例

    3、启动4个线程，2个线程对变量i加一，2个线程对变量i减一 ；只要执行一次，不要求前后顺序。

    公办高校验证地址 https://www.chsi.com.cn/xlcx/lscx/query.do
      民办高校验证地址 http://www.ckhci.com.cn/
    https://sms-activate.org/cn
     */
    static volatile int index = 0;


    static Map<String, Integer> count = new HashMap();

    static void handle(String s) {
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count.put(word.toString(),
                        count.getOrDefault(word.toString(), 0) + 1);
                word = new StringBuilder();
            } else {
                word.append(s.charAt(i));
            }
        }
        count.put(word.toString(),
                count.getOrDefault(word.toString(), 0) + 1);
    }

    static int 超级电脑(int a, int b, int c) {
        return a + b + c;
    }

    void swap(int[] n, int i, int j) {
        if (i != j) {
            int a = n[i];
            n[i] = n[j];
            n[j] = a;
        }
    }

    static int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

    public static int min(int... a) {
        int min = a[0];
        for (int i : a) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    public static int max(int... a) {
        int max = a[0];
        for (int i : a) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> ans = new ArrayList();
        LinkedList<Integer> sub = new LinkedList();
        int sum =0,s=1,f=2;
        sub.add(1);
        while(f<=target){
            sub.add(f);
            sum+=f;
            while(sum>target){
                sum-=s;
                s++;
            }
            if(sum==target){
                ans.add(Arrays.stream(sub.stream().toArray()).mapToInt(o->(int)o).toArray());
            }
            f++;
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) throws InterruptedException {
//        new Practise().getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4},8);
//        new Practise().getLeastNumbers(new int[]{3,2,1},2);



        System.out.println();
        Person 怪兽 = new Person();
        怪兽.名字 = "怪兽";
        怪兽.攻击力 = 100;
        怪兽.防御力 = 90;
        怪兽.血 = 1001;
        Person 张峻祎 = new Person();
        张峻祎.名字 = "张峻祎";
        张峻祎.攻击力 = 300;
        张峻祎.防御力 = 200;
        张峻祎.血 = 400;
        Person 陈文美 = new Person();
        陈文美.名字 = "陈文美";
        陈文美.攻击力 = 10;
        陈文美.防御力 = 9;
        陈文美.血 = 11;

        张峻祎.攻击(怪兽);
        陈文美.攻击(怪兽);
        张峻祎.攻击(怪兽);
        陈文美.攻击(怪兽);
        怪兽.攻击(陈文美);
    }
}

abstract class Base {
    public String 名字;
    public long 血;
    public long 攻击力;
    public long 防御力;

    abstract void 攻击(Base b);
}

@AllArgsConstructor
class Person extends Base {

    public void 攻击(Base b) {
        b.血 -= this.攻击力;
        System.out.println(this.名字+"打"+b.名字);
        System.out.println(this.名字 + "说：哈哈哈哈！" + b.名字 + "的血只有" + b.血 + "了！");
        if (b.血 < 0) {
            System.out.println(b.名字 + "说：啊！！！我死了。。。" + this.名字 + "好厉害！");
        } else {
            System.out.println(b.名字 + "说：啊！！！我飞了！！我还会回来的，" + this.名字 + "你等着！");
        }
        System.out.println();
    }
}
