import me.gotter.text.regex.util.Unicode;
import me.gotter.text.regex.PatternBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PatternBuilderTest {


    private String[] words;
    private String expected;

    @Parameterized.Parameters
    public static Collection asserts() {
        return Arrays.asList(new Object[][]{
                {Unicode.WORD_SEPARATOR+"hello"+Unicode.WORD_SEPARATOR, new String[]{"hello"}},
                {Unicode.WORD_SEPARATOR+"hello"+Unicode.WORD_SEPARATOR, new String[]{" hello  "}},
                {"", new String[]{}},
                {Unicode.WORD_SEPARATOR+"hello"+Unicode.WORD_SEPARATOR+"world"+Unicode.WORD_SEPARATOR, new String[]{"hello", "world"}},
                {Unicode.WORD_SEPARATOR+"hello"+Unicode.WORD_SEPARATOR+"2"+Unicode.WORD_SEPARATOR, new String[]{"hello","2"}}
        });
    }

    public PatternBuilderTest(String expected, String[] words) {
        this.words = words;
        this.expected = expected;
    }

    @Test
    public void test()
    {
        PatternBuilder pb = new PatternBuilder();
        for (String s : words) {
            pb.addWord(s);
        }
        Assert.assertEquals(expected, pb.toString());
    }
}
