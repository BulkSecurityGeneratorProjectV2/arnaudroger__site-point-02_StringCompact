package org.github.arnaudroger;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.nio.charset.Charset;


/*
java -jar target/benchmarks.jar -f 10 -i 10 -wi 10 -bm avgt -tu ns
Java8 121
Benchmark                            Mode  Cnt    Score   Error  Units
LookupBenchmark.indexOfChar          avgt  100   24.344 ± 0.262  ns/op
LookupBenchmark.indexOfStrOneChar    avgt  100   32.278 ± 0.321  ns/op
LookupBenchmark.indexOfStr           avgt  100  117.336 ± 1.559  ns/op

Java 9 160 

Benchmark                            Mode  Cnt   Score   Error  Units
LookupBenchmark.indexOfChar          avgt  100  23.661 ± 0.319  ns/op
LookupBenchmark.indexOfStrOneChar    avgt  100  19.743 ± 0.226  ns/op
LookupBenchmark.indexOfStr           avgt  100  65.157 ± 0.735  ns/op


 */

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
