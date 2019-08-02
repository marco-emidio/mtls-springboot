package com.plumstep.controller;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("client")
public class ClientController {
    @ApiOperation(value = "Return text message to show off successful call")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    ResponseEntity<?> getMessage() {
	return ResponseEntity.ok("Client successfully called!");
    }


    @Autowired
    private RestTemplate restTemplate;

    private String serverUrl = "https://nginx-aks-ingress.westeurope.cloudapp.azure.com/server/";
    //private String serverUrl = "https://localhost:8111/server/";
    //private String serverUrl = "https://192.168.188.101:8111/server/";

    @RequestMapping(value = "/server-message", method = RequestMethod.GET)
    @ApiOperation(value = "Return text message from server to show off successful call")
    public void getServerMessage() {
        System.out.println(restTemplate.getForEntity(serverUrl, String.class));
        
    }
}
