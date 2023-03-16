package springbeanTest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 我的Bean后置处理器
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    public MyBeanPostProcessor(){
        System.out.println("我的Bean后置处理器(MyBeanPostProcessor)构造方法调用，本类继承了BeanPostProcessor");
    }

    /**
     * 我的Bean后置处理器
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("我的Bean后置处理器【BeanPostProcessor接口】调用postProcessBeforeInitialization方法，这里可对"+beanName+"的属性进行更改。");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("我的Bean后置处理器【BeanPostProcessor接口】调用postProcessAfterInitialization方法，这里可对"+beanName+"的属性进行更改。");
        return bean;
    }
}
