package com.sbrf.meta.sample.impl;

import com.sbrf.meta.sample.api.SomeService;
import com.sbrf.meta.sample.dto.User;

public class SomeServiceImpl implements SomeService {
    public User getUser(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String saveUser(Integer id, User user) {
        throw new UnsupportedOperationException();
    }
}
