package com.saketsatpute.multitenancy.configs;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    private final TenantProperties tenantProperties;

    public DataSourceConfig(TenantProperties tenantProperties) {
        this.tenantProperties = tenantProperties;
    }

    @Bean
    public DataSource dataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>();

        tenantProperties.getShop().forEach((tenantId, config) -> {
            HikariDataSource ds = new HikariDataSource();
            ds.setJdbcUrl(config.getUrl());
            ds.setUsername(config.getUsername());
            ds.setPassword(config.getPassword());
            ds.setDriverClassName(config.getDriverClassName());
            targetDataSources.put(tenantId, ds);
        });

        AbstractRoutingDataSource routingDataSource = new AbstractRoutingDataSource() {
            @Override
            protected Object determineCurrentLookupKey() {
                return TenantContext.getTenant();
            }
        };

        routingDataSource.setTargetDataSources(targetDataSources);
        routingDataSource.setDefaultTargetDataSource(targetDataSources.values().iterator().next());
        routingDataSource.afterPropertiesSet();

        return routingDataSource;
    }
}
