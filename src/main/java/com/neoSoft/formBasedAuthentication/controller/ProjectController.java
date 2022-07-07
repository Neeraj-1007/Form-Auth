package com.neoSoft.formBasedAuthentication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neoSoft.formBasedAuthentication.model.Project;
import com.neoSoft.formBasedAuthentication.model.Student;
import com.neoSoft.formBasedAuthentication.service.ProjectService;



@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

	
	@Autowired
	private ProjectService projectService;

	@PostMapping("/save")
	public long save(@RequestBody Project project) {
		long pk = projectService.save(project);
		return pk;
	}

	@GetMapping("/getStudentList")
	public List<Student> getList() {
		List list = new ArrayList<>();
		list = projectService.getList();
		return list;
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		projectService.delete(id);
		return "Successfully Deleted";
	}
}
