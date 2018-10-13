package com.stevenxy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stevenxy.entity.Student;

/**
* @author stevenxy E-mail:random_xy@163.com
* @Date 2018年10月11日
* @Description 
*/
public interface StudentDao extends JpaRepository<Student, Integer>{

}
