package org.zhangzhewen.algorithm.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 根据字符出现频率排序451
 *
 * @author zhangzhewen
 * @date 2020/10/27
 */
public class 根据字符出现频率排序451 {
    public static void main(String[] args) {
        new 根据字符出现频率排序451().frequencySort("cbbaaaaaa");
    }


    public String frequencySort(String s) {
        int[] letters = new int[128];
        for (char c : s.toCharArray()) {
            letters[c]++;
        }
        PriorityQueue<Character> heap = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return letters[o2] - letters[o1];
            }
        });
        for (int i = 0; i < letters.length; ++i) {
            if (letters[i] != 0) {
                heap.offer((char)i);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!heap.isEmpty()) {
            char c = heap.poll();
            while (letters[c] > 0) {
                res.append(c);
                letters[c]--;
            }
        }
        return res.toString();
    }



/*
    class FrequencyEntry {
        char c;
        int frequency;

        public FrequencyEntry(char c, int frequency) {
            this.c = c;
            this.frequency = frequency;
        }
    }

    public String frequencySort(String s) {
       *//* PriorityQueue<FrequencyEntry> p = new PriorityQueue<FrequencyEntry>(new Comparator<FrequencyEntry>() {
            @Override
            public int compare(FrequencyEntry o1, FrequencyEntry o2) {
                return o1.frequency - o2.frequency;
            }
        });*//*
        Heap heap = new Heap(s.length());
        for (char c : s.toCharArray()) {
            heap.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while (heap.actualSize > 0) {
            FrequencyEntry entry = heap.pop();
            while (entry.frequency > 0) {
                sb.append(entry.c);
                entry.frequency--;

            }
        }
        return sb.toString();
    }

    class Heap {
        FrequencyEntry[] cache;
        final int size;
        int actualSize;
        Map<Character, Integer> charAndPositionMap = new HashMap();

        public Heap(int size) {
            this.size = size;
            cache = new FrequencyEntry[size];
        }

        public FrequencyEntry pop() {
            FrequencyEntry res = cache[0];
            cache[0] = cache[actualSize - 1];
            actualSize--;
            shiftDown(0);
            return res;
        }

        public void add(char c) {
            Integer position = charAndPositionMap.get(c);
            if (position == null) {
                cache[actualSize] = new FrequencyEntry(c, 1);
                charAndPositionMap.put(c, actualSize);
                actualSize++;
                shiftUp(actualSize - 1);
            } else {
                cache[position].frequency += 1;
                shiftUp(position);
            }
        }

        public void shiftDown(int position) {
            int left = position * 2 + 1;
            int right = position * 2 + 2;
            int max = position;
            if (left < actualSize && cache[max].frequency < cache[left].frequency) {
                max = left;
            }
            if (right < actualSize && cache[max].frequency < cache[right].frequency) {
                max = right;
            }
            if (max != position) {
                FrequencyEntry aux = cache[max];
                cache[max] = cache[position];
                cache[position] = aux;
                charAndPositionMap.put(cache[max].c, max);
                charAndPositionMap.put(cache[position].c, position);
                shiftDown(max);
            }
        }

        public void shiftUp(int position) {
            if (position == 0) {
                return;
            }
            int parent = (position - 1) / 2;
            int left = parent * 2 + 1;
            int right = parent * 2 + 2;
            int max = parent;
            if (left < actualSize && cache[max].frequency < cache[left].frequency) {
                max = left;
            }
            if (right < actualSize && cache[max].frequency < cache[right].frequency) {
                max = right;
            }
            if (max != parent) {
                FrequencyEntry aux = cache[max];
                cache[max] = cache[parent];
                cache[parent] = aux;
                charAndPositionMap.put(cache[max].c, max);
                charAndPositionMap.put(cache[parent].c, parent);
                shiftUp(parent);
            }
        }


    }*/
}
