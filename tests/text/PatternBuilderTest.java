package text;

import junit.framework.Assert;
import me.gotter.text.regex.PatternBuilder;
import me.gotter.text.regex.util.Unicode;
import org.junit.Test;

import java.util.regex.Pattern;

public class PatternBuilderTest {

    @Test(expected = NullPointerException.class)
    public void testNull()
    {
        PatternBuilder pb = new PatternBuilder();
        pb.addWord(null);
    }

    @Test
    public void testPattern()
    {
        Assert.assertEquals(Pattern.compile("").pattern(), new PatternBuilder().getPattern().pattern());
        Assert.assertEquals(
                Pattern.compile(
                        Unicode.WORD_SEPARATOR
                        + "first"
                        + Unicode.WORD_SEPARATOR
                ).pattern(),
                new PatternBuilder().addWord("first").getPattern().pattern()
        );
        Assert.assertEquals(
                Pattern.compile(
                        Unicode.WORD_SEPARATOR
                        + "first"
                        + Unicode.WORD_SEPARATOR
                        + "second"
                        + Unicode.WORD_SEPARATOR
                ).pattern(),
                new PatternBuilder().addWord("first").addWord("second").getPattern().pattern()
        );
    }

    @Test
    public void setToString()
    {
        Assert.assertEquals("", new PatternBuilder().toString());
        Assert.assertEquals(
                Unicode.WORD_SEPARATOR
                    + "first"
                    + Unicode.WORD_SEPARATOR,
                new PatternBuilder().addWord("first").toString()
        );
        Assert.assertEquals(
                Unicode.WORD_SEPARATOR
                    + "first"
                    + Unicode.WORD_SEPARATOR
                    + "second"
                    + Unicode.WORD_SEPARATOR,
                new PatternBuilder().addWord("first").addWord("second").toString()
        );
    }

}
