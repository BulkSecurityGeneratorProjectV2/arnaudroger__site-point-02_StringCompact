package org.github.arnaudroger;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.CompilerControl;
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

    @Param({"1", "150" })
    public int lookupPosition ;
    @Setup
    public void setUp() {
        value = strType.value();
        lookup = value.charAt(lookupPosition);
        if (lookupPosition != value.indexOf(lookup)) {
            throw new IllegalArgumentException("Invalid lookupPosition " + lookupPosition + " matches first index  " +value.indexOf(lookup) );
        }
        strLookup = "" + lookup;
    }

    @Benchmark
    public int indexOfChar() {
        return value.indexOf(lookup);
    }

    @Benchmark
    public int indexOfStr() {
        return value.indexOf(strLookup);
    }

}
