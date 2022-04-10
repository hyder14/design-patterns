package com.hyders.io;

import java.io.*;

public class ReadIntoBuffer {


    public static void copy(File src, File dest) {
        try {
            InputStream in =  new FileInputStream (src);
            OutputStream out = new FileOutputStream(dest);
            byte[] buffer = new byte[2048];
            int n;
            while((n=in.read(buffer))>0) {
                out.write(buffer,0,n);
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void main(String[] args) {

        File inputfile = new File("src/main/java/com/hyders/io/testCSV.csv");
        File targetFile = new File("testOutPut.csv");
        ReadIntoBuffer.copy(inputfile,targetFile);
    }


}
