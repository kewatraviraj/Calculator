package com.restdemo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CalculateOperation {

	public Double calculate(List<Double> numberList, String action) {
		
		if("add".equals(action)) {
			return numberList.stream().mapToDouble(Double::doubleValue).sum();			
		}else if("sub".equals(action)) {
			return numberList.stream().reduce(2*numberList.get(0),(a,b) -> a-b);
		}else if("multiply".equals(action)) {
			return numberList.stream().reduce(1.0,(a,b) -> a*b);	
		}else if("divide".equals(action)) {
			return numberList.stream().reduce(Math.pow(numberList.get(0),2),(a,b) -> a/b);	
		}else {
			return null;
		}
	}

}
