package org.dasarathi.sds.core.crypto;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Logger;

public final class RSAEncryption {
    public static final String PUBLIC_KEY = "keys" + File.separator + "sds-public.key";
    public static final String PRIVATE_KEY = "keys" + File.separator + "sds-private.key";
    private static final Logger LOG = Logger.getLogger(RSAEncryption.class.getName());

    private RSAEncryption() {
    }

    public static PrivateKey getPrivateKey() {
        PrivateKey privateKey = null;
        try {
            Path resourcePrivateKeyPath = new ClassPathResource(PRIVATE_KEY).getFile().toPath();
            //ResourceUtils.getFile("classpath:" + PRIVATE_KEY).toPath();
            byte[] privateKeyBytes = Files.readAllBytes(resourcePrivateKeyPath);
            KeyFactory privateKeyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec encodedPrivateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            privateKey = privateKeyFactory.generatePrivate(encodedPrivateKeySpec);
        } catch (Exception ex) {
            LOG.severe("Failed To Read Private Key File " + ex.getMessage());
        }
        return privateKey;
    }

    public static PublicKey getPublicKey() {
        PublicKey publicKey = null;
        try {
            Path resourcePublicKeyPath = new ClassPathResource(PRIVATE_KEY).getFile().toPath();
            // ResourceUtils.getFile("classpath:" + PUBLIC_KEY).toPath();
            byte[] publicKeyBytes = Files.readAllBytes(resourcePublicKeyPath);
            KeyFactory pubKeyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec encodedPublicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
            publicKey = pubKeyFactory.generatePublic(encodedPublicKeySpec);
        } catch (Exception ex) {
            LOG.severe("Failed To Read Public Key File " + ex.getMessage());
        }
        return publicKey;
    }
}

