package com.rikkei.ss12.service;

import com.rikkei.ss12.model.Seat;
import com.rikkei.ss12.repository.SeatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeatServiceImp implements SeatService {
    @Autowired
    private SeatDao seatDao;
    @Override
    public List<Seat> findByBusId(int busId) {
        return seatDao.findByBusId(busId);
    }

    @Override
    public boolean save(Seat seat) {
        return seatDao.save(seat);
    }

    @Override
    public boolean update(Seat seat) {
        return seatDao.update(seat);
    }

    @Override
    public boolean deleteByBusId(int busId) {
        return seatDao.deleteByBusId(busId);
    }
}
