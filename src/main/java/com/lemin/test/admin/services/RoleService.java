package com.lemin.test.admin.services;
import com.lemin.test.admin.dtos.RoleDto;
import com.lemin.test.dao.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {
    private final RoleRepository userroleRepositoryepository;

    public RoleService(RoleRepository userRepository) {
        this.userroleRepositoryepository = userRepository;
    }

    public List<RoleDto> getAll() {
        return userroleRepositoryepository.findAll().stream()
                .map(u -> {
            return new RoleDto(u.getId(), u.getLib());
        }).collect(Collectors.toList());
    }
}
