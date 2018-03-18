package com.wawcode.smogue.domain.persistence.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue(RegionType.Values.COUNTY)
public class CountyRegion extends Region {

	public Set<CityRegion> getCities() {
		return new HashSet<CityRegion>();
	}
}
