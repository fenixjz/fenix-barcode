package com.cf.fenix_barcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@Component
@RequiredArgsConstructor
class FenixBarcodeHelper {

    private final FenixBarcodeProperties properties;

    /**
     * Generates a barcode image file for a given text and barcode format.
     * The directory is automatically taken from FenixBarcodeProperties.
     *
     * @param text      The text to encode into the barcode.
     *                  Example: "123456789" for CODE_128, "https://example.com" for QR_CODE.
     * @param format    The barcode format to use (e.g., CODE_128, QR_CODE, AZTEC, etc.).
     *                  Supported formats include 1D and 2D barcodes.
     * @param baseName  The base name of the file (the method will append a Unix timestamp and ".png").
     *                  Example: "barcode".
     * @param width     The width of the barcode image in pixels.
     *                  Example: 300.
     * @param height    The height of the barcode image in pixels.
     *                  Example: 150.
     */
    void generateBarcodeImage(String text, BarcodeFormat format, String baseName, int width, int height) {
        try {
            MultiFormatWriter barcodeWriter = new MultiFormatWriter();
            BitMatrix bitMatrix = barcodeWriter.encode(text, format, width, height);

            // Directory is taken from properties
            String targetDirectory = properties.getUploadDir();
            if (targetDirectory == null || targetDirectory.isEmpty()) {
                throw new IllegalStateException("Upload directory is not configured in FenixBarcodeProperties.");
            }

            String fileName = generateFileName(baseName);
            Path path = FileSystems.getDefault().getPath(targetDirectory, fileName);

            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
            System.out.println("Barcode saved at: " + path);
        } catch (WriterException e) {
            throw new RuntimeException("Error generating barcode: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error: " + e.getMessage());
        }
    }

    /**
     * Generates a barcode as a byte array for a given text and barcode format.
     * This method can be used when the barcode needs to be displayed in-memory
     * or sent as a response to a client (e.g., in a web application).
     *
     * @param text   The text to encode into the barcode.
     *               Example: "123456789" for CODE_128, "https://example.com" for QR_CODE.
     * @param format The barcode format to use (e.g., CODE_128, QR_CODE, AZTEC, etc.).
     *               Supported formats include 1D and 2D barcodes.
     * @param width  The width of the barcode image in pixels.
     *               Example: 300.
     * @param height The height of the barcode image in pixels.
     *               Example: 150.
     * @return A byte array representing the barcode image in PNG format.
     */
    byte[] generateBarcodeBytes(String text, BarcodeFormat format, int width, int height) {
        try {
            MultiFormatWriter barcodeWriter = new MultiFormatWriter();
            BitMatrix bitMatrix = barcodeWriter.encode(text, format, width, height);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (WriterException e) {
            throw new RuntimeException("Error generating barcode: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error: " + e.getMessage());
        }
    }

    /**
     * Generates a unique file name for a barcode image based on the provided base name
     * and the current Unix timestamp. This ensures that each generated file has a unique name.
     *
     * @param baseName The base name of the file.
     *                 Example: "barcode".
     * @return A string representing the generated file name in the format: "baseName_unixTimestamp.png".
     *         Example: "barcode_1700000000.png".
     */
    String generateFileName(String baseName) {
        long unixTimestamp = System.currentTimeMillis() / 1000L; // Unix timestamp in seconds
        return baseName + "_" + unixTimestamp + ".png";
    }
}