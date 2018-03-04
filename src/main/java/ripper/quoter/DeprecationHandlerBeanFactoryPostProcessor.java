package ripper.quoter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import ripper.annotations.DeprecatedClass;

public class DeprecationHandlerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("I'AM FROM postProcessBeanFactory");
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String bdn: beanDefinitionNames ){
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(bdn);
            String beanClassName = beanDefinition.getBeanClassName();
            try {
                Class<?> beanClass = Class.forName(beanClassName);
                DeprecatedClass annotation = beanClass.getAnnotation(DeprecatedClass.class);
                if (annotation!=null){
                    beanDefinition.setBeanClassName(annotation.newImple().getName());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
