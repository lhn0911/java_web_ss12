package com.rikkei.ss12.repository;

import com.rikkei.ss12.model.Bus;

import java.util.List;

public interface BusDao {
    List<Bus> findAll();
    Bus findById(int id);
    boolean save(Bus bus);
    boolean update(Bus bus);
    boolean delete(int id);
}
