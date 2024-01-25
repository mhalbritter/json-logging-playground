package com.example.jsonloggingecs;

import java.util.List;

import ch.qos.logback.classic.spi.ILoggingEvent;
import co.elastic.logging.JsonUtils;
import co.elastic.logging.logback.EcsEncoder;
import org.slf4j.event.KeyValuePair;

import static co.elastic.logging.EcsJsonSerializer.toNullSafeString;

/**
 * @author Moritz Halbritter
 */
public class KeyValuePairEcsEncoder extends EcsEncoder {
    @Override
    protected void addCustomFields(ILoggingEvent event, StringBuilder builder) {
        List<KeyValuePair> keyValuePairs = event.getKeyValuePairs();
        if (keyValuePairs == null || keyValuePairs.isEmpty()) {
            return;
        }
        for (KeyValuePair keyValuePair : keyValuePairs) {
            builder.append('\"');
            JsonUtils.quoteAsString(keyValuePair.key, builder);
            builder.append("\":\"");
            JsonUtils.quoteAsString(toNullSafeString(String.valueOf(keyValuePair.value)), builder);
            builder.append("\",");
        }
    }
}
