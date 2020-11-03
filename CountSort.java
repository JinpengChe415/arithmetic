package arithmetic;

import java.util.Arrays;

/**
 * Create with Darcula IDEA
 * Description: 计数排序
 * @Author CJP
 * @Date 2020/11/1
 * @Time 17:23
 */
public class CountSort {
    public static void main(String[] args) {
        int[] array = new int[]{94,92,94,93,97,99,95,96};
        System.out.println(Arrays.toString(countSort(array)));
    }
    //优化算法
    public static int[] countSort(int[] array) {
        //获取最大、最小值与差值
        int max = array[0];
        int min = array[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
            if(array[i] < min) {
                min = array[i];
            }
        }
        int d = max - min;
        //创建统计数组并统计元素个数
        int[] countArray = new int[d + 1];
        for(int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }
        //统计数组做变形
        for(int i = 1; i < countArray.length; i++) {
            countArray[i] = countArray[i] + countArray[i - 1];
        }
        //倒序遍历原始数组，从统计数组中找出正确位置，输出结果数组
        int[] sortedArray = new int[array.length];
        for(int i = array.length - 1; i >= 0; i--) {
            sortedArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }
        return sortedArray;
    }

    //常规算法（会浪费前面的空间）
    public static int[] countSort0(int[] array) {
        //获取最大值
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] > max) {
                max = array[i];
            }
        }
        //用最大值确定统计数组的长度
        int[] countArray = new int[max + 1];
        //遍历数组，填充统计数组
        for(int i = 0; i < array.length; i++){
            countArray[array[i]]++;
        }
        //遍历统计数组，输出结果
        int index = 0;
        int[] sortedArray = new int[array.length];
        for(int i = 0; i < countArray.length; i++){
            for(int j = 0; j < countArray[i]; j++){
                sortedArray[index ++] = i;
            }
        }
        return sortedArray;
    }
}
