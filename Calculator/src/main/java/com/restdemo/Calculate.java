package com.restdemo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculate {
	
	@Autowired
	CalculateOperation operation;
	
	@GetMapping("/{operation}/{number}")
	public String calculate(@PathVariable("number") List<String> number,@PathVariable("operation") String action) {
		try {
			List<Double> numberList = number.stream().map(s -> Double.parseDouble(s)).collect(Collectors.toList());
			return !number.isEmpty() ? String.valueOf(operation.calculate(numberList,action)) : "please enter number";
		
		}catch(NumberFormatException e){
			System.out.println(e + "Please enter only number");
			return "Please enter only number";
		}
	}
}