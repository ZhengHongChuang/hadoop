package com.zhc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileRead {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://localhost:9000");
        conf.set("fs.hdfs.impl","org.apache.hadoop.hdfs.DistributedFileSystem");
        FileSystem fs = FileSystem.get(conf);
        System.out.println("请输入要输出的文件:");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.next();
        if (fs.isFile(new Path(filePath))) {
            FSDataInputStream fsDataInputStream = fs.open(new Path(filePath));

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsDataInputStream));
            StringBuilder contentBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
            String content = contentBuilder.toString();
            System.out.println(content);

            bufferedReader.close();
        }else {
            System.out.println("请输入正确的文件路径！！！");
        }
        fs.close();


    }
}
