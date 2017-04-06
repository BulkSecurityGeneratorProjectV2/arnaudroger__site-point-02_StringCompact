package org.github.arnaudroger;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;


@State(Scope.Benchmark)
public class CharAtBenchmark {


    public String value;
    
    @Param({"LATIN1", "UTF16_LATIN1_CHAR", "UTF16_UTF16_CHAR" })
    public StrType strType;

    @Setup
    public void setUp() {
        value = strType.value();
    }
    
    @Benchmark
    public long charAt() {
        
        long l = 0;
        for(int i = 0; i < value.length(); i++) {
            l += value.charAt(i);
        }
        return l;
    }



}
