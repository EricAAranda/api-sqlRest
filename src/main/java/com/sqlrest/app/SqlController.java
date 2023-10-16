package com.sqlrest.app;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class SqlController {

    @PostMapping(value = "/sql", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List> getSentence (@RequestBody Request request) throws SQLException {

        SqlDriver sqlDriver = new SqlDriver();
        return ResponseEntity.ok(sqlDriver.executeQuery(request));
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List> updateSentence(@RequestBody Request request) throws SQLException {
        SqlDriver sqlDriver = new SqlDriver();
        return ResponseEntity.ok(sqlDriver.updateQuery(request));}

}
