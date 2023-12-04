package com.example.storage.util;


import java.nio.charset.StandardCharsets;

public class ImageConverter {


    public static byte[] stringToByteArray(String imageData) {
        if (imageData == null) {
            return null;
        }
        return imageData.getBytes(StandardCharsets.UTF_8);
    }
    public static String byteArrayToString(byte[] bytes) {
        if (bytes == null) {
            return "";
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }

}
