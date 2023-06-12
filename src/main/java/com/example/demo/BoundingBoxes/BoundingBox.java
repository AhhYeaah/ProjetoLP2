package com.example.demo.BoundingBoxes;

import com.example.demo.utils.Cordinates;

public class BoundingBox {
	Float minLat;
	Float minLon;

	Float maxLat;
	Float maxLon;

	public BoundingBox(Float minLat, Float minLon, Float maxLat, Float maxLon) {
		super();
		this.minLat = minLat;
		this.minLon = minLon;
		this.maxLat = maxLat;
		this.maxLon = maxLon;
	}

	private boolean isInsideLat(Float latitude) {
		return (latitude >= minLat) && (latitude <= maxLat);
	}

	private boolean isInsideLon(Float longitude) {
		return (longitude >= minLon) && (longitude <= maxLon);
	}

	public boolean isInsideMe(Cordinates point) {
		return isInsideLat(point.getLatitude()) && isInsideLon(point.getLongitude());
	}
}
