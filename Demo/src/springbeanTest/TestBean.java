package springbeanTest;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class TestBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware {
    private static final int attribute_0 = 1;
    private BeanFactory beanFactory;
    private  String beanName;
    @Override
    public void setBeanName(String s) {
        this.beanName = s;
        System.out.println("【BeanNameAware接口】调用BeanNameAware的setBeanName方法得到Bean的名称");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】调用InitializingBean接口的afterPropertiesSet方法");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware的setBeanFactory方法得到beanFactory引用");
    }

    static class TestBean_internal{
        public  TestBean_internal(){
            System.out.println("【TestBean_internal】我是内部类构造方法代码块");
        }
        public void init(){
            System.out.println("【init】我是内部类初始化代码块");
        }
        {
            System.out.println("【】我是内部类普通代码块");
        }
        static {
            System.out.println("【static】我是内部类静态代码块");
        }
    }
    public  TestBean(){
        System.out.println("【TestBean】我是构造方法代码块");
    }
    public void destroy(){
        System.out.println("【destroy】我是销毁方法");
    }
    public void init(){
        System.out.println("【init】我是初始化代码块");
    }
    {
        System.out.println("【】我是普通代码块");
    }
    static {
        System.out.println("【static】我是静态代码块");
    }
}
