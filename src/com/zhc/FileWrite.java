package com.zhc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.IOException;


public class FileWrite {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://localhost:9000");
        conf.set("fs.hdfs.impl","org.apache.hadoop.hdfs.DistributedFileSystem");
        FileSystem fs = FileSystem.get(conf);
        byte[] buff = "Hello world".getBytes(); // 要写入的内容
        String filename = "test/writeTest.txt"; //要写入的文件名
        FSDataOutputStream os = fs.create(new Path(filename));
        os.write(buff,0,buff.length);
        System.out.println("Create:"+ filename);
        os.close();
        fs.close();
    }
}
