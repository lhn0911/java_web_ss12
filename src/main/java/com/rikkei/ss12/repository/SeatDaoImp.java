package com.rikkei.ss12.repository;

import com.rikkei.ss12.model.Seat;
import com.rikkei.ss12.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SeatDaoImp implements SeatDao {

    @Override
    public List<Seat> findByBusId(int busId) {
        List<Seat> seats = new ArrayList<>();
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_seat_by_bus_id(?)}");
            callSt.setInt(1, busId);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Seat seat = new Seat();
                seat.setId(rs.getInt("id"));
                seat.setNameSeat(rs.getString("name_seat"));
                seat.setPrice(rs.getBigDecimal("price"));
                seat.setBusId(rs.getInt("bus_id"));
                seat.setStatus(rs.getString("status"));
                seats.add(seat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }

        return seats;
    }

    @Override
    public boolean save(Seat seat) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call save_seat(?,?,?,?)}");
            callSt.setString(1, seat.getNameSeat());
            callSt.setBigDecimal(2, seat.getPrice());
            callSt.setInt(3, seat.getBusId());
            callSt.setString(4, seat.getStatus());
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
    public boolean update(Seat seat) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_seat(?,?,?,?,?)}");
            callSt.setInt(1, seat.getId());
            callSt.setString(2, seat.getNameSeat());
            callSt.setBigDecimal(3, seat.getPrice());
            callSt.setInt(4, seat.getBusId());
            callSt.setString(5, seat.getStatus());
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
    public boolean deleteByBusId(int busId) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_seat_by_bus_id(?)}");
            callSt.setInt(1, busId);
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
