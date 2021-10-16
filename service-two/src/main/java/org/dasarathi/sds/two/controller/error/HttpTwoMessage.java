package org.dasarathi.sds.two.controller.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;

import java.io.IOException;
import java.io.InputStream;

public class HttpTwoMessage implements HttpInputMessage {

    private HttpHeaders httpHeaders;
    private InputStream inputStream;

    public HttpTwoMessage() {
        super();
        this.httpHeaders = HttpHeaders.EMPTY;
        this.inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };
    }

    public HttpTwoMessage(HttpHeaders httpHeaders, InputStream inputStream) {
        this();
        this.httpHeaders = httpHeaders;
        this.inputStream = inputStream;
    }

    @Override
    public HttpHeaders getHeaders() {
        return this.httpHeaders;
    }

    @Override
    public InputStream getBody() throws IOException {
        return this.inputStream;
    }
}
