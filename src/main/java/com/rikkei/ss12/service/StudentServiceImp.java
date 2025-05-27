package com.rikkei.ss12.service;

import com.rikkei.ss12.model.Student;
import com.rikkei.ss12.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> find_all() {
        return studentDao.find_all();
    }

    @Override
    public Student find_ById(int id) {
        return studentDao.find_ById(id);
    }

    @Override
    public boolean save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public boolean update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public boolean delete(int id) {
        return  studentDao.delete(id);
    }
}
