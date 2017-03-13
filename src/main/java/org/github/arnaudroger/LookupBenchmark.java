package org.github.arnaudroger;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;


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
public class LookupBenchmark {
    
    
    private String latin1;
    private String utf16;
    
    @Setup
    public void setUp() {
        latin1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris sed commodo mauris. Ut elit nisl, interdum eget metus in, dignissim sollicitudin est. Ut ut sem dapibus, aliquam nisl in, volutpat elit. Duis facilisis, turpis vitae pellentesque maximus, tortor odio luctus nunc, sagittis faucibus erat arcu eu urna. Nulla nunc augue, malesuada scelerisque sodales ac, lacinia sit amet arcu. Suspendisse in sollicitudin augue, eu venenatis justo. Interdum et malesuada fames ac ante ipsum primis in faucibus. Sed iaculis lorem et porttitor imperdiet. Curabitur a tristique massa, eget faucibus risus. Ut eget arcu sed dui commodo elementum eu at dui. Nunc eget libero posuere, laoreet eros non, auctor neque. Curabitur nisl quam, consequat quis mollis at, interdum eu mauris. Praesent sollicitudin vitae massa quis aliquet.";
        utf16   = "шLorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris sed commodo mauris. Ut elit nisl, interdum eget metus in, dignissim sollicitudin est. Ut ut sem dapibus, aliquam nisl in, volutpat elit. Duis facilisis, turpis vitae pellentesque maximus, tortor odio luctus nunc, sagittis faucibus erat arcu eu urna. Nulla nunc augue, malesuada scelerisque sodales ac, lacinia sit amet arcu. Suspendisse in sollicitudin augue, eu venenatis justo. Interdum et malesuada fames ac ante ipsum primis in faucibus. Sed iaculis lorem et porttitor imperdiet. Curabitur a tristique massa, eget faucibus risus. Ut eget arcu sed dui commodo elementum eu at dui. Nunc eget libero posuere, laoreet eros non, auctor neque. Curabitur nisl quam, consequat quis mollis at, interdum eu mauris. Praesent sollicitudin vitae massa quis aliquet.";
    }
    
    @Benchmark
    public int latin1IndexOfStr() {
        return latin1.indexOf("scelerisque");
    }
    @Benchmark
    public int latin1IndexOfChar() {
        return latin1.indexOf('U');
    }
    @Benchmark
    public int latin1IndexOfStrOneChar() {
        return latin1.indexOf("U");
    }

    @Benchmark
    public int utf16IndexOfStr() {
        return utf16.indexOf("scelerisque");
    }
    @Benchmark
    public int utf16IndexOfChar() {
        return utf16.indexOf('U');
    }
    @Benchmark
    public int utf16IndexOfStrOneChar() {
        return utf16.indexOf("U");
    }


}
