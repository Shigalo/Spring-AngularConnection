package by.bsuir.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { };
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
