package com.example.command_sp_boot;

import com.example.command_sp_boot.exampleSoap.HelloServiceImpl;
import com.example.command_sp_boot.soapService.CommandWs;
import org.apache.cxf.Bus;

import javax.xml.ws.Endpoint;

import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WsConfig {

    @Autowired
    private Bus bus;

    @Autowired
    private CommandWs commandWs;

    @Bean
    public Endpoint endpointCommandWs() {
        EndpointImpl endpoint = new EndpointImpl(bus, commandWs);
        endpoint.publish("/CommandWs");
        return endpoint;
    }

    @Bean
    public Endpoint helloEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new HelloServiceImpl());
        endpoint.publish("/ServiceHello");
        return endpoint;
    }
}
