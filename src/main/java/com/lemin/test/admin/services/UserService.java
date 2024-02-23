package com.lemin.test.admin.services;
import com.lemin.test.admin.dtos.UserDto;
import com.lemin.test.dao.entities.HUserEntity;
import com.lemin.test.dao.entities.UserCommandEntity;
import com.lemin.test.dao.entities.UserEntity;
import com.lemin.test.dao.repositories.Command;
import com.lemin.test.dao.repositories.UserRepository;
import com.lemin.test.dao.repositories.User_roleRepository;
import com.lemin.test.dao.repositories.crud.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final OwnerRepository ownerRepository;
    private final Command commandRepository;

    public UserService(UserRepository userRepository, User_roleRepository userRoleRepository, OwnerRepository ownerRepository, Command commandRepository) {
        this.userRepository = userRepository;
        this.ownerRepository = ownerRepository;
        this.commandRepository = commandRepository;
    }

    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
                .map(u -> new UserDto(u.getId(), u.getNom()))
                .collect(Collectors.toList());
    }

    public Optional<UserEntity> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public UserEntity createuser(UserEntity product) {
        return userRepository.save(product);
    }

    public UserEntity updateuser(Integer id, UserEntity updatedProduct) {
        if (userRepository.existsById(id)) {
            updatedProduct.setId(id);
            return userRepository.save(updatedProduct);
        } else {
            return null; // Or throw an exception indicating the resource doesn't exist
        }
    }

    public void deleteuser(Integer id) {
        userRepository.deleteById(id);
    }


    public List<HUserEntity> findEntitiesByUserId(Long userId) {
        return ownerRepository.findByUserId(userId);
    }

    /*  this is for command */
    public UserCommandEntity createCommand(UserCommandEntity command) {
        return commandRepository.save(command);
    }

    // Read operation
    public List<UserCommandEntity> getAllCommands() {
        return commandRepository.findAll();
    }

    public Optional<UserCommandEntity> getCommandById(Integer id) {
        return commandRepository.findById(id);
    }

    // Update operation
    public UserCommandEntity updateCommand(Integer id, UserCommandEntity updatedCommand) {
        if (commandRepository.existsById(id)) {
            updatedCommand.setId(id);
            return commandRepository.save(updatedCommand);
        } else {
            throw new RuntimeException("Command not found with id: " + id);
        }
    }

    // Delete operation
    public void deleteCommand(Integer id) {
        if (commandRepository.existsById(id)) {
            commandRepository.deleteById(id);
        } else {
            throw new RuntimeException("Command not found with id: " + id);
        }
    }

}
