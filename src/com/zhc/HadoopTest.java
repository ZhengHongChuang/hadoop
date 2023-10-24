package com.zhc;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.util.Scanner;

public class HadoopTest {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://localhost:9000");
        conf.set("fs.hdfs.impl","org.apache.hadoop.hdfs.DistributedFileSystem");
        FileSystem fs = FileSystem.get(conf);
        System.out.println("请输入要查找的路径或文件:");
        Scanner scanner = new Scanner(System.in);
        String path_or_file = scanner.next();
        if (fs.exists(new Path(path_or_file))) {
            System.out.println("文件或目录存在！");
        }else{
            System.out.println("文件或目录不存在！");
        }



    }
}
