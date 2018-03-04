package ripper.screensaver;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages= "ripper.screensaver")
public class MyConfig {

    @Bean
    //@Scope(value = BeanDefinition.SCOPE_PROTOTYPE/*, proxyMode = ScopedProxyMode.TARGET_CLASS*/)
    @Scope("periodical")
    public Color color(){
        Random random = new Random();
        return new Color(random.nextInt(255),
                random.nextInt(255),
                random.nextInt(255));
    }

    @Bean
    public ColorFrame frame(){
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();//обращение к бину который color
            }
        };
    }
}
