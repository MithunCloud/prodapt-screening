package com.example.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/remove")
    public ResponseEntity<String> removeFirstAndLast(@RequestParam("str") String input){
        if (input==null || input.length()<2){
            return  ResponseEntity.badRequest().build();
        }
        if (input.length()==2){
            return ResponseEntity.ok("");
        }
        String modified = input.substring(1,input.length() -1);
        return ResponseEntity.ok(modified);
    }



}
