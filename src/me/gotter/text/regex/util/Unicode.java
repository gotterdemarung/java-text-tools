package me.gotter.text.regex.util;

/**
 * Final container for Unicode Regex sequences
 */
public  final class Unicode {
    public static final String
            LETTER      = "\\p{L}", // any kind of letter from any language
            WHITESPACE  = "\\p{Z}", // any kind of whitespace or invisible separator
            NUMERIC     = "\\p{N}", // any kind of numeric character in any script
            PUNCTUATION = "\\p{P}", // any kind of punctuation character
            CONTROL     = "\\p{C}";  // invisible control characters and unused code points

    public static final String
            WORD_SEPARATOR = "^|$|" + Unicode.WHITESPACE + "|" + Unicode.PUNCTUATION;
}