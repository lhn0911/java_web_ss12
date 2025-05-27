package com.rikkei.ss12.repository;

import com.rikkei.ss12.model.Seat;

import java.util.List;

public interface SeatDao {
    List<Seat> findByBusId(int busId);
    boolean save(Seat seat);
    boolean update(Seat seat);
    boolean deleteByBusId(int busId);
}
