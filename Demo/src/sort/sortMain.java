package sort;

import java.util.Arrays;

public class sortMain {
    public static void main(String[] args) {
        int [] arr1 = new int []{2,5,6,5,4,6,3,1,8,9,2,4,12};
        System.out.println("初始数组:"+Arrays.toString(arr1));
        bubbleSort(arr1);
        System.out.println("排序后数组:"+ Arrays.toString(arr1));
        System.out.println("------------------------------------------------");
        int [] arr2 = new int []{2,7,6,5,4,2,3,1,0,9,2,4,10};
        System.out.println("初始数组:"+Arrays.toString(arr2));
        quickSort(arr2,0,arr2.length-1,0);
        System.out.println("排序后数组:"+ Arrays.toString(arr2));
        System.out.println("------------------------------------------------");
        int [] arr3 = new int []{2,8,6,7,4,0,3,1,2,4,5,4,10};
        System.out.println("初始数组:"+Arrays.toString(arr3));
        insertSort(arr3);
        System.out.println("排序后数组:"+ Arrays.toString(arr3));
        System.out.println("------------------------------------------------");
        int [] arr4 = new int []{2,5,7,3,4,0,3,1,5,8,4,10,9};
        System.out.println("初始数组:"+Arrays.toString(arr4));
        shellSort(arr4);
        System.out.println("排序后数组:"+ Arrays.toString(arr4));

    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static  void bubbleSort(int [] arr){
        //开始时间
        long startTime = System.nanoTime();
        //此循环表示比较多少轮 如数组中有3个数字就要比较3轮
        for (int i = 0; i<arr.length-1;i++){
            //此循环表示没一轮比较的次数 如数组中有3个数字每轮就要比较2次
            for (int j = 0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        //结束时间
        long endTime = System.nanoTime();
        System.out.println("冒泡排序运行时间:" + (endTime - startTime) + "ns");
    }

    /**
     * 快速排序
     * @param arr
     * @param start 开始位置 一般为0
     * @param end   结束位置 数组的length-1
     * @param isPrintTime 是否打印执行时间 0打印 1不打印
     */
    public static void quickSort(int [] arr,int start,int end,int isPrintTime){
        //开始时间
        long startTime = System.nanoTime();
        //数组第start个值设置为比较标准
        int startValue = arr[start];
        //记录需要排序的下标
        int startIndex = start;
        int endIndex = end;
        //如果开始下标大于等于结束下标就不进行排序
        if(start<end){
            //循环整个数组
            while (startIndex<endIndex){
                //数组下标移动 如果数组第endIndex的值大于标准值则end下标-1 一直移动到标准值大于数组第endIndex个值结束循环
                while (startIndex<endIndex&&startValue<=arr[endIndex]){
                    endIndex--;
                }
                //结束循环后使用右边的数字替换左边的数字
                arr[startIndex] = arr[endIndex];
                //数组下标移动 如果数组第startIndex的值大于标准值则start下标+1 一直移动到标准值小于数组第startIndex个值结束循环
                while (startIndex<endIndex&&startValue>=arr[startIndex]){
                    startIndex++;
                }
                //结束循环后使用左边的数字替换右边的数字
                arr[endIndex] = arr[startIndex];
            }
            arr[startIndex] = startValue;
            quickSort(arr,start,startIndex,1);
            quickSort(arr,startIndex+1,end,1);
        }
        //结束时间
        long endTime = System.nanoTime();
        if(isPrintTime==0){
            System.out.println("快速排序运行时间:" + (endTime - startTime) + "ns");
        }
    }
    /**
     * 插入排序排序
     */
    public static void insertSort(int [] arr){
        //开始时间
        long startTime = System.nanoTime();
        //遍历数组从1开始  把数组第1个数值前面的当作已经排好序的
        for (int i = 1;i<arr.length;i++){
            //如果当前值小于他之前的的值
            if(arr[i]<arr[i-1]){
                //以当前这个值为标准值
                int temp = arr[i];
                int j ;
                //继续比较前面的值
                for (j = i-1;j>=0;j--){
                    //如果当前值小于他的前一个值那么就将他前一个值的下标+1
                    if(temp<arr[j]){
                        arr[j+1]=arr[j];
                    }else {
                        break;
                    }

                }
                //已经没有比标准值更小的值了就把标准值放在j+1的位置
                arr[j+1]=temp;
            }
        }
        //结束时间
        long endTime = System.nanoTime();
        System.out.println("插入排序运行时间:" + (endTime - startTime) + "ns");
    }
    /**
     * 希尔排序排序
     */
    public static void shellSort(int [] arr){
        //开始时间
        long startTime = System.nanoTime();
        //将数组按分组
        for (int s = arr.length/2;s>0;s/=2){
            //遍历每一组的值
            for (int i = s;i<arr.length;i++){
                //比较每一组的值
                for (int j = i-s; j >=0 ; j-=s) {
                    //如果前一个值比后一个值大就交换位置
                    if(arr[j]>arr[j+s]){
                        int temp = arr[j];
                        arr[j] = arr[j+s];
                        arr[j+s] = temp;
                    }
                }
            }
        }
        //结束时间
        long endTime = System.nanoTime();
        System.out.println("希尔排序运行时间:" + (endTime - startTime) + "ns");
    }

}