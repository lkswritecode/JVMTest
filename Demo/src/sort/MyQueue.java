package sort;

/**
 * 队列
 */
public class MyQueue {

    int [] elements;

    public MyQueue(){
        elements = new int[0];
    }
    //入队
   public void add(int element){
        //创建个新数组
        int [] newArr = new int[elements.length+1];
        //把原来的值赋给新数组
       for (int i = 0; i < elements.length ; i++) {
           newArr[i] = elements[i];
       }
       newArr[elements.length] = element;
       this.elements = newArr;
   }
    //出队
   public int poll(){
        int element = elements[0];

        int [] newArr = new int[elements.length-1];

       for (int i = 0; i < newArr.length; i++) {
           newArr[i] = elements[i+1];
       }
       elements = newArr;
       return element;
   }
    //队列是否为空
    public boolean isEmpty() {
        return elements.length==0;
    }
}
