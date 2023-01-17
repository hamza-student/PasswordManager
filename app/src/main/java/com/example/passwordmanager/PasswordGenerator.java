package com.example.passwordmanager;

import java.nio.charset.Charset;
import java.util.Random;

public class PasswordGenerator {

    public static String generate() {
        final int higherLimit = 126;
        final int lowerLimit = 33;
        final Random random = new Random();
        final int size = random.nextInt(24 - 8) + 8;
        byte[] array = new byte[size];
        for (int i = 0; i < array.length; i++)
            array[i] = (byte) (random.nextInt(higherLimit - lowerLimit) + lowerLimit);

        return new String(array, Charset.defaultCharset());
    }
}

