package org.dasarathi.sds.one.service.utils.encrypt;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.dasarathi.sds.core.crypto.KeyPairRSA;
import org.dasarathi.sds.one.model.User;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Logger;

public final class UserEncryption {
    private static final Logger LOG = Logger.getLogger(UserEncryption.class.getName());
    private static PublicKey publicKey = KeyPairRSA.getPublicKey();
    private static PrivateKey privateKey = KeyPairRSA.getPrivateKey();

    private UserEncryption() {

    }

    public static String withJSONFormat(User inUser) {
        try {
            ObjectMapper jsonMapper = new ObjectMapper();
            String jsonUserString = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(inUser);
            LOG.info(jsonUserString);
            return jsonUserString;
        } catch (Exception ex) {
            LOG.severe("User JSON Encryption Failed : " + ex.getMessage());
            throw new RuntimeException("Failed User Field JSON Encryption");
        }
    }

    public static String withXMLFormat(User inUser) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writerWithDefaultPrettyPrinter();
            String xmlUserString = xmlMapper.writeValueAsString(inUser);
            LOG.info(xmlUserString);
            return xmlUserString;
        } catch (Exception ex) {
            LOG.severe("User JSON Encryption Failed : " + ex.getMessage());
            throw new RuntimeException("Failed User Field XML Encryption");
        }
    }
}
