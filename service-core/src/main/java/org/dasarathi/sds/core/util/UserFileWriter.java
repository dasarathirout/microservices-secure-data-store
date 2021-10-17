package org.dasarathi.sds.core.util;

import org.dasarathi.sds.core.data.MemoryDB;
import org.dasarathi.sds.core.model.User;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public final class UserFileWriter {
    private static final Logger LOG = Logger.getLogger(UserFileWriter.class.getName());
    private static final String CSV_LOCATION = "FDB" + File.separator + CORE.CSV + File.separator;
    private static final String JSON_LOCATION = "FDB" + File.separator + CORE.JSON + File.separator;
    private static final String XML_LOCATION = "FDB" + File.separator + CORE.JSON + File.separator;

    private UserFileWriter() {
    }

    public static void writeCSV(int userID, String csvModelValue) {

    }

    public static void write(int ID, String jsonModelValue) {

    }

    public static void writeJSON(int ID, String jsonModelValue) {
        LOG.info("Writing To " + new File(JSON_LOCATION + ID + CORE.JSON_EXT).getAbsolutePath());
        Path jsonFilePath = Paths.get(JSON_LOCATION + ID + CORE.JSON_EXT);
        try {
            BufferedWriter writer = Files.newBufferedWriter(jsonFilePath);
            writer.write(jsonModelValue);
            LOG.info(ID + " JSON  File Written To " + new File(JSON_LOCATION + ID + CORE.JSON_EXT).getAbsolutePath());
        } catch (Exception ex) {
            LOG.severe("User ID "+ID + " JSON File Written Failed");
            throw new RuntimeException();
        }
    }

    public static void writeXML(int userID, String xmlModelValue) {

    }

    public static int writeSaveUpdate(int userID, String fileType, String dataValue) {
        if (fileType.equalsIgnoreCase(CORE.CSV)) {
            writeCSV(userID, dataValue);
            return CORE.CSV_WRITE_SUCCESS;
        }
        if (fileType.equalsIgnoreCase(CORE.JSON)) {
            writeJSON(userID, dataValue);
            return CORE.JSON_WRITE_SUCCESS;
        }
        if (fileType.equalsIgnoreCase(CORE.XML)) {
            writeXML(userID, dataValue);
            return CORE.XML_WRITE_SUCCESS;
        }
        return CORE.STORE_WRITE_FAILED;
    }

}
