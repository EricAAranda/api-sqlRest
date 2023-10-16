package com.sqlrest.app.controller;

import com.sqlrest.app.repository.RepositoryAsientosTarj;
import com.sqlrest.app.request.RequestAsientosTarj;
import com.sqlrest.app.response.ResponseAsientosTarj;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAsientosTarj {

    @PostMapping("/asientosTarjetas")
    public ResponseAsientosTarj asientosTarjetas(@RequestBody RequestAsientosTarj request) {

        RepositoryAsientosTarj repositoryAsientosTarj= new RepositoryAsientosTarj();
        return repositoryAsientosTarj.executeProcedure(request);

    }
}
