package com.saketsatpute.multitenancy.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "tenant")
public class TenantProperties {

    private Map<String, DataSourceConfig> shop = new HashMap<>();

    public Map<String, DataSourceConfig> getShop() {
        return shop;
    }

    public void setShop(Map<String, DataSourceConfig> shop) {
        this.shop = shop;
    }

    public static class DataSourceConfig {
        private String url;
        private String username;
        private String password;
        private String driverClassName;

        // getters and setters
        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
        public String getDriverClassName() { return driverClassName; }
        public void setDriverClassName(String driverClassName) { this.driverClassName = driverClassName; }
    }
}
