/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.controllers;

import com.rentCloud.cloud.app.entities.Admin;
import com.rentCloud.cloud.app.servicies.adminService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Naty
 */
@RestController
@RequestMapping("Admin")
public class AdminController {

    @Autowired
    private adminService service;

    /**
     * GET
     *
     * @return
     */
    @GetMapping("/all")
    public List<Admin> getAll() {
        return service.getAll();
    }

    /**
     * GET/{id}
     *
     * @param adminId
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Admin> getOne(@PathVariable("id") int adminId) {
        return service.getAdminService(adminId);
    }

    /**
     * POST
     *
     * @param admin
     * @return
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin) {
        return service.save(admin);
    }

    /**
     * PUT
     *
     * @param admin
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin) {
        return service.update(admin);
    }

    /**
     * DELETE
     *
     * @param adminId
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int adminId) {
        return service.delete(adminId);
    }

}
