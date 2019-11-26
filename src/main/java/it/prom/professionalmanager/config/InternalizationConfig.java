package it.prom.professionalmanager.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Конфиг для локализации
 * @author konovalovps97 created on 03.10.2019.
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class InternalizationConfig {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasenames("messages");
        return resourceBundleMessageSource;
    }
}