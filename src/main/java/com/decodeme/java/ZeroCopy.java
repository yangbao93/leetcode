package com.decodeme.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ZeroCopy {

    public static void main(String[] args) throws IOException {
        // Java中的零拷贝
        // 使用mmap的方式去实现
        File file = new File("/a/b/c.txt");
        RandomAccessFile rw = new RandomAccessFile(file, "rw");
        MappedByteBuffer map = rw.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 2018);
        map.put("mmap content".getBytes());
        rw.close();

        // transfile的方式
        try (FileInputStream fis = new FileInputStream(file)) {
            FileChannel channel = fis.getChannel();
            FileOutputStream fos = new FileOutputStream("/a/b/c_copy.txt");
            FileChannel fosChannel = fos.getChannel();
            // 将一个管道transfer到另一个管道中
            channel.transferTo(0, file.length(), fosChannel);
        }
    }
}
