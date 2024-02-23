package com.lemin.test.admin.controllers.crud;

import com.lemin.test.admin.dtos.crud.HPrixWithTypeName;
import com.lemin.test.admin.dtos.crud.OwnerDetails;
import com.lemin.test.admin.services.crud.CarpetService;
import com.lemin.test.admin.services.crud.CustomersService;
import com.lemin.test.admin.services.crud.PrixService;
import com.lemin.test.admin.services.crud.TypeService;
import com.lemin.test.dao.entities.CarpetEntity;
import com.lemin.test.dao.entities.HPrixEntity;
import com.lemin.test.dao.entities.HTypeEntity;
import com.lemin.test.dao.entities.HUserEntity;
import com.lemin.test.dao.repositories.crud.OwnerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {
    private final TypeService typeService;
    private final PrixService prixService;
    private final CustomersService customersService;
    private final CarpetService carpetService;

    public AdminController(TypeService typeService, PrixService prixService, OwnerRepository ownerRepository, CustomersService customersService, CarpetService carpetService) {
        this.typeService = typeService;
        this.prixService = prixService;
        this.customersService = customersService;
        this.carpetService = carpetService;
    }
    /* ****************type starts ********************* */
    @GetMapping("type")
    public ResponseEntity<List<HTypeEntity>> getAllProducts() {
        List<HTypeEntity> products = typeService.getAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("type/{id}")
    public ResponseEntity<HTypeEntity> getProductById(@PathVariable Integer id) {
        Optional<HTypeEntity> product = typeService.getTypeById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("type/create")
    public ResponseEntity<HTypeEntity> createProduct(@RequestBody HTypeEntity product) {
        HTypeEntity createdProduct = typeService.saveOne(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("type/update/{id}")
    public ResponseEntity<HTypeEntity> updateProduct(@PathVariable Integer id, @RequestBody HTypeEntity product) {
        HTypeEntity updatedProduct = typeService.updatedtype(id, product);
        return updatedProduct != null ?
                new ResponseEntity<>(updatedProduct, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("type/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        typeService.deleteType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /* ****************type End ********************* */

    /* ****************Price starts ********************* */
    @GetMapping("/pricewith")
    public ResponseEntity<List<HPrixWithTypeName>> getAllPriceWithTypes() {
        List<HPrixWithTypeName> prixEntitiesWithTypes = prixService.getAllPrixWithType();
        return new ResponseEntity<>(prixEntitiesWithTypes, HttpStatus.OK);
    }

    @GetMapping("price")
    public ResponseEntity<List<HPrixEntity>> getAllPrice() {
        List<HPrixEntity> products = prixService.getAllPrix();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("price/{id}")
    public ResponseEntity<HPrixEntity> getPriceById(@PathVariable Integer id) {
        Optional<HPrixEntity> product = prixService.getPrixById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("price/create")
    public ResponseEntity<HPrixEntity> createProduct(@RequestBody HPrixEntity product) {
        HPrixEntity createdProduct = prixService.createPrix(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("price/update/{id}")
    public ResponseEntity<HPrixEntity> updatePrice(@PathVariable Integer id, @RequestBody HPrixEntity product) {
        HPrixEntity updatedProduct = prixService.updateHPrixEntity(id, product);
        return updatedProduct != null ?
                new ResponseEntity<>(updatedProduct, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("price/delete/{id}")
    public ResponseEntity<Void> deletePrice(@PathVariable Integer id) {
        prixService.deletePrix(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /* ****************Price End ********************* */
    /* ****************Owner starts ********************* */
    @GetMapping("owner")
    public ResponseEntity<List<HUserEntity>> getAllOwner() {
        List<HUserEntity> products = customersService.getAllOwner();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("owner/{id}")
    public ResponseEntity<HUserEntity> getOwnerById(@PathVariable Integer id) {
        Optional<HUserEntity> product = customersService.getOwnerById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("owner/create")
    public ResponseEntity<HUserEntity> createProduct(@RequestBody HUserEntity product) {
        HUserEntity createdProduct = customersService.createOwner(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("owner/update/{id}")
    public ResponseEntity<HUserEntity> updateOwner(@PathVariable Integer id, @RequestBody HUserEntity product) {
        HUserEntity updatedProduct = customersService.updateOwner(id, product);
        return updatedProduct != null ?
                new ResponseEntity<>(updatedProduct, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("owner/delete/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Integer id) {
        customersService.deleteowner(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("owner/details/{id}")
    public ResponseEntity<List<OwnerDetails>> ownerdetails(@PathVariable Integer id) {
        List<OwnerDetails> owners = customersService.ownerdetails(id);
        return new ResponseEntity<>(owners, HttpStatus.OK);
    }

    /* ****************Owner End ********************* */



    /* ****************Owner starts ********************* */
    @GetMapping("carpet")
    public ResponseEntity<List<CarpetEntity>> getAllCarpet() {
        List<CarpetEntity> products = carpetService.getAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("carpet/{id}")
    public ResponseEntity<CarpetEntity> getCarpetById(@PathVariable Integer id) {
        Optional<CarpetEntity> product = carpetService.getCarpeteById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("carpet/create")
    public ResponseEntity<CarpetEntity> createCarpet(@RequestBody CarpetEntity product) {
        CarpetEntity createdProduct = carpetService.saveOne(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("carpet/update/{id}")
    public ResponseEntity<CarpetEntity> updateCarpet(@PathVariable Integer id, @RequestBody CarpetEntity product) {
        CarpetEntity updatedProduct = carpetService.updatedcarpet(id, product);
        return updatedProduct != null ?
                new ResponseEntity<>(updatedProduct, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("carpet/delete/{id}")
    public ResponseEntity<Void> deleteCarpet(@PathVariable Integer id) {
        carpetService.deleteCarpet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /* ****************Carpet End ********************* */
}
