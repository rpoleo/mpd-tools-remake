package io.lindstrom.mpd.support;

import com.fasterxml.jackson.databind.JsonMappingException;
import io.lindstrom.mpd.data.Ratio;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RatioSerializerTest extends ObjectMapperTestBase<Ratio> {
    public RatioSerializerTest() {
        super(Ratio.class, new RatioSerializer(), new RatioDeserializer());
    }

    @Test
    public void serialize1() throws Exception {
        assertEquals("2:1", write(new Ratio(2L, 1L)));
    }

    @Test
    public void serialize2() throws Exception {
        assertEquals(":3", write(new Ratio(null, 3L)));
    }

    @Test
    public void serialize3() throws Exception {
        assertEquals("4:", write(new Ratio(4L, null)));
    }

    @Test
    public void serialize4() throws Exception {
        assertEquals(":", write(new Ratio(null, null)));
    }

    @Test
    public void deserialize1() throws Exception {
        assertEquals(new Ratio(2L, 1L), read("2:1"));
    }

    @Test
    public void deserialize2() throws Exception {
        assertEquals(new Ratio(null, 3L), read(":3"));
    }

    @Test
    public void deserialize3() throws Exception {
        assertEquals(new Ratio(4L, null), read("4:"));
    }

    @Test
    public void deserialize4() throws Exception {
        assertEquals(new Ratio(null, null), read(":"));
    }

    @Test(expected = JsonMappingException.class)
    public void deserializeFail1() throws Exception {
        read("");
    }

    @Test(expected = JsonMappingException.class)
    public void deserializeFail2() throws Exception {
        read("x");
    }
}