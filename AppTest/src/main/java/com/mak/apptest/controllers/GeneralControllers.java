package com.mak.apptest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralControllers {

	@GetMapping("/")
	public String home() {
        return ("<h1>Welcome !</h1>");
    }

	@GetMapping("/error")
	public String error() {
        return ("<h1>Error encountered Bro! </h1>");
    }

}
