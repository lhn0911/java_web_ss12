package com.rikkei.ss12.repository;

import com.rikkei.ss12.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> find_all();
    Student find_ById(int id);
    boolean save(Student student);
    boolean update(Student student);
    boolean delete(int  id);
}
