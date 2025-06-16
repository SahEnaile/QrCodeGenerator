package com.sarah.qrcode.generator.controller;

import com.sarah.qrcode.generator.dto.QrCodeGenerateRequest;
import com.sarah.qrcode.generator.dto.QrCodeGeneratorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {
    @PostMapping
    public ResponseEntity<QrCodeGeneratorResponse> Generate(@RequestBody QrCodeGenerateRequest request){
    return null;
    }
}
