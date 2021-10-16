package org.dasarathi.sds.core.encrypt;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.dasarathi.sds.core.crypto.KeyPairRSA;
import org.dasarathi.sds.core.model.DomainModel;

import javax.crypto.Cipher;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Logger;

public final class UserEncryption {
    private static final Logger LOG = Logger.getLogger(UserEncryption.class.getName());
    private static final PublicKey USER_PUBLIC_KEY = KeyPairRSA.getPublicKey();
    private static final PrivateKey USER_PRIVATE_KEY = KeyPairRSA.getPrivateKey();

    private UserEncryption() {

    }

    public static final String withJSONFormat(DomainModel inUser) {
        try {
            ObjectMapper jsonMapper = new ObjectMapper();
            String jsonUserString = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(inUser);
            return jsonUserString;
        } catch (Exception ex) {
            LOG.severe("User JSON Encryption Failed : " + ex.getMessage());
            throw new RuntimeException("Failed User Field JSON Encryption");
        }
    }

    public static final String withXMLFormat(DomainModel inUser) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xmlUserString = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(inUser);
            LOG.info(xmlUserString);
            return xmlUserString;
        } catch (Exception ex) {
            LOG.severe("User JSON Encryption Failed : " + ex.getMessage());
            throw new RuntimeException("Failed User Field XML Encryption");
        }
    }

    public static final String encryptUserContents(String userData) {
        try {
            Cipher encryptCipher = Cipher.getInstance("RSA");
            encryptCipher.init(Cipher.ENCRYPT_MODE, USER_PRIVATE_KEY);
            String encryptUserData = Base64.encodeBase64String(encryptCipher.doFinal(userData.getBytes()));
            LOG.info(encryptUserData);
            return encryptUserData;
        } catch (Exception ex) {
            LOG.severe("Encrypt User Data Failed : " + ex.getMessage());
            throw new RuntimeException("Encrypt User String Contents Failed.");
        }
    }

    public static final String decryptUserContents(String userData) {
        try {
            Cipher decryptCipher = Cipher.getInstance("RSA");
            decryptCipher.init(Cipher.DECRYPT_MODE, USER_PUBLIC_KEY);
            String decryptUserData = new String(decryptCipher.doFinal(Base64.decodeBase64(userData)));
            LOG.info(decryptUserData);
            return decryptUserData;
        } catch (Exception ex) {
            LOG.severe("Decrypt User Data Failed : " + ex.getMessage());
            throw new RuntimeException("Decrypt User String Contents Failed.");
        }
    }
}
