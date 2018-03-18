package com.wawcode.smogue.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class ReaderScheduler {

    private static final Logger log = LoggerFactory.getLogger(ReaderScheduler.class);

    private final ListableBeanFactory listableBeanFactory;

    @Autowired
    public ReaderScheduler(ListableBeanFactory listableBeanFactory) {
        this.listableBeanFactory = listableBeanFactory;
    }

    @CacheEvict(allEntries = true, value = "county")
    @Scheduled(cron = "0 */10 * * * *")
    public void read() {
        try {
            Map<String, AbstractGIOSReader> readers = listableBeanFactory.getBeansOfType(AbstractGIOSReader.class);

            readers.values().forEach(AbstractGIOSReader::read);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
