package com.sbrf.meta.sample.api;


import com.sbrf.meta.sample.dto.Person;
import com.sbrf.meta.sample.dto.User;
import com.sbt.core.amqp.annotations.Api;
import com.sbt.core.amqp.annotations.registry.ApiMethod;

import java.util.List;

@Api
public interface SomeService {
    @ApiMethod(apiName = "Получение пользователя", version = "2.4")
    Person getUser(Integer id);

    @ApiMethod(apiName = "Получение пользователей", version = "2.4")
    List<User> getAll();

    @ApiMethod(apiName = "Сохранение пользователя", version = "0.2")
    String saveUser(Integer id, User user);

    @ApiMethod(apiName = "Удаление пользователя", version = "0.2")
    void deleteUser(Integer id);


}
