package Algorithms.armstrongNumbers;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

/**
 * Created by David Soroko on 29/02/2016.
 */
public final class Armstrong {

    private Verifier verifier = new Verifier();

    public Set<String> level (int level) {
        final Stream<byte[]> byteStream =  Representatives.asStream(level,  true);
        return collectStringsToSet(byteStream.map(verifier::apply));
    }


    private Set<String> collectStringsToSet(Stream<String> stream) {
        final ConcurrentSkipListSet<String> result = new ConcurrentSkipListSet<>();
        stream.filter(Objects::nonNull).collect(toCollection(() -> result));
        return result;
    }

}
