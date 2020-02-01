package com.battybuilds.testexamples.transformer;

import com.battybuilds.testexamples.service.MyService;
import org.springframework.stereotype.Component;

@Component
public class MyTransformer {

    public static String transform(String input) {
        return "transformed";
    }
}
