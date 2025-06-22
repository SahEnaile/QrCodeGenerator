package com.sarah.qrcode.generator.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.sarah.qrcode.generator.dto.QrCodeGeneratorResponse;
import com.sarah.qrcode.generator.ports.StoragePorts;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class QrCodeGeneratorService {
    private final StoragePorts storage;

    public QrCodeGeneratorService(StoragePorts storage) {
        this.storage = storage;
    }

    public QrCodeGeneratorResponse generateAndUploadQrCode(String text) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE,200,200);

        ByteArrayOutputStream pngOutPutStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutPutStream);
        byte[] pngQrCodeData = pngOutPutStream.toByteArray();

        String Url = storage.uploadFile(pngQrCodeData, UUID.randomUUID().toString(), "image,png");
        return new QrCodeGeneratorResponse(Url);

    }
}
