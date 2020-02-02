package com.battybuilds.testexamples.transformer;

import org.springframework.stereotype.Component;

@Component
public class MyTransformer {

    public static String transform(String input) {
        return "transformed";
    }

    public String scrapeClasses(String htmlFromGoogle) {
        String[] classLines = htmlFromGoogle.split("<");
        String classes = "";
        for (int i=1; i < classLines.length; i++) {
            String line = classLines[i];
            if (hasClass(line)) {
                System.out.println(line);
                classes += " | " + scrapeClass(line);
            }
        }

        return classes;
    }

    String scrapeClass(String line) {
        String trimmedLine = line.substring(getIndex(line));
        if (trimmedLine.matches(".* .*")) {
            trimmedLine = trimmedLine.substring(0, trimmedLine.indexOf(" "));
        }
        if (trimmedLine.contains(">")) {
            trimmedLine = trimmedLine.substring(0, trimmedLine.indexOf(">"));
        }
        return trimmedLine;
    }

    int getIndex(String line) {
        return line.indexOf("class") + 6;
    }

    private boolean hasClass(String classLine) {
        return classLine.matches(".*class=.*");
    }
}
