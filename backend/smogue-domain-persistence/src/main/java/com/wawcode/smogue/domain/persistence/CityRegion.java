package com.wawcode.smogue.domain.persistence;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue(RegionType.Values.CITY)
public class CityRegion extends Region {

	@OneToMany(mappedBy = "city")
	private Set<Station> stations = new HashSet<>();

	public Set<Station> getStations() {
		return stations;
	}

	public void setStations(Set<Station> stations) {
		this.stations = stations;
	}
}

