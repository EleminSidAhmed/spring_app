package com.lemin.test.admin.controllers;
import com.lemin.test.admin.dtos.UserDto;
import com.lemin.test.admin.dtos.crud.H_type;
import com.lemin.test.admin.services.UserService;
import com.lemin.test.admin.services.crud.TypeService;
import com.lemin.test.dao.entities.HTypeEntity;
import com.lemin.test.dao.entities.HUserEntity;
import com.lemin.test.dao.entities.UserCommandEntity;
import com.lemin.test.dao.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("User")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final UserService userService;
    @Autowired
    private final TypeService typeService;

    public UserController(UserService userService, TypeService typeService) {
        this.userService = userService;
        this.typeService = typeService;
    }

    @GetMapping("users")
    public List<UserDto> getAll() {
    return  userService.getAll();
}
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getProductById(@PathVariable Integer id) {
        Optional<UserEntity> product = userService.getUserById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("create")
    public ResponseEntity<UserEntity> createProduct(@RequestBody UserEntity product) {
        UserEntity createdProduct = userService.createuser(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<UserEntity> updateProduct(@PathVariable Integer id, @RequestBody UserEntity product) {
        UserEntity updatedProduct = userService.updateuser(id, product);
        return updatedProduct != null ?
                new ResponseEntity<>(updatedProduct, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        userService.deleteuser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/findbyuser/{userId}")
    public ResponseEntity<List<HUserEntity>> getEntitiesByUserId(@PathVariable Long userId) {
        List<HUserEntity> entities = userService.findEntitiesByUserId(userId);
        if (entities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if no entities found
        }
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    /* this is for command*/

    @PostMapping("/command/create")
    public ResponseEntity<UserCommandEntity> createCommand(@RequestBody UserCommandEntity command) {
        UserCommandEntity createdCommand = userService.createCommand(command);
        return new ResponseEntity<>(createdCommand, HttpStatus.CREATED);
    }

    @GetMapping("/commands")
    public ResponseEntity<List<UserCommandEntity>> getAllCommands() {
        List<UserCommandEntity> commands = userService.getAllCommands();
        return new ResponseEntity<>(commands, HttpStatus.OK);
    }

    @GetMapping("/command/{id}")
    public ResponseEntity<UserCommandEntity> getCommandById(@PathVariable Integer id) {
        return userService.getCommandById(id)
                .map(command -> new ResponseEntity<>(command, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("command/update/{id}")
    public ResponseEntity<UserCommandEntity> updateCommand(@PathVariable Integer id, @RequestBody UserCommandEntity updatedCommand) {
        UserCommandEntity command = userService.updateCommand(id, updatedCommand);
        return new ResponseEntity<>(command, HttpStatus.OK);
    }

    @DeleteMapping("command/delete/{id}")
    public ResponseEntity<Void> deleteCommand(@PathVariable Integer id) {
        userService.deleteCommand(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
