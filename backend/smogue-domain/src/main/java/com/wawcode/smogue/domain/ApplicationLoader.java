package com.wawcode.smogue.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationLoader implements CommandLineRunner {

    @Autowired
    private Configurator configurator;

    @Autowired
    private ReaderScheduler readerScheduler;

    @Override
    public void run(String... strings) throws Exception {
        configurator.configure();
        readerScheduler.read();
        configurator.assignKnownStations();
    }


}
