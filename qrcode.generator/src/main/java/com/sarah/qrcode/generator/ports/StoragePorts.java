package com.sarah.qrcode.generator.ports;

public interface StoragePorts {
    String uploadFile(byte[] fileData, String fileName, String contentType);
}
