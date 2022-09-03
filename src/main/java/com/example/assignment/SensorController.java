package com.example.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SensorController {

    @Autowired SensorService sensorService;

    @GetMapping
    public ResponseEntity<List<Sensor>> getAllValue(){
        List<Sensor> sensors = sensorService.getAllValue();
        if(sensors == null || sensors.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(sensors, HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Sensor> getValueById(@PathVariable("id")String sensorId){
        Sensor sensor = sensorService.getValueById(sensorId);
        if(sensor == null ){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(sensor, HttpStatus.OK);
        }

    }

    @PostMapping
    public ResponseEntity<Sensor> getValueById(@RequestBody Sensor sensor){
        Sensor createdValue =  sensorService.addSensor(sensor);
        if(createdValue == null ){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }else {
            return new ResponseEntity<>(createdValue, HttpStatus.CREATED);
        }

    }


}
