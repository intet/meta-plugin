package com.sbrf.meta.sample.request;

import com.sbrf.meta.sample.api.SomeService;
import com.sbt.core.amqp.annotations.ApiRequest;

@ApiRequest(api = SomeService.class)
public interface SomeServiceRequest {
    void getUser(Integer id);
}
