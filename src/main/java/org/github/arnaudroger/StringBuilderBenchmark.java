package org.github.arnaudroger;

import org.openjdk.jmh.annotations.Benchmark;

public class StringBuilderBenchmark {
    
    
    public static char[] latin1 =  "abcdefghijklmnopqrstuvwxyz".toCharArray();
    public static char[] utf16 =    "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩ".toCharArray();
    
    
    @Benchmark
    public StringBuilder appendLatin1() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(latin1);
        sb.append(latin1);
        
        return sb;
        
    }

    @Benchmark
    public StringBuilder appendLatin1ThenUtf16() {
        StringBuilder sb = new StringBuilder();

        sb.append(latin1);
        sb.append(utf16);

        return sb;
    }
    
    @Benchmark
    public StringBuilder appendUtf16() {
        StringBuilder sb = new StringBuilder();

        sb.append(utf16);
        sb.append(utf16);

        return sb;
    }

}
