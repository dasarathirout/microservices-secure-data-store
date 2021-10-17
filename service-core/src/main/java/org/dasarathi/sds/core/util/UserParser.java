package org.dasarathi.sds.core.util;

import org.dasarathi.sds.core.encrypt.UserEncryption;
import org.dasarathi.sds.core.model.User;

import java.util.logging.Logger;

public class UserParser {

    private static final Logger LOG = Logger.getLogger(UserParser.class.getName());

    public static User parse(int userID, String fileType, String rawUserData) {
        fileType= fileType.toUpperCase();
        String userValues = UserEncryption.decryptUserContents(rawUserData);
        User parsedUser = null;
        try {
            if (fileType.equalsIgnoreCase(CORE.CSV)) {
                LOG.info("CORE.CSV_PARSE_SUCCESS : " + CORE.CSV_PARSE_SUCCESS);
            }
            if (fileType.equalsIgnoreCase(CORE.JSON)) {
                parsedUser = DataConvertor.fromJSONValue(userValues);
                LOG.info("CORE.JSON_PARSE_SUCCESS : " + CORE.JSON_PARSE_SUCCESS);
            }
            if (fileType.equalsIgnoreCase(CORE.XML)) {
                LOG.info("CORE.XML_PARSE_SUCCESS : " + CORE.XML_PARSE_SUCCESS);
            }
            return parsedUser;
        } catch (Exception ex) {
            LOG.info("CORE.STORE_PARSE_FAILED : " + CORE.STORE_PARSE_FAILED);
        }
        return parsedUser;
    }
}
