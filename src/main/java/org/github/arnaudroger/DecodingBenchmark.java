package org.github.arnaudroger;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.nio.charset.Charset;




@State(Scope.Benchmark)
public class DecodingBenchmark {


    @Param({"LATIN1", "UTF16_LATIN1_CHAR"})
    public StrType strType;

    @Param({"ISO_8859-1", "UTF-8", "UTF-16"})
    public String encoding;

    public byte[] value;

    private Charset charset;

    @Setup
    public void setUp() {
        charset = Charset.forName(encoding);
        value = strType.value().getBytes(charset);
    }

    @Benchmark
    public String testDecoding() {
        return new String(value, charset);
    }



}
