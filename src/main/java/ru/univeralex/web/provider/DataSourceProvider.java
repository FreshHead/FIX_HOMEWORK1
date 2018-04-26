package ru.univeralex.web.provider;

import javax.sql.DataSource;

public interface DataSourceProvider {
    DataSource getDatasource();
}
