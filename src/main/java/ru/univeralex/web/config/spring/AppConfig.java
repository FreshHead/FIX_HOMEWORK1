package ru.univeralex.web.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.univeralex.web.dao.UserDao;
import ru.univeralex.web.dao.impl.UserDaoJdbcImpl;
import ru.univeralex.web.provider.impl.DataSourceProviderImpl;

import javax.sql.DataSource;

/**
 * @author - Alexander Kostarev
 */
@Configuration
@ComponentScan(basePackages = "ru.univeralex")
public class AppConfig {

    @Bean
    public UserDao userDao() {
        DataSource dataSource = new DataSourceProviderImpl("db.properties").getDatasource();
        return new UserDaoJdbcImpl(dataSource);
    }
}
