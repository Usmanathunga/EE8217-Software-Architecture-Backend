package com.example.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class SensorService {

    @Autowired SensorRepository sensorRepository;

     private JavaMailSender javaMailSender;

     public void sendEmail(String toEmail,
                           String subject,
                           String body){
         SimpleMailMessage message = new SimpleMailMessage();
         message.setFrom("udarasudeepa8@gmail.com");
         message.setTo(toEmail);
         message.setText(body);
         message.setText(body);
         message.setSubject(subject);

         javaMailSender.send(message);
         System.out.println("Maill Send successfully");

     }
     //add Sensor Value
    public Sensor addSensor(Sensor sensor){
         try{

         return sensorRepository.save(sensor);
         }catch (Exception e){
             return null;
         }
    }




    //get all sensor value
    public  List<Sensor> getAllValue(){
        return  sensorRepository.findAll();
    }

    //get sensor by id

    public Sensor getValueById(String id){
        Optional<Sensor> sensor = sensorRepository.findById(id);
        return sensor.orElse(null);

    }



}
