package com.lemin.test.admin.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRole {
    private Integer id;
    private String nom;
    private String role;
}
