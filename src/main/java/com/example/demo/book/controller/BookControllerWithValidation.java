package com.example.demo.book.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class BookControllerWithValidation {
	private static final String VALIDATION_REGEX = "^[0-9]+$";

	/**
	 * http://localhost:8080/getWithValidation
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping("/getWithValidation")
	private String get(@RequestParam(value = "id", required = true) String id) {
		return "Validated ok";
	}

	/**
	 * http://localhost:8080/getWithValidation2?id=4
	 * 
	 * @param id
	 * @param idNumber
	 * @return
	 */
	@GetMapping("/getOnlyNumber")
	public String getById(@RequestParam("id") String id,
			@Valid @Pattern(regexp = VALIDATION_REGEX) @RequestParam(value = "id", required = true) String idNumber) {
		return "Validated ok , we have number=" + id;
	}

	/**
	 * http://localhost:8080/validateObject
	 * {
			"title" : "",
			"notBlank" : "s"
		}
	 * @param message
	 * @return
	 */
    @PostMapping("/validateObject")
    public String validateObject(@Valid @RequestBody ObjectToValidate message) {
    	return "OK!";
    }
	
}

class ObjectToValidate {
	@NotNull
	private String title;
	@NotBlank
	private String notBlank;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNotBlank() {
		return notBlank;
	}

	public void setNotBlank(String notBlank) {
		this.notBlank = notBlank;
	}
}