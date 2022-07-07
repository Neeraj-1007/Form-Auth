package com.neoSoft.formBasedAuthentication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neoSoft.formBasedAuthentication.model.Project;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

	public Project findByProjid(long projid);

}
