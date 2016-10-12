package ru.mail.park.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by kirrok on 12.10.16.
 */
public abstract class BaseDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

}
