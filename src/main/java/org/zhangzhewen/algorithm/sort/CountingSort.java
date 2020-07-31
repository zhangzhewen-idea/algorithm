package org.zhangzhewen.algorithm.sort;

public class CountingSort extends Sortable {

    public static int[] countingSort(int[] arr) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //找出数组中的最大最小值
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        int[] help = new int[max - min + 1];

        //找出每个数字出现的次数
        for(int i = 0; i < arr.length; i++){
            int mapPos = arr[i] - min;
            help[mapPos]++;
        }

        //计算每个数字应该在排序后数组中应该处于的位置
        for(int i = 1; i < help.length; i++){
            help[i] = help[i-1] + help[i];
        }

        //根据help数组进行排序
        int res[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            int post = --help[arr[i] - min];
            res[post] = arr[i];
        }

        return res;
    }

    public static int[] countingSort2(int[] arr){
        int bias,min = arr[0],max=arr[0];
        for(int i = 1 ; i < arr.length;i++){
            if(min>arr[i]){
                min = arr[i];
            }
            if(max<arr[i]){
                max = arr[i];
            }
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        for(int i = 0 ; i < arr.length ; i ++){
            bucket[arr[i]+bias]++;
        }
        int index = 0,i = 0;
        while(index < arr.length){
            if(bucket[i]>0){
                arr[index++]=i-bias;
                bucket[i]--;
            }else {
                i++;
            }
        }

        return arr;
    }

    @Override
    public int[] sort(int[] a) {





        return a;
    }


































    public static void main(String[] args) {
        new CountingSort().print();
    }


}


//针对c数组的大小，优化过的计数排序
class CountSort{
    public static void main(String []args){
        //排序的数组
        int a[] = {100, 93, 97, 92, 96, 99, 92, 89, 93, 97, 90, 94, 92, 95};
        int b[] = countSort(a);
        for(int i : b){
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    static int[] countSort2(int[] a){

        return null;
    }























    public static int[] countSort(int []a){
        int b[] = new int[a.length];
        int max = a[0], min = a[0];
        for(int i : a){
            if(i > max){
                max = i;
            }
            if(i < min){
                min = i;
            }
        }
        //这里k的大小是要排序的数组中，元素大小的极值差+1
        int k = max - min + 1;
        int c[] = new int[k];
        for(int i = 0; i < a.length; ++i){
            c[a[i]-min] += 1;//优化过的地方，减小了数组c的大小
        }
        for(int i = 1; i < c.length; ++i){
            c[i] = c[i] + c[i-1];
        }
        for(int i = a.length-1; i >= 0; --i){
            b[--c[a[i]-min]] = a[i];//按存取的方式取出c的元素
        }
        return b;
    }
}