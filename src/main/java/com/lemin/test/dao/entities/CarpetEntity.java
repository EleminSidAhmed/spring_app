package com.lemin.test.dao.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "carpet", schema = "testdb")
public class CarpetEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "lib", nullable = true, length = 255)
    private String lib;
    @Basic
    @Column(name = "carpetsize", nullable = true, length = 50)
    private String carpetsize;
    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public String getCarpetsize() {
        return carpetsize;
    }

    public void setCarpetsize(String carpetsize) {
        this.carpetsize = carpetsize;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarpetEntity that = (CarpetEntity) o;

        if (id != that.id) return false;
        if (lib != null ? !lib.equals(that.lib) : that.lib != null) return false;
        if (carpetsize != null ? !carpetsize.equals(that.carpetsize) : that.carpetsize != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lib != null ? lib.hashCode() : 0);
        result = 31 * result + (carpetsize != null ? carpetsize.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
