package com.sbrf.meta.sample.request;

import com.sbt.core.amqp.annotations.ApiRequest;
import com.sbrf.meta.sample.api.SomeService;

@ApiRequest(api = SomeService.class)
public interface SomeServiceRequest {
    void getUser(Integer id);
}
