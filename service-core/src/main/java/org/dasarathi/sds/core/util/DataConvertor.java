package org.dasarathi.sds.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dasarathi.sds.core.encrypt.UserEncryption;
import org.dasarathi.sds.core.model.User;

public class DataConvertor {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static User fromCSVValue() {
        return null;
    }

    public static User fromJSONValue(String inValue) {
        UserEncryption.decryptUserContents(inValue);
        try {
            User model = mapper.readValue(UserEncryption.decryptUserContents(inValue), User.class);
            return model;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static User fromXMLValue() {
        return null;
    }

}
