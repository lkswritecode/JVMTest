package sort;

import java.util.Arrays;

public class SortMain {
    public static void main(String[] args) {
        int [] arr1 = new int []{2,5,6,5,4,6,3,1,8,9,2,4,12,0};
        System.out.println("初始数组:"+Arrays.toString(arr1));
        SortMain.bubbleSort(arr1);
        System.out.println("排序后数组:"+ Arrays.toString(arr1));
        System.out.println("------------------------------------------------");
        int [] arr2 = new int []{2,5,6,5,4,6,3,1,8,9,2,4,12,0};
        System.out.println("初始数组:"+Arrays.toString(arr2));
        SortMain.quickSort(arr2,0,arr2.length-1,0);
        System.out.println("排序后数组:"+ Arrays.toString(arr2));
        System.out.println("------------------------------------------------");
        int [] arr10 = new int []{2,5,6,5,4,6,3,1,8,9,2,4,12,0};
        System.out.println("初始数组:"+Arrays.toString(arr2));
        SortMain.quickSort2(arr10,0,arr2.length-1,0);
        System.out.println("排序后数组:"+ Arrays.toString(arr2));
        System.out.println("------------------------------------------------");
        int [] arr3 = new int []{2,5,6,5,4,6,3,1,8,9,2,4,12,0};
        System.out.println("初始数组:"+Arrays.toString(arr3));
        SortMain.insertSort(arr3);
        System.out.println("排序后数组:"+ Arrays.toString(arr3));
        System.out.println("------------------------------------------------");
        int [] arr4 = new int []{2,5,6,5,4,6,3,1,8,9,2,4,12,0};
        System.out.println("初始数组:"+Arrays.toString(arr4));
        SortMain.shellSort(arr4);
        System.out.println("排序后数组:"+ Arrays.toString(arr4));
        System.out.println("------------------------------------------------");
        int [] arr5 = new int []{2,5,6,5,4,6,3,1,8,9,2,4,12,0};
        System.out.println("初始数组:"+Arrays.toString(arr5));
        SortMain.selectSort(arr5);
        System.out.println("排序后数组:"+ Arrays.toString(arr5));
        System.out.println("------------------------------------------------");
        int [] arr6 = new int []{2,5,6,5,4,6,3,1,8,9,2,4,12,0};
        System.out.println("初始数组:"+Arrays.toString(arr6));
        SortMain.mergeSort(arr6,0,arr6.length-1,0);
        System.out.println("排序后数组:"+ Arrays.toString(arr6));
        System.out.println("------------------------------------------------");
        int [] arr7 = new int []{2,5,6,5,4,22,3,1,8,9,2,4,12,0};
        System.out.println("初始数组:"+Arrays.toString(arr7));
        SortMain.rddixSort(arr7);
        System.out.println("排序后数组:"+ Arrays.toString(arr7));
        System.out.println("------------------------------------------------");
        int [] arr8 = new int []{2,5,6,5,4,22,3,1,8,9,2,4,12,0};
        System.out.println("初始数组:"+Arrays.toString(arr8));
        SortMain.rddixQueueSort(arr8);
        System.out.println("排序后数组:"+ Arrays.toString(arr8));
        System.out.println("------------------------------------------------");
        int [] arr9 = new int []{2,5,6,5,4,22,3,1,8,9,2,4,12,0};
        System.out.println("初始数组:"+Arrays.toString(arr9));
        SortMain.heapSort(arr9);
        System.out.println("排序后数组:"+ Arrays.toString(arr9));
        int a = 10;
        for (int i = 0; i<10;i++){
            for (int k = 10-i; k > 0; k--){
                System.out.print(" ");
            }
            for (int j = 0; i > j;j++){
                if(j>=1){
                    System.out.print(" ");
                }
                if(j==0||j==i-1){
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
        for (int i = 8; i>0;i--){
            for (int k = 0; k < 9-i; k++){
                System.out.print(" ");
            }
            for (int j = i; j>0;j--){
                if(j>=1){
                    System.out.print(" ");
                }
                if(j==i||j==1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }

            }
            System.out.println();
        }

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
            //此循环表示每一轮比较的次数 如数组中有3个数字每轮就要比较2次
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
        //如果开始下标大于等于结束下标就不进行排序
        if(start<end){
            //数组第start个值设置为比较标准
            int startValue = arr[start];;
            //开始位置
            int startIndex = start;
            //结束位置
            int endIndex = end;
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
            //左边
            quickSort(arr,start,startIndex,1);
            //右边
            quickSort(arr,startIndex+1,end,1);
        }
        if(isPrintTime==0){
            //结束时间
            long endTime = System.nanoTime();
            System.out.println("快速排序运行时间:" + (endTime - startTime) + "ns");
        }
    }

    public static void quickSort2(int [] arr,int low,int high,int isPrintTime){
        //开始时间
        long startTime = System.nanoTime();
        if(low<high){
            //中轴元素
            int pivotloc = 0;
            int temp = arr[low];
            //获取中轴元素
            while (low!=high){
                while (low!=high){
                    if(temp>arr[high]){
                        arr[low] = arr[high];
                        low++;
                        break;
                    }
                    high--;
                }
                while (low!=high){
                    if(temp<arr[low]){
                        arr[high] = arr[low];
                        high--;
                        break;
                    }
                    low++;
                }
            }
            //给中轴元素赋值
            pivotloc = low;
            //调整中轴元素位置
            arr[low] = temp;
            //左边子数组
            quickSort2(arr,low,pivotloc-1,1);
            //右边子数组
            quickSort2(arr,pivotloc+1,arr.length-1,1);
        }
        if(isPrintTime==0){
            //结束时间
            long endTime = System.nanoTime();
            System.out.println("快速排序2运行时间:" + (endTime - startTime) + "ns");
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

    //选择排序
    public static void selectSort(int [] arr){
        //开始时间
        long startTime = System.nanoTime();
        //遍历所有的数字
        for (int i = 0; i < arr.length ; i++) {
            int min = i;
            //查找最小的数字
            for (int j = i+1; j < arr.length ; j++) {
                //记录最小数的下标
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            //判断min是否有变化
            if(i!=min){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        //结束时间
        long endTime = System.nanoTime();
        System.out.println("选择排序运行时间:" + (endTime - startTime) + "ns");
    }

    public static void merge(int [] arr,int low,int middle ,int height){
        int [] temp = new int [height-low+1];
        int i = low;
        int j = middle+1;
        int index = 0;

        while (i<=middle&&j<=height){
            //把小的数字放入临时数组
            temp[index++] = arr[i]<=arr[j]?arr[i++]:arr[j++];
        }
        //把剩余的数字放入数组
        while (true){
            if(i <= middle){
                temp[index++] = arr[i++];
            }else if(j <= height){
                    temp[index++] = arr[j++];
            }else if(i>middle&&j>height){
                break;
            }
        }
        for (int k = 0; k < temp.length; k++) {
                arr[k+low] = temp[k];
        }
    }
    /**
     * 归并排序
     * @param arr 排序数组
     * @param low 最低位
     * @param height 最高位
     * @param isPrintTime 是否打印时间 0-打印 1-不打印
     *
     *                    2, 5, 6, 5, 4, 6, 3    1, 8, 9, 2, 4, 12, 0
     *                    1,2,5,6   5,4,6,3   8,9,2,   4,12,0
     *                    1,2 5,5  4,6 3,6     4  8  9 2 12 0
     *                    1,2,5,5  3,4,6,6     4,8,2,9,12,0
     *
     */
    public static void  mergeSort(int [] arr,int low ,int height,int isPrintTime){
        long startTime = 0L;
        if(isPrintTime==0){
            //开始时间
            startTime = System.nanoTime();
        }
        int middle = ((low+height)/2);
        if(low!=height){
            //左边
            mergeSort(arr,low,middle,1);
            //右边
            mergeSort(arr,middle+1,height,1);
            merge(arr,low,middle,height);
        }
        if(isPrintTime == 0){
            //结束时间
            long endTime = System.nanoTime();
            System.out.println("归并排序运行时间:" + (endTime - startTime) + "ns");
        }
    }

    /**
     * 桶/基数排序
     * @param arr
     */
    public static void rddixSort(int [] arr){

        //开始时间
        long startTime = System.nanoTime();

        //数组中最大的数，默认位Integer的最小值
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++ ){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        //数组中最大数字的长度
        int maxLength = (max+"").length();
        //存储临时数组
        int [][] temp = new int[10][arr.length];
        //记录每个余数的数量，比如余数为2 的有2，22这样余数为2的就有2个
        int [] counts = new int[10];
        //桶的个数
        for(int i = 0,n=1;i<maxLength;i++,n*=10){
            //每个桶里的值（除10取余数）
            for (int j = 0; j < arr.length; j++) {
                int ys = arr[j]/n%10;
                //余数只有0-9
                temp[ys][counts[ys]] = arr[j];
                //记录每个余数的数量，比如余数为2 的有2，22这样余数为2的就有2个
                counts[ys]++;
            }
            //用于排序后的数组下标
            int index = 0;
            //取数字
            for (int j = 0; j <counts.length ; j++) {
                if(counts[j]!=0){

                    for (int k = 0; k < counts[j]; k++) {
                        arr[index] = temp[j][k];
                        index++;
                    }

                    counts[j] = 0;
                }
            }
        }
        //结束时间
        long endTime = System.nanoTime();
        System.out.println("基数排序运行时间:" + (endTime - startTime) + "ns");
    }
    /**
     * 桶/基数排序
     * @param arr
     */
    public static void rddixQueueSort(int [] arr){

        //开始时间
        long startTime = System.nanoTime();

        //数组中最大的数，默认位Integer的最小值
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++ ){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        //数组中最大数字的长度
        int maxLength = (max+"").length();
        //存储临时数组
        MyQueue [] temp = new MyQueue[10];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new MyQueue();
        }
        //桶的个数
        for(int i = 0,n=1;i<maxLength;i++,n*=10){
            //每个桶里的值（除10取余数）
            for (int j = 0; j < arr.length; j++) {
                int ys = arr[j]/n%10;
                //放入队列
               temp[ys].add(arr[j]);
            }
            //下标
            int index = 0 ;

            for (int j = 0; j < temp.length; j++) {
                while (!temp[j].isEmpty()){
                    arr[index] = temp[j].poll();
                    index++;
                }
            }
        }
        //结束时间
        long endTime = System.nanoTime();
        System.out.println("基数队列排序运行时间:" + (endTime - startTime) + "ns");
    }

    /**
     * 堆排序
     * @param arr
     */
    public static void  heapSort(int [] arr){
        //开始时间
        long startTime = System.nanoTime();
        //找到最后一个非叶子节点，最后一个节点的父节点
        int start = (arr.length-1)/2;
        //将堆调整为大顶堆
        for (int i = start;i>=0;i--){
            maxHeapSort(arr,arr.length,i);
        }
        //每次调整将最大值放到数组的最后一个
        for (int i = arr.length-1;i>0;i--){
            //将最大的值放到数组最后一个
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //再次将最大的值放入根节点，排除数组中最后的一个值
            maxHeapSort(arr,i,0);
        }
        //结束时间
        long endTime = System.nanoTime();
        System.out.println("堆排序排序运行时间:" + (endTime - startTime) + "ns");
    }

    /**
     * 调整大顶堆
     * @param arr   数组
     * @param size  数组长度
     * @param index 任意树的根节点
     */
    public static void maxHeapSort(int[] arr,int size,int index){
        //左子节点
        int leftNode = 2*index+1;
        //右子节点
        int rightNoed = 2*index+2;

        int max = index;

        if(leftNode < size && arr[leftNode]>arr[max]){
            max = leftNode;
        }
        if (rightNoed < size && arr[rightNoed]>arr[max]){
            max = rightNoed;
        }
        if(max!=index){
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;

            maxHeapSort(arr,size,max);
        }
    }

    /**
     *  小顶堆
     * @param arr
     * @param size
     * @param root
     */
    public void minHeapSort(int [] arr,int size, int root){
        int leftNode = 2*root+1;//左子节点
        int rightNode = 2*root+2;//右子节点
        //默认根节点为最小值
        int min = root;

        if(leftNode<size&&arr[leftNode]<arr[min]){
            min = leftNode;
        }
        if(rightNode<size&& arr[rightNode]<arr[min]){
            min = rightNode;
        }
        if(min!=root){
            int temp = arr[root];
            arr[root] = arr[min];
            arr[min] = temp;
            //继续执行其他子树
            maxHeapSort(arr,size,min);
        }
    }

}