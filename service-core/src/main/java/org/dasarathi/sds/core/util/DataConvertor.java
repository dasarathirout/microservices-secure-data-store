package org.dasarathi.sds.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.dasarathi.sds.core.encrypt.UserEncryption;
import org.dasarathi.sds.core.model.User;

import java.util.logging.Logger;

public class DataConvertor {
    private static final Logger LOG = Logger.getLogger(DataConvertor.class.getName());
    private static final ObjectMapper mapper = new ObjectMapper();

    public static User fromCSVValue() {
        User model;
        return null;
    }

    public static User fromJSONValue(String inValue) {
        User model;
        try {
            LOG.info("Starting JSON String To Obj ...");
            model = mapper.readValue(inValue, User.class);
            LOG.info("After JSON Parsed Model : " + model);
            return model;
        } catch (Exception ex) {
            LOG.severe("JSON Content Parsing Error : " + ex.getMessage());
            throw new RuntimeException();
        }
    }

    public static User fromXMLValue(String inValue) {
        User model;
        try {
            LOG.info("Starting XML String To Obj ...");
            model = mapper.readValue(inValue, User.class);
            return model;
        } catch (Exception ex) {
            LOG.severe("JSON Content Parsing Error : " + ex.getMessage());
            throw new RuntimeException();
        }
    }

}
