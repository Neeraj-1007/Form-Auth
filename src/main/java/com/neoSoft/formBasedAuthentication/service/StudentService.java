package com.neoSoft.formBasedAuthentication.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoSoft.formBasedAuthentication.Repository.StudentRepository;
import com.neoSoft.formBasedAuthentication.model.Student;


@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional
	public Long save(Student student) {
		Student student1=studentRepository.save(student);
		return student1.getId();
	}
	
	@Transactional
	public void delete(long id) {
		Student student=studentRepository.findById(id);
		studentRepository.delete(student);
	}
	
	@Transactional
	public List<Student> getList(){
		List list=new ArrayList<>();
		list=studentRepository.findAll();
		return list;
	}
}
