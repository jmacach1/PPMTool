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
import com.jeraldmacachor.ppmtool.service.MapValidationErrorService;
import com.jeraldmacachor.ppmtool.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private MapValidationErrorService validationService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewProject(
			@Valid @RequestBody Project project,
			BindingResult result) {

		ResponseEntity<?> errorMap = validationService.MapValidationService(result);
		if (errorMap != null) return errorMap;
		
		projectService.saveOrUpdateProject(project);
		return new ResponseEntity<Project>(project, HttpStatus.CREATED);
	}
	

}
