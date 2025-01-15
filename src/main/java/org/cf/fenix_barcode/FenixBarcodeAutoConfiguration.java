package org.cf.fenix_barcode;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(FenixBarcodeProperties.class)
public class FenixBarcodeAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public FenixBarcodeService fenixBarcodeService(FenixBarcodeHelper helper) {
        return new FenixBarcodeService(helper);
    }

    @Bean
    @ConditionalOnMissingBean
    public FenixBarcodeHelper fenixBarcodeHelper(FenixBarcodeProperties properties) {
        return new FenixBarcodeHelper(properties);
    }
}
