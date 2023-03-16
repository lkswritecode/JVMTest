package JMM;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * @ClassName MyThreadTest02
 * @Author 一个经常熬夜的程序员
 * @CreateDate 2020/6/8 11:19
 * @Version 1.0
 **/
public class MyThreadTest02 {

    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        Random random = new Random();
        robot.delay(1000);
        int a = 500;
        while (true) {

//            robot.keyPress(KeyEvent.VK_ENTER);
            System.out.println(KeyEvent.VK_UP);
            robot.keyPress(KeyEvent.VK_UP);
            robot.keyRelease(KeyEvent.VK_UP);
            robot.delay(a);
//            robot.keyRelease(KeyEvent.VK_ENTER);
        }
    }
}
