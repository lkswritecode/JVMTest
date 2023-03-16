package springbeanTest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 我的bean工厂后处理器
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public MyBeanFactoryPostProcessor(){
        System.out.println(" 我的bean工厂后处理器（MyBeanFactoryPostProcessor）构造方法，实现了BeanFactoryPostProcessor");
    }
    
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("我的bean工厂后处理器 【BeanFactoryPostProcessor接口】调用BeanFactoryPostProcessor接口的postProcessBeanFactory方法");
    }
}
