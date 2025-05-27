package com.rikkei.ss12.service;

import com.rikkei.ss12.model.Bus;
import com.rikkei.ss12.repository.BusDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BusServiceImp implements BusService{
    @Autowired
    private BusDaoImp busDao;
    @Override
    public List<Bus> findAll() {
        return busDao.findAll();
    }

    @Override
    public Bus findById(int id) {
        return busDao.findById(id);
    }

    @Override
    public boolean save(Bus bus) {
        return busDao.save(bus);
    }

    @Override
    public boolean update(Bus bus) {
        return busDao.update(bus);
    }

    @Override
    public boolean delete(int id) {
        return busDao.delete(id);
    }
}
