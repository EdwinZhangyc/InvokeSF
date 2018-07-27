package com.zyc.demo.commons;

import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/**
 * 加密算法类
 */
public class SFEncryption {

    public static String loadFile(String fileName) {
        InputStream fis;
        try {
            fis = new FileInputStream(fileName);
            byte[] bs = new byte[fis.available()];
            fis.read(bs);
            String res = new String(bs);
            fis.close();
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String md5EncryptAndBase64(String str) {
        return encodeBase64(md5Encrypt(str));
    }

    private static byte[] md5Encrypt(String encryptStr) {
        try {

            //String md5 =  DigestUtils.md5Hex(encryptStr);
            //return md5.getBytes();

            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(encryptStr.getBytes("utf8"));
            return md5.digest();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String encodeBase64(byte[] b) {
        BASE64Encoder base64Encode = new BASE64Encoder();
        String str = base64Encode.encode(b);
        return str;
    }


    public static void main(String[] args) {
        String xml = loadFile("D:\\softWare\\windows\\IT\\主桥\\SF-CSIM-EXPRESS-SDK-V1.3\\callExpressRequest\\1.order.txt");
        String checkword = loadFile("D:\\softWare\\windows\\IT\\主桥\\SF-CSIM-EXPRESS-SDK-V1.3\\callExpressRequest\\aa.txt");
        //String checkword = "XMFJSJ";
        System.out.println(md5EncryptAndBase64(xml + checkword));
        //System.out.println(md5EncryptAndBase64("abc"));
        //System.out.println(md5EncryptAndBase64("中"));
        System.out.println(md5EncryptAndBase64(args[0] + args[1]));
    }
}