package ru.univeralex.web.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.univeralex.web.provider.api.DataSourceProvider;
import ru.univeralex.web.provider.impl.DataSourceProviderImpl;

/**
 * @author - Alexander Kostarev
 */
@Configuration
@ComponentScan(basePackages = "ru.univeralex")
public class AppConfig {
    @Bean
    public DataSourceProvider dataSourceProvider() {
        return new DataSourceProviderImpl("db.properties");
    }
}
