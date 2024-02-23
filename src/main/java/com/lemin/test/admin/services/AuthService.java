package com.lemin.test.admin.services;
import com.lemin.test.admin.dtos.AuthDto;
import com.lemin.test.admin.dtos.UserDto;
import com.lemin.test.admin.dtos.UserRole;
import com.lemin.test.dao.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto logIn(AuthDto authDto) {

        Optional<UserDto> userOpt = userRepository.findAll().stream()
                .filter(u -> u.getNom().equals(authDto.getUserName()) &&
                        u.getPassword().equals(authDto.getPassword())
                )
                .map(u -> new UserDto(u.getId(), u.getNom()))
                .findFirst();

        return userOpt.isPresent() ? userOpt.get() : null;
    }
    public UserRole log(AuthDto authDto) {
        List<Object[]> usersWithRole = userRepository.findAllWithRole();

        Optional<Object[]> userOpt = usersWithRole.stream()
                .filter(u -> u[1].equals(authDto.getUserName()) && u[2].equals(authDto.getPassword()))
                .findFirst();

        return userOpt.map(u -> new UserRole((Integer) u[0], (String) u[1],(String) u[4])).orElse(null);
    }
}
