package com.example.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class AssignmentApplication {
	//@Autowired
	//private SensorService sensorService;

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

	//@EventListener(ApplicationReadyEvent.class)
	//public void sendEmail(){
	//	sensorService.sendEmail("usmredhood@gmail.com","Sensor Value","Sensor value is50");

	//}

}
