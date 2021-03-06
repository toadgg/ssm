package com.ssm.common.base.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public abstract class PatternUtils {

    /**
     * @param pattern Using comma(,) as a separator e.g. '(.*).xml,(.*).properties'
     * @return Pattern List
     */
    public static List<Pattern> buildPatterns(String pattern) {
        return buildPatterns(pattern, 0);
    }

    public static List<Pattern> buildPatterns(String pattern, int flags) {
        if (pattern != null && pattern.trim().length() != 0) {
            List<Pattern> list = new ArrayList<Pattern>();
            String[] tokens = pattern.split("\\s*[,]\\s*");
            for (String token : tokens) {
                list.add(Pattern.compile(token.trim(), flags));
            }
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

    /**
     * @param pattern Using comma(,) as a separator e.g. '(.*).xml,(.*).properties'
     * @param input   The character sequence to be matched
     * @return true|false
     */
    public static boolean match(String pattern, CharSequence input) {
        return match(buildPatterns(pattern), input);
    }

    /**
     * @param patterns Pattern List
     * @param input    The character sequence to be matched
     * @return true|false
     */
    public static boolean match(List<Pattern> patterns, CharSequence input) {
        if (patterns != null && !patterns.isEmpty()) {
            for (Pattern pattern : patterns) {
                if (pattern.matcher(input).matches()) {
                    return true;
                }
            }
        }
        return false;
    }
}
