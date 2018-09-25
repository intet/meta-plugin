package com.sbrf.meta.sample.impl;

import com.sbrf.meta.sample.api.SomeService;
import com.sbrf.meta.sample.dto.Person;
import com.sbrf.meta.sample.dto.User;

import java.util.List;

public class SomeServiceImpl implements SomeService {
    public Person getUser(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String saveUser(Integer id, User user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUser(Integer id) {
        throw new UnsupportedOperationException();
    }
}
