package com.apress.springrecipes.court.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.apress.springrecipes.court.dao.VehicleDao;
import com.apress.springrecipes.court.domain.Vehicle;

public class JdbcVehicleDao implements VehicleDao
{
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource)
	{
		System.out.println("####### setting dataSource");
		this.dataSource = dataSource;
		System.out.println("Done setting dataSource: " + this.dataSource);
	}
	
	@Override
	public void insert(Vehicle vehicle) 
	{
		String sql = "INSERT INTO VEHICLE (vehicle_no, color, wheel, seat) VALUES (?, ?, ?, ?)";
		System.out.println("SQL: " + sql);
		
		Connection conn = null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vehicle.getVehicleNo());
			ps.setString(2, vehicle.getColor());
			ps.setInt(3, vehicle.getWheel());
			ps.setInt(4, vehicle.getSeat());
			ps.executeUpdate();
			ps.close();
		}
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			if (conn != null)
			{
				try
				{
					conn.close();
				}
				catch (SQLException e)
				{
				}
			}
		}
	}

	@Override
	public void update(Vehicle vehicle) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Vehicle vehicle) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vehicle findByVehicleNo(String vehicleNo) 
	{
		// TODO Auto-generated method stub
		return null;
	}
}