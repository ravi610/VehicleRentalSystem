package com.lld.vehiclerental.utils;

public class CommonUtils {

    private CommonUtils() {
    }

    public static String generateUuid(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < length; i++) {
            char c = characters.charAt((int) (characters.length() * Math.random()));
            sb.append(c);
        }

        return sb.toString();
    }
}
