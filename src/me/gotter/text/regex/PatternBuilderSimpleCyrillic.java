package me.gotter.text.regex;

import java.util.regex.Pattern;

public class PatternBuilderSimpleCyrillic extends PatternBuilder
{
    private static final String EMPTY_STRING = "";

    private static final Pattern[] commonWordEndings = new Pattern[]{
        Pattern.compile("[йуеъыаоэяиьюєії]*$", Pattern.CASE_INSENSITIVE)
    };

    @Override
    public PatternBuilder addWord(String word)
    {
        // Before usage, one must strip word-endings from word
        if (word == null) {
            // Delegating responsibility
            super.addWord(word);
        } else if (word.length() < 3) {
            // Word is short, passing as-is
            super.addWord(word);
        } else {
            for (Pattern pattern : commonWordEndings) {
                word = pattern.matcher(word).replaceAll(EMPTY_STRING);
            }
            super.addWord(word);
        }

        return this;
    }
}
