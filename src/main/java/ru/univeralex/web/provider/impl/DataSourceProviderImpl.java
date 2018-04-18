package ru.univeralex.web.provider.impl;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.univeralex.web.provider.api.DataSourceProvider;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author - Alexander Kostarev
 */
public class DataSourceProviderImpl implements DataSourceProvider {
    private DriverManagerDataSource dataSource;

    public DataSourceProviderImpl() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        try (InputStream resourceStream = loader.getResourceAsStream("db.properties")) {
            properties.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.dataSource = new DriverManagerDataSource();
        dataSource.setUrl(properties.getProperty("db.url"));
        dataSource.setUsername(properties.getProperty("db.username"));
        dataSource.setPassword(properties.getProperty("db.password"));
        dataSource.setDriverClassName(properties.getProperty("db.driverClassName"));
    }

    @Override
    public DataSource getDatasource() {
        return dataSource;
    }
}
