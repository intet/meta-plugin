package com.sbrf.meta.sample.api;


import com.sbrf.meta.sample.dto.User;
import com.sbt.core.amqp.annotations.Api;
import com.sbt.core.amqp.annotations.registry.ApiMethod;

@Api
public interface SomeService {
    @ApiMethod(apiName = "Получение пользователя", version = "2.4")
    User getUser(Integer id);

    @ApiMethod(apiName = "Сохранение пользователя", version = "0.2")
    String saveUser(Integer id, User user);
}
