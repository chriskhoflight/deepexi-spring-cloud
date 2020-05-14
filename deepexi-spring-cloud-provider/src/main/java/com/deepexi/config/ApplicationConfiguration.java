package com.deepexi.config;

import com.deepexi.util.ConverterUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;

@Configuration
public class ApplicationConfiguration implements InitializingBean {
    @Autowired
    private ConversionService conversionService;
    
    @Bean
    public ApplicationMetaObjectHandler.RuntimeData runtimeData() {
        return new ApplicationMetaObjectHandler.RuntimeData() {
            @Override
            public String getUserId() {
                return "1";
            }

            @Override
            public String getTenantId() {
                return "1";
            }
        };
    }


    @Override
    public void afterPropertiesSet() {
        ConverterUtils.setConversionService(conversionService);
    }
}
