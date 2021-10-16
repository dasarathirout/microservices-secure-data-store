package org.dasarathi.sds.one.controller.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;

import java.io.IOException;
import java.io.InputStream;

public class HttpUserMessage implements HttpInputMessage {

    private HttpHeaders httpHeaders;
    private InputStream inputStream;

    public HttpUserMessage() {
        super();
        this.httpHeaders = HttpHeaders.EMPTY;
        this.inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };
    }

    public HttpUserMessage(HttpHeaders httpHeaders, InputStream inputStream) {
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
