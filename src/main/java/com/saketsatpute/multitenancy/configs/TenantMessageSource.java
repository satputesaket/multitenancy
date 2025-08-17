package com.saketsatpute.multitenancy.configs;

import java.util.Locale;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class TenantMessageSource {

    private final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

    public TenantMessageSource() {
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setFallbackToSystemLocale(false);
    }

    public String getMessage(String code, Locale locale) {
        String tenantId = TenantContext.getTenant(); // e.g. "shop1"
        messageSource.setBasename("messages/messages_" + tenantId);
        return messageSource.getMessage(code, null, locale);
    }

}
