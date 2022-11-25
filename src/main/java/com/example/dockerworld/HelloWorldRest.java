package com.example.dockerworld;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldRest {

	@GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String helloWorld() {
		return toJson("Hello World!");
	}

	@GetMapping(value="/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String helloPersonal(@PathVariable String name) {
		return toJson(String.format("Hello %s!", name));
	}

	public String toJson(String message) {
		return String.format("{\"message\":\"%s\"}", message);
	}
}
