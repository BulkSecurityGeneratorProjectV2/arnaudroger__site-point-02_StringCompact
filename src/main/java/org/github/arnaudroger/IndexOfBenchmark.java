package org.github.arnaudroger;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;


@State(Scope.Benchmark)
public class IndexOfBenchmark {


    public String value;
    public char lookup;
    public String strLookup;
    
    @Param({"LATIN1", "UTF16_LATIN1_CHAR", "UTF16_UTF16_CHAR" })
    public StrType strType;

    @Setup
    public void setUp() {
        value = strType.value();
        lookup = strType.lookup();
        strLookup = "" + lookup;
    }
    
    @Benchmark
    public int indexOfChar() {
        return value.indexOf(lookup);
    }

    @Benchmark
    public int indexOfCharStr() {
        return value.indexOf(strLookup);
    }


}
