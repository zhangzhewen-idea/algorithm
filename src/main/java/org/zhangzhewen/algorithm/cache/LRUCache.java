package org.zhangzhewen.algorithm.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * LRUCache
 * todo 需要继续做，有bug
 * https://leetcode-cn.com/problems/lru-cache/submissions/
 * https://time.geekbang.org/course/detail/130-72545
 *
 * @author zhangzhewen
 * @date 2020/5/12
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4

        LRUCache cache2 = new LRUCache(1);
        cache2.put(2, 2);
        cache2.put(1, 1);
        System.out.println(cache2.get(1));

    }

    private final LinkedList linkedList;

    private class LinkedList {

        Node front;
        Node rear;

        Map<Integer, Node> valMap = new HashMap<>();

        private class Node {
            Node next;
            Node prev;
            int val;
        }

        public LinkedList(int capacity) {
            Node prev = null;
            for (int i = 0; i < capacity; i++) {
                Node current = new Node();
                if (prev != null) {
                    prev.next = current;
                    current.prev = prev;
                }
                prev = current;
                if (i == 0) {
                    this.front = current;
                }
            }
            this.rear = prev;
        }

    }

    public LRUCache(int capacity) {
        linkedList = new LinkedList(capacity);
    }

    public int get(int key) {
        LinkedList.Node hit = linkedList.valMap.get(key);
        if (hit == null) {
            return -1;
        }
        put(key, hit.val);
        return hit.val;
    }

    public void put(int key, int value) {
        LinkedList.Node hit = linkedList.valMap.get(key);
        if (hit != null) {

            if (hit == linkedList.front) {
                linkedList.front.val = value;
                return;
            } else if (hit != linkedList.rear) {
                hit.prev.next = hit.next;
                hit.next.prev = hit.prev;

                hit.prev = linkedList.rear;
                linkedList.rear.next = hit;
                hit.next = null;

                linkedList.rear = hit;
            }

        }

        linkedList.valMap.remove(linkedList.rear.val);

        linkedList.rear.val = value;

        if (linkedList.rear.prev != null){
            linkedList.rear.prev.next = null;
        }
        linkedList.rear.next = linkedList.front;
        linkedList.front.prev = linkedList.rear;

        linkedList.front = linkedList.rear;
        linkedList.rear = linkedList.rear.prev;
        linkedList.front.prev = null;

        linkedList.valMap.put(key, linkedList.front);

    }
}
