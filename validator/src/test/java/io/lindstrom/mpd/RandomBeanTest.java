package io.lindstrom.mpd;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.FieldDefinitionBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import io.lindstrom.mpd.data.MPD;
import io.lindstrom.mpd.data.PresentationType;
import io.lindstrom.mpd.data.descriptor.Descriptor;
import io.lindstrom.mpd.data.descriptor.GenericDescriptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

@RunWith(Parameterized.class)
public class RandomBeanTest {
    private static final Random RANDOM = new Random();

    @Parameters
    public static Iterable<MPD> randomBeans() {
        EnhancedRandom random = new MPDRandomBuilder()
                .constantStringField("segmentAlignment", "true")
                .constantStringField("subsegmentAlignment", "true")
                .constantStringField("lang", "sv")
                .constantStringField("contains", "1")
                .constantStringField("dependencyLevel", "1")
                .randomize(Long.class, (Supplier<Long>) () -> 5L)
                .randomize(PresentationType.class,(Supplier<PresentationType>) () ->
                        RANDOM.nextBoolean() ? PresentationType.STATIC : PresentationType.DYNAMIC)
                .randomize(Descriptor.class, new Supplier<Descriptor>() {
                    private final EnhancedRandom random = new EnhancedRandomBuilder().build();
                    @Override
                    public Descriptor get() {
                        return random.nextObject(GenericDescriptor.class);
                    }
                })
                .collectionSizeRange(1, 2)
                .seed(10005)
                .build();

        return () -> Stream.generate(() -> random.nextObject(MPD.class))
                .limit(10).iterator();
    }

    private final MPD mpd;

    public RandomBeanTest(MPD mpd) {
        this.mpd = mpd;
    }

    @Test
    public void randomMPD() throws Exception {
        MPDValidator validator = new MPDValidator();
        validator.xsdValidation(mpd);
    }

    static class MPDRandomBuilder extends EnhancedRandomBuilder {
        MPDRandomBuilder constantStringField(String fieldName, String value) {
            randomize(FieldDefinitionBuilder.field()
                    .named(fieldName).ofType(String.class).get(), (Supplier<String>) () -> value);
            return this;
        }
    }
}
