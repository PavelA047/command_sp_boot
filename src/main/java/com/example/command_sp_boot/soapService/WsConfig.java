package com.example.command_sp_boot.soapService;

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

    @Bean
    public Endpoint endpointCommandWs() {
        EndpointImpl endpoint = new EndpointImpl(bus, new CommandWsImpl());
        endpoint.publish("/CommandWs");
        return endpoint;
    }
}
