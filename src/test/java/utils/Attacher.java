package utils;

import java.io.File;

public class Attacher {

    public static void add(File file, String JIRATestKey) {
        JIRAAttachment.addAttachment(file, JIRATestKey);
    }
}
