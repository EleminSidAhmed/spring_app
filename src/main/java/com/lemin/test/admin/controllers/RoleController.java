package com.lemin.test.admin.controllers;
import com.lemin.test.admin.dtos.RoleDto;
import com.lemin.test.admin.services.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<RoleDto> getAll() {
    return  roleService.getAll();
}

}
