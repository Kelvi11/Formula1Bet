package com.sporty.formula1bet.rest.utils;

import org.springframework.web.util.UriBuilder;

import java.util.Map;
import java.util.Optional;

public class UriUtils {
    public static UriBuilder addQueryParams(UriBuilder builder, Map<String, ?> params) {
        params.forEach((key, value) ->
                Optional.ofNullable(value)
                        .ifPresent(v -> builder.queryParam(key, v))
        );
        return builder;
    }
}
