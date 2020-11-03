package arithmetic;

import java.util.*;

/**
 * Create with Darcula IDEA
 * Description: 桶排序
 * @Author CJP
 * @Date 2020/11/1
 * @Time 21:22
 */
public class BucketSort {
    public static void main(String[] args) {
        double[] array = new double[]{4.12,6.421,0.04,3.45,4.89,10.08};
        System.out.println(Arrays.toString(bucketSort(array)));
    }
    public static double[] bucketSort(double[] array) {
        //1.得到数组最大、最小值与差值d
        double max = array[0];
        double min = array[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
            if(array[i] < min) {
                min = array[i];
            }
        }
        double d = max - min;
        //2.初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<LinkedList<Double>>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketList.add(new LinkedList<Double>());
        }
        //3.遍历原始数组，将每个元素放入桶里
        for(int i = 0; i < array.length; i++) {
            int num = (int)((array[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(array[i]);
        }
        //4.对每个桶内部进行排序
        for(int i = 0; i < bucketNum; i++) {
            Collections.sort(bucketList.get(i));
        }
        //5.输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for(LinkedList<Double> list : bucketList) {
            for(double e : list) {
                sortedArray[index] = e;
                index++;
            }
        }
        return sortedArray;
    }
}
