package org.github.arnaudroger;

import org.openjdk.jmh.annotations.Benchmark;

/*
Benchmark                                        Mode  Cnt   Score   Error  Units
StringBuilderBenchmark.appendLatin1              avgt   20  75.493 ± 2.546  ns/op
StringBuilderBenchmark.appendLatin1Str           avgt   20  55.631 ± 1.832  ns/op
StringBuilderBenchmark.appendLatin1ThenUtf16     avgt   20  76.153 ± 2.352  ns/op
StringBuilderBenchmark.appendLatin1ThenUtf16Str  avgt   20  57.980 ± 2.216  ns/op
StringBuilderBenchmark.appendUtf16               avgt   20  75.562 ± 3.021  ns/op
StringBuilderBenchmark.appendUtf16Str            avgt   20  57.069 ± 2.066  ns/op


Benchmark                                        Mode  Cnt    Score   Error  Units
StringBuilderBenchmark.appendLatin1              avgt   20   82.721 ± 2.904  ns/op
StringBuilderBenchmark.appendLatin1Str           avgt   20   52.807 ± 1.715  ns/op
StringBuilderBenchmark.appendLatin1ThenUtf16     avgt   20  115.576 ± 3.477  ns/op
StringBuilderBenchmark.appendLatin1ThenUtf16Str  avgt   20   82.696 ± 2.307  ns/op
StringBuilderBenchmark.appendUtf16               avgt   20  102.350 ± 4.584  ns/op
StringBuilderBenchmark.appendUtf16Str            avgt   20   90.436 ± 2.909  ns/op


 */
public class StringBuilderBenchmark {


    public static final String latin1Str = "abcdefghijklmnopqrstuvwxyz";
    public static final String utf16Str = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩ";
    public static char[] latin1 =  latin1Str.toCharArray();
    public static char[] utf16 =    utf16Str.toCharArray();
    
    
    
    
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


    @Benchmark
    public StringBuilder appendLatin1Str() {
        StringBuilder sb = new StringBuilder();

        sb.append(latin1Str);
        sb.append(latin1Str);

        return sb;

    }

    @Benchmark
    public StringBuilder appendLatin1ThenUtf16Str() {
        StringBuilder sb = new StringBuilder();

        sb.append(latin1Str);
        sb.append(utf16Str);

        return sb;
    }

    @Benchmark
    public StringBuilder appendUtf16Str() {
        StringBuilder sb = new StringBuilder();

        sb.append(utf16Str);
        sb.append(utf16Str);

        return sb;
    }
}
