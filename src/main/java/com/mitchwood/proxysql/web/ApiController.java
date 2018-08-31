package com.mitchwood.proxysql.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mitchwood.proxysql.model.User;
import com.mitchwood.proxysql.svc.ProxySqlService;

@RestController
public class ApiController {

    @Autowired
    ProxySqlService svc;

    @RequestMapping(value="/users", method=RequestMethod.GET)
    public Collection<User> getUsers() {
        return svc.getUsers();
    }

}
