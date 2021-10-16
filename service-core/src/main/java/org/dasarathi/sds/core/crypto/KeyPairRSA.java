package org.dasarathi.sds.core.crypto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
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
            writeOnFile(PUBLIC_KEY_FILE, publicKey.getEncoded());

            PrivateKey privateKey = newKeyPair.getPrivate();
            writeOnFile(PRIVATE_KEY_FILE, privateKey.getEncoded());

        } catch (Exception ex) {
            LOG.severe("Failed To Generate RSA Key Pair : " + ex.getMessage());
        }
    }

    private static void writeOnFile(String fileName, byte[] fileContents) {
        File filePath = new File(fileName);
        filePath.getParentFile().mkdirs();
        try {
            FileOutputStream keyFOS = new FileOutputStream(filePath);
            keyFOS.write(fileContents);
            keyFOS.flush();
            keyFOS.close();
        } catch (Exception ex) {
            LOG.severe("Failed To Write/Close On " + fileName + " : " + ex.getMessage());
        }
    }

    public static PrivateKey getPrivateKey() {
        PrivateKey privateKey = null;
        try {
            byte[] privateKeyBytes = Files.readAllBytes(new File(PRIVATE_KEY_FILE).toPath());
            LOG.info(new String(privateKeyBytes, StandardCharsets.UTF_8));
            KeyFactory privateKeyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec encodedPrivateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            privateKey = privateKeyFactory.generatePrivate(encodedPrivateKeySpec);
        } catch (Exception ex) {
            LOG.severe("Failed To Read Private Key File " + ex.getMessage());
            ex.printStackTrace();
        }
        return privateKey;
    }

    public static PublicKey getPublicKey() {
        PublicKey publicKey = null;
        try {
            byte[] privateKeyBytes = Files.readAllBytes(new File(PUBLIC_KEY_FILE).toPath());
            KeyFactory pubKeyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec encodedPublicKeySpec = new X509EncodedKeySpec(privateKeyBytes);
            publicKey = pubKeyFactory.generatePublic(encodedPublicKeySpec);
        } catch (Exception ex) {
            LOG.severe("Failed To Read Public Key File " + ex.getMessage());
        }
        return publicKey;
    }
}
