package me.gotter.text.regex;

import me.gotter.text.regex.util.Unicode;

import java.util.regex.Pattern;

/**
 * Pattern builder to create regular expression pattern from
 * provided list of words
 */
public class PatternBuilder
{
    private StringBuilder buffer = new StringBuilder();
    private PatternBuildRules rules;
    private boolean first = true;

    /**
     * Default constructor
     */
    public PatternBuilder()
    {
        this(null, null);
    }

    /**
     * Constructor with provided rules
     *
     * @param rules
     */
    public PatternBuilder(PatternBuildRules rules)
    {
        this(null, rules);
    }

    /**
     * Main constructor
     *
     * @param word
     * @param rules
     */
    public PatternBuilder(String word, PatternBuildRules rules)
    {
        if (rules == null) {
            this.rules = PatternBuildRules.getDefault();
        } else {
            this.rules = rules;
        }

        if (word != null) {
            addWord(word);
        }
    }

    /**
     * Adds a new word to pattern
     *
     * @param word
     * @return
     */
    public PatternBuilder addWord(String word)
    {
        if (first) {
            first = false;
            buffer.append(rules.getWhitespaceSequence());
        }
        buffer.append(word.trim());
        buffer.append(rules.getWhitespaceSequence());
        return this;
    }

    /**
     * Compiles and returns pattern
     *
     * @return
     */
    public Pattern getPattern()
    {
        int flags = 0;
        if (rules.isCaseInsensitive()) {
            flags = Pattern.CASE_INSENSITIVE;
        }
        return Pattern.compile(toString(), flags);
    }

    @Override
    public String toString()
    {
        return buffer.toString();
    }






    /**
     * Internal class, containing information about builder rules
     */
    public static class PatternBuildRules
    {
        private static PatternBuildRules _default;
        public static PatternBuildRules getDefault()
        {
            if (_default == null) {
                _default = new PatternBuildRules(Unicode.WORD_SEPARATOR, false);
            }
            return _default;
        }

        private String whitespaceSequence;
        private boolean caseSensitive;

        public PatternBuildRules(String whitespace, boolean caseSensitive)
        {
            this.whitespaceSequence = whitespace;
            this.caseSensitive = caseSensitive;
        }

        public String getWhitespaceSequence()
        {
            return whitespaceSequence;
        }

        public boolean isCaseSensitive()
        {
            return caseSensitive;
        }

        public boolean isCaseInsensitive()
        {
            return !caseSensitive;
        }
    }
}
