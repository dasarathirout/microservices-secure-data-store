package org.dasarathi.sds.core.util;

public interface CORE {

    String EMPTY= "";

    String CSV = "CSV";
    String JSON = "JSON";
    String XML = "XML";

    String CSV_EXT = ".csv";
    String JSON_EXT = ".json";
    String XML_EXT = ".xml";

    int CSV_WRITE_SUCCESS = 100;
    int JSON_WRITE_SUCCESS = 200;
    int XML_WRITE_SUCCESS = 300;
    int STORE_WRITE_FAILED = 400;

    int CSV_PARSE_SUCCESS = 500;
    int JSON_PARSE_SUCCESS = 600;
    int XML_PARSE_SUCCESS = 700;
    int STORE_PARSE_FAILED = 800;

    int GRPC_PORT = 50505;
    String GRPC_HOSTNAME = "localhost";

    int GRPC_CLIENT_RUN = 900;
    int GRPC_CLIENT_UPDATE = 1000;

}
