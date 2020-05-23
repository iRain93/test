package io;

import java.io.File;
import java.io.IOException;

/**
 * 用一句话描述次类
 *
 * @author lu
 * @version 1.0
 */
public class FileTest {
    public static void main(String[] args) throws Exception {

        File file = new File("D:\\test\\EBP_PDT\\src\\com\\ebills\\product\\commons\\dao\\SearchCSDao.java");
        if(file.exists() && !file.isDirectory())//是文件且不是文件夹
        {
            System.out.println("文件存在");
        }else{
            if(file.isDirectory()){
                System.out.println("这是个文件夹");
            }else{
                System.out.println("文件或者文件夹不存在");
                createFile(file);
            }
        }

    }

    private static void createFile(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            if (parentFile.isFile()) {
                parentFile.delete();
                parentFile.mkdirs();
            }
        } else {
            parentFile.mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
