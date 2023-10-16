package com.sqlrest.app.service;

import com.sqlrest.app.repository.RepositoryAsientosTarj;
import com.sqlrest.app.request.RequestAsientosTarj;
import com.sqlrest.app.response.ResponseAsientosTarj;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class ServiceAsientosTarj {

    private final JdbcTemplate jdbcTemplate;
    private RepositoryAsientosTarj repositoryAsientosTarj;


    public ServiceAsientosTarj(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public ResponseAsientosTarj processRequest(RequestAsientosTarj request) {
        return repositoryAsientosTarj.executeProcedure(request);
    }
}
