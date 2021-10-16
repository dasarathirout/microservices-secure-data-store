package org.dasarathi.sds.core.crypto;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Logger;

public final class RSAEncryption {
    private static final Logger LOG = Logger.getLogger(RSAEncryption.class.getName());

    private RSAEncryption() {
    }

    public static String decryptContents(String encryptedData, PublicKey publicKey) {
        try {
            Cipher decryptCipher = Cipher.getInstance("RSA");
            decryptCipher.init(Cipher.DECRYPT_MODE, publicKey);
            return new String(decryptCipher.doFinal(Base64.decodeBase64(encryptedData)));
        } catch (Exception ex) {
            LOG.severe(" Failed Decrypt: " + ex.getMessage());
            throw new RuntimeException("Unable To Decrypt " + encryptedData);
        }
    }

    public static String encryptContents(String inPutData, PrivateKey privateKey) {
        try {
            Cipher encryptCipher = Cipher.getInstance("RSA");
            encryptCipher.init(Cipher.ENCRYPT_MODE, privateKey);
            return Base64.encodeBase64String(encryptCipher.doFinal(inPutData.getBytes()));
        } catch (Exception ex) {
            LOG.severe(" Failed Encrypt: " + ex.getMessage());
            throw new RuntimeException("Unable To Encrypt " + inPutData);
        }
    }
}

