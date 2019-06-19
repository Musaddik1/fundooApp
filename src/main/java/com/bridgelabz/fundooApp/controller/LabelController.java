package com.bridgelabz.fundooApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundooApp.dto.LabelDto;
import com.bridgelabz.fundooApp.response.Response;
import com.bridgelabz.fundooApp.service.LabelService;

@RestController
@RequestMapping("/Label")
public class LabelController {

	@Autowired
	private LabelService labelService;

	@PostMapping("/create")
	public ResponseEntity<Response> createLabel(@RequestParam String token, @RequestBody LabelDto labelDto) {
		Response response = labelService.createLabel(token, labelDto);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Response> updateLabel(@RequestParam String token, @RequestParam String labelId,
			@RequestBody LabelDto labelDto) {
		Response response=labelService.updateLabel(token, labelId, labelDto);
		return new ResponseEntity<Response>(response,HttpStatus.OK);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<Response> deleteLable(@RequestParam String token, @RequestParam String labelId) {

		Response response=labelService.deleteLabel(token, labelId);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}

}
