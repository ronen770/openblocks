package com.openblocks.infra.js;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.openblocks.sdk.config.CommonConfig;

@Component
public class NodeServerHelper {

    private static final String PREFIX = "node-service/api";

    @Autowired
    private CommonConfig commonConfig;

    public URI createUri(String path) {
        if (path.startsWith("/")) {
            path = path.substring(1);
        }
        if (path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }
        return UriComponentsBuilder.fromUriString(commonConfig.getJsExecutor().getHost())
                .pathSegment(PREFIX, path)
                .build()
                .toUri();
    }
}
