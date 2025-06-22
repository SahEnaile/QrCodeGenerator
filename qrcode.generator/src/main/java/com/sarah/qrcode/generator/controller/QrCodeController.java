package com.sarah.qrcode.generator.controller;

import com.sarah.qrcode.generator.dto.QrCodeGenerateRequest;
import com.sarah.qrcode.generator.dto.QrCodeGeneratorResponse;
import com.sarah.qrcode.generator.service.QrCodeGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {
    private final QrCodeGeneratorService qrCodeGeneratorService;

    public QrCodeController(QrCodeGeneratorService qrCodeService) {
        this.qrCodeGeneratorService = qrCodeService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGeneratorResponse> Generate(@RequestBody QrCodeGenerateRequest request){
        try {
            QrCodeGeneratorResponse response = this.qrCodeGeneratorService.generateAndUploadQrCode(request.text());
                    return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }
}
