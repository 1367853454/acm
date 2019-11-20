package com.company.IO;

import java.io.File;
import java.io.IOException;

public class PathDemo1 {

    public static void main(String[] args) throws IOException {

        String path = "D:\\idea_WorkSpace\\acm\\src\\com\\company\\滴滴出行行程报销单.pdf";
        System.out.println(File.separator);

        //构建一个File对象
        File src = new File(path);
        System.out.println("文件长度:" + src.length());

        System.out.println("名称:" + src.getName());
        System.out.println("路径:" + src.getPath());
        System.out.println("绝对路径:" + src.getAbsolutePath());
        System.out.println("父路径:" + src.getParent());
        System.out.println("父对象:" + src.getParentFile().getName());

        System.out.println("-------------------------------------------)");
        System.out.println("是否存在:" + src.exists());
        System.out.println("是否是文件:" + src.isFile());
        System.out.println("是否是文件夹d:" + src.isDirectory());

        src = new File("D:\\idea_WorkSpace\\acm\\src\\com\\company\\demo.txt");
        if (!src.exists()){
            Boolean flag = src.createNewFile();
            System.out.println("创建成功:" + flag);
        }
        if (src.exists()){
            Boolean flag = src.delete();
            System.out.println("删除成功:" + flag);
        }
        /*src.mkdir(); //不存在父目录创建失败
        src.mkdirs(); //不存在父目录也能创建成功 */

        src = new File("D:\\idea_WorkSpace\\acm");
        //下级名称
        String[] subNames = src.list();
        for (String s : subNames){
            System.out.println(s);
        }
        System.out.println("--------------------------------------------");
        //下级对象
        File[] subFiles = src.listFiles();
        for (File f : subFiles){
            System.out.println(f.getAbsolutePath());
        }
    }

}
