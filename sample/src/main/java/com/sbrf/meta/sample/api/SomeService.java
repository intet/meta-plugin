package com.sbrf.meta.sample.api;


import com.sbrf.meta.sample.dto.Person;
import com.sbrf.meta.sample.dto.User;
import com.sbt.core.amqp.annotations.Api;
import com.sbt.core.amqp.annotations.registry.ApiMethod;

import java.util.List;

@Api
/**
 * Пример простого сервиса
 */
public interface SomeService {
    /**
     * Получения пользователя по ID
     *
     * @param id - пользователя
     * @return Пользователь
     */
    @ApiMethod(apiName = "Получение пользователя", version = "2.4")
    Person getUser(Integer id);

    /**
     * Получение пользователей
     *
     * @return List
     */
    @ApiMethod(apiName = "Получение пользователей", version = "2.4")
    List<User> getAll();

    /**
     * Сохранение пользователей
     * @param id Пользователя
     * @param user объект
     * @return ничего
     */
    @ApiMethod(apiName = "Сохранение пользователя", version = "0.2")
    String saveUser(Integer id, User user);

    /**
     * Удаление пользователей
     * @param id ничего
     */
    @ApiMethod(apiName = "Удаление пользователя", version = "0.2")
    void deleteUser(Integer id);


}
