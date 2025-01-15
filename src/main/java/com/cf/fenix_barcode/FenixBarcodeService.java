package com.cf.fenix_barcode;

import com.google.zxing.BarcodeFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FenixBarcodeService {

    private final FenixBarcodeHelper helper;

    /**
     * CODE_128: A high-density 1D barcode format that supports all ASCII characters (0-127).
     * Commonly used in logistics, distribution, and tracking systems.
     * Example text: "ABC123456789"
     *
     * @param text      The text to encode into the barcode (alphanumeric, ASCII).
     * @param baseName  The base name of the output file.
     * @param width     The width of the barcode image in pixels.
     * @param height    The height of the barcode image in pixels.
     */
    public void barcodeImg128(String text, String baseName, int width, int height) {
        helper.generateBarcodeImage(text, BarcodeFormat.CODE_128, baseName, width, height);
    }

    public byte[] barcodeBytes128(String text, int width, int height) {
        return helper.generateBarcodeBytes(text, BarcodeFormat.CODE_128, width, height);
    }

    /**
     * AZTEC: A 2D barcode format used for encoding small amounts of data (up to ~3,000 characters).
     * Suitable for embedding text, URLs, or identifiers.
     * Example text: "https://example.com/aztec"
     *
     * @param text      The text to encode into the barcode.
     * @param baseName  The base name of the output file.
     * @param width     The width of the barcode image in pixels.
     * @param height    The height of the barcode image in pixels.
     */
    public void barcodeImgAztec(String text, String baseName, int width, int height) {
        helper.generateBarcodeImage(text, BarcodeFormat.AZTEC, baseName, width, height);
    }

    public byte[] barcodeBytesAztec(String text, int width, int height) {
        return helper.generateBarcodeBytes(text, BarcodeFormat.AZTEC, width, height);
    }

    /**
     * QR_CODE: A 2D barcode format capable of encoding larger data volumes.
     * Widely used for URLs, contact information, or other text.
     * Example text: "https://example.com/qr"
     *
     * @param text      The text to encode into the barcode.
     * @param baseName  The base name of the output file.
     * @param width     The width of the barcode image in pixels.
     * @param height    The height of the barcode image in pixels.
     */
    public void barcodeImgQRCode(String text, String baseName, int width, int height) {
        helper.generateBarcodeImage(text, BarcodeFormat.QR_CODE, baseName, width, height);
    }

    public byte[] barcodeBytesQRCode(String text, int width, int height) {
        return helper.generateBarcodeBytes(text, BarcodeFormat.QR_CODE, width, height);
    }

    /**
     * EAN_13: A 1D barcode format used internationally for retail products.
     * Requires a 13-digit numeric string.
     * Example text: "0123456789012"
     *
     * @param text      The 13-digit numeric text to encode into the barcode.
     * @param baseName  The base name of the output file.
     * @param width     The width of the barcode image in pixels.
     * @param height    The height of the barcode image in pixels.
     */
    public void barcodeImgEan13(String text, String baseName, int width, int height) {
        helper.generateBarcodeImage(text, BarcodeFormat.EAN_13, baseName, width, height);
    }

    public byte[] barcodeBytesEan13(String text, int width, int height) {
        return helper.generateBarcodeBytes(text, BarcodeFormat.EAN_13, width, height);
    }

    /**
     * CODE_39: A 1D barcode format that supports alphanumeric characters (0-9, A-Z, and special characters).
     * Often used in inventory and military applications.
     * Example text: "CODE39EXAMPLE"
     *
     * @param text      The text to encode into the barcode.
     * @param baseName  The base name of the output file.
     * @param width     The width of the barcode image in pixels.
     * @param height    The height of the barcode image in pixels.
     */
    public void barcodeImgCode39(String text, String baseName, int width, int height) {
        helper.generateBarcodeImage(text, BarcodeFormat.CODE_39, baseName, width, height);
    }

    public byte[] barcodeBytesCode39(String text, int width, int height) {
        return helper.generateBarcodeBytes(text, BarcodeFormat.CODE_39, width, height);
    }

    /**
     * ITF: A 1D barcode format for numeric data, commonly used in packaging and distribution.
     * Requires an even number of digits.
     * Example text: "12345678"
     *
     * @param text      The numeric text to encode into the barcode (even length).
     * @param baseName  The base name of the output file.
     * @param width     The width of the barcode image in pixels.
     * @param height    The height of the barcode image in pixels.
     */
    public void barcodeImgItf(String text, String baseName, int width, int height) {
        helper.generateBarcodeImage(text, BarcodeFormat.ITF, baseName, width, height);
    }

    public byte[] barcodeBytesItf(String text, int width, int height) {
        return helper.generateBarcodeBytes(text, BarcodeFormat.ITF, width, height);
    }

    /**
     * DATA_MATRIX: A 2D barcode format used for encoding small-to-medium amounts of data.
     * Common in industrial and healthcare applications.
     * Example text: "DATAMATRIX123"
     *
     * @param text      The text to encode into the barcode.
     * @param baseName  The base name of the output file.
     * @param width     The width of the barcode image in pixels.
     * @param height    The height of the barcode image in pixels.
     */
    public void barcodeImgDataMatrix(String text, String baseName, int width, int height) {
        helper.generateBarcodeImage(text, BarcodeFormat.DATA_MATRIX, baseName, width, height);
    }

    public byte[] barcodeBytesDataMatrix(String text, int width, int height) {
        return helper.generateBarcodeBytes(text, BarcodeFormat.DATA_MATRIX, width, height);
    }

    /**
     * PDF_417: A 2D barcode format often used for IDs, shipping, and inventory management.
     * Supports encoding large volumes of data.
     * Example text: "PDF417EXAMPLEDATA"
     *
     * @param text      The text to encode into the barcode.
     * @param baseName  The base name of the output file.
     * @param width     The width of the barcode image in pixels.
     * @param height    The height of the barcode image in pixels.
     */
    public void barcodeImgPdf417(String text, String baseName, int width, int height) {
        helper.generateBarcodeImage(text, BarcodeFormat.PDF_417, baseName, width, height);
    }

    public byte[] barcodeBytesPdf417(String text, int width, int height) {
        return helper.generateBarcodeBytes(text, BarcodeFormat.PDF_417, width, height);
    }
}