package springbeanTest;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * 我的实例化感知Bean后处理器
 *
 * 一般情况下，当我们需要实现InstantiationAwareBeanPostProcessor接口时，是通过继承Spring框架中InstantiationAwareBeanPostProcessor接口实现类
 * InstantiationAwareBeanPostProcessorAdapter这个适配器类来简化我们实现接口的工作
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    public MyInstantiationAwareBeanPostProcessor(){
        System.out.println("我的实例化感知Bean后处理器(MyInstantiationAwareBeanPostProcessor)构造方法，继承了InstantiationAwareBeanPostProcessorAdapter");
    }
    /**
     * 实例化Bean之前调用
     */
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
        System.out.println("我的实例化感知Bean后处理器【InstantiationAwareBeanPostProcessor接口】调用InstantiationAwareBeanPostProcessor接口的postProcessBeforeInstantiation方法");
        return null;
    }

    /**
     * 实例化Bean之后调用
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("我的实例化感知Bean后处理器【InstantiationAwareBeanPostProcessor接口】调用InstantiationAwareBeanPostProcessor接口的postProcessAfterInitialization方法");
        return bean;
    }

    /**
     * 设置某个属性时调用
     */
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
            throws BeansException {
        System.out.println("我的实例化感知Bean后处理器【InstantiationAwareBeanPostProcessor接口】调用InstantiationAwareBeanPostProcessor接口的postProcessPropertyValues方法");
        return pvs;
    }
}
