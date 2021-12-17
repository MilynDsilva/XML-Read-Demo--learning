package com.toreadxmlfile.learning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;


import java.util.List;

public class LoggingItem implements ItemWriter<SomeDTO>{

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingItem.class);

    @Override
    public void write(List<? extends SomeDTO> list) throws Exception {
        LOGGER.info("Writing data: {}", list);
    }
}
