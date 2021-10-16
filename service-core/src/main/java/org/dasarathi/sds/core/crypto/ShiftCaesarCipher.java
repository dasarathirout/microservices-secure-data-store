package org.dasarathi.sds.core.crypto;

import java.util.logging.Logger;

public final class ShiftCaesarCipher {
    // https://en.wikipedia.org/wiki/Caesar_cipher
    private static final Logger LOG = Logger.getLogger(ShiftCaesarCipher.class.getName());
    private static final int SHIFT = 95;
    private static String ASCII_FROM_32_TO_127 = "";

    static {
        for (int i = 32; i < 127; i++) {
            ASCII_FROM_32_TO_127 += String.valueOf((char) i);
        }
    }

    private ShiftCaesarCipher() {

    }

    public static final String encrypt(String inValue, int shiftKey) {
        String cipherValue = "";
        for (int i = 0; i < inValue.length(); i++) {
            int charPosition = ASCII_FROM_32_TO_127.indexOf(inValue.charAt(i));
            int keyVal = (shiftKey + charPosition) % SHIFT;
            char replaceVal = ASCII_FROM_32_TO_127.charAt(keyVal);
            cipherValue += replaceVal;
        }
        return cipherValue;
    }

    public static final String decrypt(String cipherValue, int shiftKey) {
        String rawValue = "";
        for (int i = 0; i < cipherValue.length(); i++) {
            int charPosition = ASCII_FROM_32_TO_127.indexOf(cipherValue.charAt(i));
            int keyVal = (charPosition - shiftKey) % SHIFT;
            if (keyVal < 0) {
                keyVal = ASCII_FROM_32_TO_127.length() + keyVal;
            }
            char replaceVal = ASCII_FROM_32_TO_127.charAt(keyVal);
            rawValue += replaceVal;
        }
        return rawValue;
    }

}
