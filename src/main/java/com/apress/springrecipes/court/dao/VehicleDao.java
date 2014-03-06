package com.apress.springrecipes.court.dao;

import com.apress.springrecipes.court.domain.Vehicle;

public interface VehicleDao 
{
	public void insert(Vehicle vehicle);
	public void update(Vehicle vehicle);
	public void delete(Vehicle vehicle);
	public Vehicle findByVehicleNo(String vehicleNo);
}