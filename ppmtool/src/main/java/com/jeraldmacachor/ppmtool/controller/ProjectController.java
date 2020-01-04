package com.jeraldmacachor.ppmtool.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
	public ResponseEntity<?> createNewProject(
			@Valid @RequestBody Project project,
			BindingResult result) {
		/* ResponseEntity - allows us to have more control on
		json responses - status, json objects */
		
		if (result.hasErrors()) {
			return new ResponseEntity<String>("Invalid Project Object", 
					HttpStatus.BAD_REQUEST);
		}
		projectService.saveOrUpdateProject(project);
		
		return new ResponseEntity<Project>(project, HttpStatus.CREATED);
	}
	

}
