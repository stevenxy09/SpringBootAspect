package com.stevenxy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stevenxy.dao.StudentDao;
import com.stevenxy.entity.Student;
import com.stevenxy.service.StudentService;

/**
* @author stevenxy E-mail:random_xy@163.com
* @Date 2018年10月11日
* @Description 
*/
@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	@Resource
	private StudentDao studentDao;
	
	@Override
	public void add(Student student) {
		studentDao.save(student);
		
	}

}
