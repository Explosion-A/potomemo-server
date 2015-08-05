/**
 * @(#)Jodo, 2014年2月14日
 */
package com.irady.potomemo.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author treemanz
 */
public class MD5Util {
    
    private static MessageDigest getMessageDigest() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * 獲取字符串的MD5碼
     * 
     * @param plainText
     * @return MD5的16進制字符串表示
     */
    public static String getMD5String(String plainText) {
        MessageDigest messageDigest = getMessageDigest();
        messageDigest.update(plainText.getBytes());
        byte bytes[] = messageDigest.digest();
        String str = toHexString(bytes);
        return str;
    }

    /**
     * @param args
     */
    private static char[] hexChar = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
        'e', 'f'
    };

    /**
     * @param bytes
     * @return
     */
    private static String toHexString(byte[] bytes) {
        // long time1 = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            sb.append(hexChar[(bytes[i] & 0xf0) >>> 4]);
            sb.append(hexChar[bytes[i] & 0x0f]);
        }

        // long time2 = System.currentTimeMillis();
        // System.out.println("bite:" + (time2 - time1));

        return sb.toString();
    }

    public static void main(String[] args) {
    	
    	
    	System.out.println("mypassword:"+getMD5String("Ezzo33" + "19881202" + "V#!~~").substring(2, 30));
	}
}
