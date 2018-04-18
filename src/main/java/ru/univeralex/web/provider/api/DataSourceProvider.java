package ru.univeralex.web.provider.api;

import javax.sql.DataSource;

public interface DataSourceProvider {
    DataSource getDatasource();
}
