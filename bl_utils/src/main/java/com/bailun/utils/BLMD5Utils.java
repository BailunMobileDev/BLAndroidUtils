package com.bailun.utils;

import java.security.MessageDigest;

/**
 * create by ouyangjianfeng on 2019/12/16
 * description:MD5字符串加密
 */
public class BLMD5Utils {

    // 全局数组
    private final static String[] strDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    /**
     * 对字符串md5加密
     *
     * @param str
     * @return
     */
    public static String getMD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            return byteToString(md.digest(str.getBytes()));
        } catch (Exception e) {

        }
        return null;
    }

    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            stringBuffer.append(byteToArrayString(bByte[i]));
        }
        return stringBuffer.toString();
    }

    // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }
}
