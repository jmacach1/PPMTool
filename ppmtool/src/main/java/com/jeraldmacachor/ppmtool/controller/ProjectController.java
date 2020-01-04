package com.jeraldmacachor.ppmtool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeraldmacachor.ppmtool.domain.Project;
import com.jeraldmacachor.ppmtool.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@PostMapping("")
	public ResponseEntity<Project> createNewProject(
			@RequestBody Project project) {
		/* ResponseEntity - allows us to have more control on
		json responses - status, json objects */
		
		projectService.saveOrUpdateProject(project);
		
		return new ResponseEntity<Project>(project, HttpStatus.CREATED);
	}
	

}
