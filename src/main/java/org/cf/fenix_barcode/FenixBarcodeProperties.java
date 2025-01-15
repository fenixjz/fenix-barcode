package org.cf.fenix_barcode;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fenix.spring.barcode")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FenixBarcodeProperties {
    private String uploadDir = "";
}
