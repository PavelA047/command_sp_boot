package com.example.command_sp_boot.exampleSoap;

import javax.jws.WebService;

@WebService(
        serviceName = "Hello",
        portName = "HelloPort",
        targetNamespace = "http://service.ws2.sample/",
        endpointInterface = "com.example.command_sp_boot.exampleSoap.HelloService"
)
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
