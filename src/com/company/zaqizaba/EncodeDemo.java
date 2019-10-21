package com.company.zaqizaba;

public class EncodeDemo {
    public static void main(String[] args) throws Exception{
        String s = "慕课ABC";
        //转换成字节序列用的是项目默认编码
        byte [] byte1 = s.getBytes();
        for (byte b : byte1){
            //把字节以16进制显示
            System.out.print(Integer.toHexString(b & 0xff) +  " ");
        }
        System.out.println();
        byte [] byte2 = s.getBytes("utf-8");
        for (byte b : byte2){
            System.out.print(Integer.toHexString(b & 0xff) +  " ");
        }
        System.out.println();
        byte [] byte3 = s.getBytes("gbk");
        for (byte b : byte3){
            System.out.print(Integer.toHexString(b & 0xff) +  " ");
        }
    }
}
