package com.programming.spring.SpringMVCUsingSpringBoot.service;

import com.programming.spring.SpringMVCUsingSpringBoot.aspect.Loggable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeService {

    private static  final DateTimeFormatter formatter24 = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static  final DateTimeFormatter formatter12 = DateTimeFormatter.ofPattern("HH:mm:ss a");

    @Value("true")
    private boolean is24;

    public TimeService(){
        super();
    }

    @Loggable
    public String getCurrentTime(){
        LocalDateTime currentTime = LocalDateTime.now();
        if(is24){
            return formatter24.format(currentTime);
        }
        return formatter12.format(currentTime);
    }
}
