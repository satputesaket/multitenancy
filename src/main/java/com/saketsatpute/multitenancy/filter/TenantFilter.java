package com.saketsatpute.multitenancy.filter;

import com.saketsatpute.multitenancy.configs.TenantContext;
import org.springframework.stereotype.Component;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class TenantFilter implements Filter {

    // Demo: simple in-memory map for API keys → tenantId
    private static final Map<String, String> API_KEY_MAP = new HashMap<>();
    static {
        API_KEY_MAP.put("apikey-shop1", "shop1");
        API_KEY_MAP.put("apikey-shop2", "shop2");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String apiKey = httpRequest.getHeader("X-API-KEY");

        if (apiKey != null && API_KEY_MAP.containsKey(apiKey)) {
            String tenantId = API_KEY_MAP.get(apiKey);
            TenantContext.setTenant(tenantId);
        } else {
            TenantContext.setTenant("default"); // fallback
        }

        try {
            chain.doFilter(request, response);
        } finally {
            TenantContext.clear();
        }
    }
}
