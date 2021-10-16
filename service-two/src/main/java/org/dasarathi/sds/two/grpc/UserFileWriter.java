package org.dasarathi.sds.two.grpc;

import org.dasarathi.sds.core.model.User;
import org.dasarathi.sds.core.util.CORE;
import org.dasarathi.sds.core.util.DataConvertor;
import org.dasarathi.sds.two.data.MemoryDB;

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

    public static void writeCSV(String csvModelValue) {


    }

    public static void writeJSON(int ID, String jsonModelValue) {

        Path jsonFilePath = Paths.get(JSON_LOCATION + ID + CORE.JSON_EXT);
        try {
            BufferedWriter writer = Files.newBufferedWriter(jsonFilePath);
            writer.write(jsonModelValue);
            LOG.info(ID + " CSV File Written To " + new File(JSON_LOCATION + ID + CORE.JSON_EXT).getAbsolutePath());
        } catch (Exception ex) {
            throw new RuntimeException(ID + " CSV File Written Failed");
        }
    }

    public static void writeXML(String xmlModelValue) {

    }

    public static int saveUpdate(String encryptedValue, String fileType) {
        if (fileType.equalsIgnoreCase(CORE.CSV)) {
            return CORE.CSV_SUCCESS;
        }
        if (fileType.equalsIgnoreCase(CORE.JSON)) {
            User model = DataConvertor.fromEncryptedJSONValue(encryptedValue);
            MemoryDB.addContents(model);
            return CORE.JSON_SUCCESS;
        }
        if (fileType.equalsIgnoreCase(CORE.XML)) {
            return CORE.XML_SUCCESS;

        }
        return CORE.STORE_FAILED;
    }

}
