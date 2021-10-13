package org.dasarathi.sds.one.controller.helper;

import org.springframework.web.bind.MissingServletRequestParameterException;

import java.util.logging.Logger;

public class OneHelper {
    public static final Logger LOG = Logger.getLogger(OneHelper.class.getName());

    private OneHelper() {
    }

    public static void checkFileTypeInRequest(String fileTypeInHeader,
                                              String fileTypeInParameter) throws MissingServletRequestParameterException {
        LOG.info("checkFileTypeInRequest( " + fileTypeInHeader + " , " + fileTypeInParameter + " )");
        boolean hasValidFileType = isFileType(fileTypeInHeader) || isFileType(fileTypeInParameter);
        if (!hasValidFileType) {
            throw new MissingServletRequestParameterException("fileType", "CSV / XML");
        }
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

