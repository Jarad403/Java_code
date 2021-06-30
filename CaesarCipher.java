package com.shun.caesarcipher;

public class CaesarCipher {

    public CaesarCipher() {
    }

    public String codeCipher(String text) {
        long currentTime = System.currentTimeMillis();
        char[] result = new char[text.length()];
        int sign = 0;
        for (char c : text.toCharArray()) {
            result[sign] = (char) ((int) c + text.length());
            sign++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("codeCipher(" + currentTime + ":" + endTime + ")");
        System.out.println("程序运行的时间为：" + (endTime - currentTime) + "毫秒");
        return String.valueOf(result);
    }

    public String decodeCipher(String text) {
        long currentTime = System.currentTimeMillis();
        char[] result = new char[text.length()];
        int sign = 0;
        for (char c : text.toCharArray()) {
            result[sign] = (char) ((int) c - text.length());
            sign++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("codeCipher(" + currentTime + ":" + endTime + ")");
        System.out.println("程序运行的时间为：" + (endTime - currentTime) + "毫秒");
        return String.valueOf(result);
    }
}
