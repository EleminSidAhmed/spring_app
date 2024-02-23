package com.lemin.test.admin.dtos.crud;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class H_prix {
    int id;
    int id_type;
    double prix;
}
