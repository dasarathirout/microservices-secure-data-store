package org.dasarathi.sds.core.crypto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import java.util.logging.Logger;

public class KeyPairRSA {
    private static final Logger LOG = Logger.getLogger(KeyPairRSA.class.getName());

    private static final String PUBLIC_KEY_FILE = "KeyPairs" + File.separator + "sds-public.key";
    private static final String PRIVATE_KEY_FILE = "KeyPairs" + File.separator + "sds-private.key";

    private static void generatePublicPrivateKeys() {
        try {
            SecureRandom secureRandom = new SecureRandom();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048, secureRandom);
            KeyPair newKeyPair = keyPairGenerator.generateKeyPair();

            PublicKey publicKey = newKeyPair.getPublic();
            writeOnFile(PUBLIC_KEY_FILE, publicKey.toString());

            PrivateKey privateKey = newKeyPair.getPrivate();
            writeOnFile(PRIVATE_KEY_FILE, privateKey.toString());

        } catch (Exception ex) {
            LOG.severe("Failed To Generate RSA Key Pair : " + ex.getMessage());
        }
    }

    private static void writeOnFile(String fileName, String fileContents) {
        Path filePath = Paths.get(fileName);
        ;
        BufferedWriter fileWriter = null;

        try {
            new File(fileName).getParentFile().mkdirs();
            fileWriter = Files.newBufferedWriter(filePath);
            fileWriter.write(fileContents);
        } catch (Exception ex) {
            LOG.severe("Failed To Write On " + fileName + " : " + ex.getMessage());
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception ex) {
                LOG.severe("Failed To Close The File " + fileName + " : " + ex.getMessage());
            }
        }
    }
}
