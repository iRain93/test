package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件复制
 * @author lu
 * @version 1.0
 */
public class FileCopy {
    public static void main(String[] args) throws Exception {
        String basePath = "D:\\feiq\\Recv Files\\2天津银行国结系统-EBP_PDT";
        String targetBasePath = "D:\\test";
        InputStream is = FileCopy.class.getResourceAsStream("fileList.txt");
        List<String> filePathArr = new ArrayList<String>();
        if (is != null) {
            InputStreamReader inputReader = new InputStreamReader(is);
            BufferedReader bf = new BufferedReader(inputReader);
            // 按行读取字符串
            String str;
            while ((str = bf.readLine()) != null) {
                filePathArr.add(str);
            }
            bf.close();
            inputReader.close();
            System.out.println("总共：" + filePathArr.size());
        }

        if (filePathArr != null) {
            for (String fileStr : filePathArr) {
                String sourceFilePath = basePath + fileStr.replace("/", "\\");
                String targetFilePath = targetBasePath + fileStr.replace("/", "\\");
                System.out.println(sourceFilePath);
                System.out.println(targetFilePath);
                File sourceFile = new File(sourceFilePath);
                File targetFile = new File(targetFilePath);
                if(sourceFile.exists() && !sourceFile.isDirectory())//是文件且不是文件夹
                {
                    copyFile(sourceFilePath, targetFilePath);
                }else{
                    if(sourceFile.isDirectory()){
                        copyFolder(sourceFilePath, targetFilePath);
                    }else{
                        System.out.println("文件或者文件夹不存在");
                    }
                }
            }
        }


    }

    /**
     * 复制单个文件
     *
     * @param oldPath String 原文件路径 如：c:/fqf.txt
     * @param newPath String 复制后路径 如：f:/fqf.txt
     * @return boolean
     */
    public static void copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { //文件存在时
                InputStream inStream = new FileInputStream(oldPath); //读入原文件
                File newfile = new File(newPath);
                if (!newfile.exists()) {
                    createFile(newfile);
                }
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                int length;
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();
        }
    }

    /**
     * 复制整个文件夹内容
     *
     * @param oldPath String 原文件路径 如：c:/fqf
     * @param newPath String 复制后路径 如：f:/fqf/ff
     * @return boolean
     */
    public static void copyFolder(String oldPath, String newPath) {
        try {
            (new File(newPath)).mkdirs(); //如果文件夹不存在 则建立新文件夹
            File a = new File(oldPath);
            String[] file = a.list();
            File temp = null;
            for (int i = 0; i < file.length; i++) {
                if (oldPath.endsWith(File.separator)) {
                    temp = new File(oldPath + file[i]);
                } else {
                    temp = new File(oldPath + File.separator + file[i]);
                }
                if (temp.isFile()) {
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath + "/" +
                            (temp.getName()).toString());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                if (temp.isDirectory()) {//如果是子文件夹
                    copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("复制整个文件夹内容操作出错");
            e.printStackTrace();
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
