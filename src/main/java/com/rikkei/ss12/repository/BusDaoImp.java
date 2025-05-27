package com.rikkei.ss12.repository;

import com.rikkei.ss12.model.Bus;
import com.rikkei.ss12.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BusDaoImp implements BusDao {

    @Override
    public List<Bus> findAll() {
        List<Bus> buses = new ArrayList<>();
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_bus()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Bus bus = new Bus();
                bus.setId(rs.getInt("id"));
                bus.setLicensePlate(rs.getString("license_plate"));
                bus.setBusType(rs.getString("bus_type"));
                bus.setRowSeat(rs.getInt("row_seat"));
                bus.setColSeat(rs.getInt("col_seat"));
                bus.setTotalSeat(rs.getInt("total_seat"));
                bus.setImage(rs.getString("image"));
                buses.add(bus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return buses;
    }

    @Override
    public Bus findById(int id) {
        Bus bus = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_bus_by_id(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                bus = new Bus();
                bus.setId(rs.getInt("id"));
                bus.setLicensePlate(rs.getString("license_plate"));
                bus.setBusType(rs.getString("bus_type"));
                bus.setRowSeat(rs.getInt("row_seat"));
                bus.setColSeat(rs.getInt("col_seat"));
                bus.setTotalSeat(rs.getInt("total_seat"));
                bus.setImage(rs.getString("image"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return bus;
    }

    @Override
    public boolean save(Bus bus) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call save_bus(?,?,?,?,?,?)}");
            callSt.setString(1, bus.getLicensePlate());
            callSt.setString(2, bus.getBusType());
            callSt.setInt(3, bus.getRowSeat());
            callSt.setInt(4, bus.getColSeat());
            callSt.setInt(5, bus.getTotalSeat());
            callSt.setString(6, bus.getImage());
            callSt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean update(Bus bus) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_bus(?,?,?,?,?,?,?)}");
            callSt.setInt(1, bus.getId());
            callSt.setString(2, bus.getLicensePlate());
            callSt.setString(3, bus.getBusType());
            callSt.setInt(4, bus.getRowSeat());
            callSt.setInt(5, bus.getColSeat());
            callSt.setInt(6, bus.getTotalSeat());
            callSt.setString(7, bus.getImage());
            callSt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_bus(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }
}
