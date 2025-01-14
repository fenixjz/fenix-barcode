package com.fenix.fenix_barcode;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "fenix.spring.barcode")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FenixBarcodeProperties {
    private String uploadDir = "";
}
