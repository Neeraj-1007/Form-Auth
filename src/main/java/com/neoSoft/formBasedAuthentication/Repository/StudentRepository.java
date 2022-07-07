package com.neoSoft.formBasedAuthentication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neoSoft.formBasedAuthentication.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	public Student findById(long id);
}
