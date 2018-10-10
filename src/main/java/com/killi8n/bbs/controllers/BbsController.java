package com.killi8n.bbs.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/api/v1/bbs")
@Controller
public class BbsController {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create() {
        return new ResponseEntity<>("Create", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> list() {
        return new ResponseEntity<>("List", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> read(@PathVariable Long id) {
        return new ResponseEntity<>("Read " + id, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> remove(@PathVariable Long id) {
        return new ResponseEntity<>("Removed " + id, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable Long id) {
        return new ResponseEntity<>("Updated " + id, HttpStatus.OK);
    }
}