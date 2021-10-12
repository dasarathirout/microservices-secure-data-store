package org.dasarathi.sds.one.controller.helper;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

public class OneHelper {
    public static final Logger LOG = Logger.getLogger(OneHelper.class.getName());

    private OneHelper() {
    }

    public static boolean checkFileTypeInRequest(String fileTypeInHeader,
                                                 String fileTypeInParameter) {
        LOG.info("checkFileTypeInRequest( " + fileTypeInHeader + " , " + fileTypeInParameter + " )");
        boolean isPresent = false;
        if (isFileType(fileTypeInHeader) ||
                isFileType(fileTypeInParameter)) {
            isPresent = true;
        }
        return isPresent;
    }

    private static boolean isFileType(String value) {
        if (value != null && !value.trim().isEmpty()) {
            return value.equalsIgnoreCase(FILETYPE.CSV.toString()) ||
                    value.equalsIgnoreCase(FILETYPE.XML.toString());
        } else {
            return false;
        }
    }
}

