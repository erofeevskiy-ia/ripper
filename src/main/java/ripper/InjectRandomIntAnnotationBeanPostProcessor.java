package ripper;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.util.ReflectionUtils;
import ripper.annotations.InjectRandomInt;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    private Field[] declaredFields;

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        declaredFields = bean.getClass().getDeclaredFields();
        for (Field f : declaredFields) {
            InjectRandomInt annotation = f.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                int i = min + random.nextInt(max - min);
                f.setAccessible(true);
                ReflectionUtils.setField(f, bean, i);
            }
        }
        System.out.println("from postProcessBefore INJECT_RANDOM:"+bean);

        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("from postProcessAfterInitialisation INJECT_RANDOM:"+bean);

        return bean;
    }
}
