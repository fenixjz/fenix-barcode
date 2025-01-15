# Fenix Barcode Library Documentation

## Overview

The **Fenix Barcode Library** is a Spring Boot library designed for generating various types of barcodes, both 1D and 2D, and integrating seamlessly into other Spring Boot applications. It supports saving barcodes as images or retrieving them as byte arrays.

---

## Installation

To include this library in your Spring Boot project as a dependency using **JitPack**, follow these steps:

### 1. Add the JitPack repository

Add the JitPack repository to your `pom.xml`:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

### 2. Add the dependency

Add the dependency for the Fenix Barcode Library:

```xml
<dependency>
    <groupId>com.github.fenixjz</groupId>
    <artifactId>fenix-barcode</artifactId>
    <version>1.0.0</version>
</dependency>
```

Replace `<your-github-username>` with your GitHub username.

---

## Configuration

### Properties Configuration

To configure the upload directory for barcode images, add the following property in your `application.properties` or `application.yml`:

```properties
fenix.spring.barcode.upload-dir=C:/barcodes
```

This specifies the directory where barcode images will be saved. Ensure the directory exists and is writable by the application.

---

## Usage

The library exposes the `FenixBarcodeService` class, which provides public methods to generate barcodes as images or byte arrays. Below are the supported barcode formats and how to use the library.

### Supported Barcode Formats

| Format      | Description                                                                                   | Example Input                                           |
|-------------|-----------------------------------------------------------------------------------------------|--------------------------------------------------------|
| CODE_128    | High-density 1D barcode for ASCII characters. Commonly used in logistics and tracking systems.| Alphanumeric, all ASCII characters (0-127).           |
| CODE_39     | 1D barcode for alphanumeric characters. Often used in inventory and military applications.    | Uppercase letters (A-Z), digits (0-9), and symbols (-, ., $, /, +, %, and space). |
| ITF         | 1D barcode for numeric data. Commonly used in packaging and distribution.                     | Numeric only (must have an even number of digits).     |
| EAN_13      | 1D barcode for retail products. Requires a 13-digit numeric string.                           | Exactly 13 numeric digits.                             |
| QR_CODE     | 2D barcode for URLs, contact information, or larger data volumes.                             | Alphanumeric, URLs, binary data, and special characters.|
| AZTEC       | 2D barcode for compact data storage. Suitable for embedding text or URLs.                     | Alphanumeric, binary data, special characters.         |
| DATA_MATRIX | 2D barcode for small-to-medium data amounts. Common in industrial and healthcare applications.| Alphanumeric, binary data, special characters.         |
| PDF_417     | 2D barcode for encoding large volumes of data. Often used for IDs and shipping.               | Alphanumeric, binary data, special characters.         |

---

## Examples

### 1. Generating a Barcode Image File

```java
import org.cf.fenix_barcode.FenixBarcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BarcodeExample {

    @Autowired
    private FenixBarcodeService barcodeService;

    public String generateBarcodeImage() {
        barcodeService.barcodeImg128(
                "ABC123456789",      // Text to encode
                "barcode128",        // Base name for the file
                300,                  // Width of the barcode image
                150                   // Height of the barcode image
        );
    }
}
```

This will generate a barcode in the directory specified by the `fenix.spring.barcode.upload-dir` property, with a file name like `barcode128_<timestamp>.png`.

### 2. Generating a Barcode as a Byte Array

```java
import org.cf.fenix_barcode.FenixBarcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BarcodeExample {

    @Autowired
    private FenixBarcodeService barcodeService;

    public void generateBarcodeBytes() {
        byte[] barcodeBytes = barcodeService.barcodeBytesQRCode(
                "https://example.com", // Text to encode
                300,                    // Width of the barcode image
                300                     // Height of the barcode image
        );
        // Use barcodeBytes (e.g., send as a response in a web application)
    }
}
```

---

## Notes

- Ensure the `upload-dir` property is properly configured and the application has write permissions for the specified directory.
- Handle exceptions appropriately when calling the service methods to deal with invalid inputs or system errors.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

