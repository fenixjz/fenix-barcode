package com.fenix.fenix_barcode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FenixBarcodeAutoConfiguration {

    @Bean
    public FenixBarcodeService fenixBarcodeService(FenixBarcodeHelper helper) {
        return new FenixBarcodeService(helper);
    }

    @Bean
    public FenixBarcodeHelper fenixBarcodeHelper(FenixBarcodeProperties properties) {
        return new FenixBarcodeHelper(properties);
    }
}
