package br.com.flexpag.payments.util;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class UriBuilder {

    public static URI buildUri(UriComponentsBuilder uriComponentsBuilder, String path, Long returnId) {
        return uriComponentsBuilder.path(path)
                .buildAndExpand(returnId)
                .toUri();
    }

}
