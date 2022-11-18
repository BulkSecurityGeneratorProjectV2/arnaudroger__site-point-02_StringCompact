package org.github.arnaudroger;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;

@State(Scope.Benchmark)
public class ReaderBenchmark {

    public static char[] latin1 =  "abcdefghijklmnopqrstuvwxyz".toCharArray();

    @Param({"UTF-8", "UTF-16"})
    public String encoding;

    File file;
    Charset charset;
    @Setup
    public void setUp() throws IOException {

        charset = Charset.forName(encoding);
        file = Files.createTempFile("ReaderBenchmark-", ".txt").toFile();

        try (FileOutputStream fos = new FileOutputStream(file)) {
            try (OutputStreamWriter writer = new OutputStreamWriter(fos, charset)) {
                for(int i = 0; i < 1000; i ++) {
                    writer.write(latin1);
                }
            }
        }
    }


    @Benchmark
    public void reader(Blackhole blackhole) throws IOException {
        try (FileChannel channel = FileChannel.open(file.toPath())) {
            try (Reader reader = Channels.newReader(channel, charset.newDecoder(), -1)) {
                char[] buffer = new char[4096];
                int l;
                while ((l = reader.read(buffer)) != -1) {
                    blackhole.consume(new String(buffer, 0, l));
                }
            }
        }
    }


    public static void main(String[] args) {
        char c = 'ÿ';
        System.out.println("'ÿ' = " + ((int)'ÿ') + "/" + "ÿ".codePointAt(0));
    }

}
