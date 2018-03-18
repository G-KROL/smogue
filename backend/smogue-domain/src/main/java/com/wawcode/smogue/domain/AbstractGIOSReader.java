package com.wawcode.smogue.domain;

import com.wawcode.smogue.domain.persistence.repositories.CityRepository;
import com.wawcode.smogue.domain.persistence.repositories.MeasurementRepository;
import com.wawcode.smogue.domain.persistence.repositories.MeasurementTypeRepository;
import com.wawcode.smogue.domain.persistence.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public abstract class AbstractGIOSReader {

    @Autowired
    protected MeasurementTypeRepository measurementTypeRepository;

    @Autowired
    protected MeasurementRepository measurementRepository;

    @Autowired
    protected StationRepository stationRepository;

    @Autowired
    protected CityRepository cityRepository;

    @Transactional
    public abstract void read();
}
