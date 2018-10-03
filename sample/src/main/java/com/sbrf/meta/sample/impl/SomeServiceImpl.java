package com.sbrf.meta.sample.impl;

import com.sbrf.meta.sample.api.SomeService;
import com.sbrf.meta.sample.dto.Person;
import com.sbrf.meta.sample.dto.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SomeServiceImpl implements SomeService {
    public Person getUser(Integer id) {
        throw new UnsupportedOperationException();
    }

    public List<User> getAll() {
        throw new UnsupportedOperationException();
    }

    public List<Class<? extends String>> saveUser(Integer id, User user) {
        throw new UnsupportedOperationException();
    }

    public void deleteUser(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<? extends String> generics(List<? extends User> list, List<Class<? extends User>> user, List<Set<Map<String, ? extends User>>> map) {
        throw new UnsupportedOperationException();
    }
}
