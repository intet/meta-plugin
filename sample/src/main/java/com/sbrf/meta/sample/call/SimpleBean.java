package com.sbrf.meta.sample.call;

import com.sbrf.meta.sample.request.SomeServiceRequest;

public class SimpleBean {
    private SomeServiceRequest serviceRequest;


    public void testCall(){
        System.out.println("test!!!");
        serviceRequest.getUser(3);
    }

    public void testCallFunction(){
        testCall();
    }
}
