package org.esprit.ib.utils;

public final class CodeGenerator {
    private static Integer serial = 1;

    public static String generate() {
        StringBuilder s = new StringBuilder(serial.toString());
        while (s.length() < 10) {
            s.insert(0, "0");
        }
        serial++;
        return s.toString();
    }
}
