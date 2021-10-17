package org.dasarathi.sds.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dasarathi.sds.core.encrypt.UserEncryption;
import org.dasarathi.sds.core.model.User;

import java.util.logging.Logger;

public class DataConvertor {
    private static final Logger LOG = Logger.getLogger(DataConvertor.class.getName());
    private static final ObjectMapper mapper = new ObjectMapper();

    public static User fromCSVValue() {
        return null;
    }

    public static User fromJSONValue(String inValue) {
        ;
        User model;
        try {
            model = mapper.readValue(UserEncryption.decryptUserContents(inValue), User.class);
            return model;
        } catch (Exception ex) {
            LOG.severe("JSON Content Parsing Error : " + ex.getMessage());
            throw new RuntimeException();
        }
    }

    public static User fromXMLValue() {
        return null;
    }

}
