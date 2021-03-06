package com.sbrf.meta.sample.api;


import com.sbrf.meta.sample.dto.Person;
import com.sbrf.meta.sample.dto.TypeUser;
import com.sbrf.meta.sample.dto.User;
import com.sbt.core.amqp.annotations.Api;
import com.sbt.core.amqp.annotations.registry.ApiMethod;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
    Person getUser(Integer id) throws RuntimeException;
    /**
     * Получение пользователей
     *
     * @return List
     */
    @ApiMethod(apiName = "Получение пользователей", version = "2.4")
    List<User> getAll(TypeUser type);
    /**
     * Сохранение пользователей
     *
     * @param id   Пользователя
     * @param user объект
     * @return ничего
     */
    @ApiMethod(apiName = "Сохранение пользователя", version = "0.2")
    List<Class<? extends String>> saveUser(Integer id, User user);
    /**
     * Удаление пользователей
     * @param id ничего
     */
    @ApiMethod(apiName = "Удаление пользователя", version = "0.2")
    void deleteUser(Integer id);

    @ApiMethod(apiName = "generics", version = "0.2")
    List<? extends String> generics(List<? extends User> list, List<Class<? extends User>> user, List<Set<Map<String, ? extends User>>> map);
}
