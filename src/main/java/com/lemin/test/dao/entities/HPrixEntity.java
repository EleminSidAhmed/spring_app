package com.lemin.test.dao.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "h_prix", schema = "testdb")
public class HPrixEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "id_type", nullable = true)
    private Integer idType;
    @Basic
    @Column(name = "prix", nullable = true)
    private Integer prix;

    @Basic
    @Column(name = "lib", nullable = true)
    private String lib;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HPrixEntity that = (HPrixEntity) o;

        if (id != that.id) return false;
        if (idType != null ? !idType.equals(that.idType) : that.idType != null) return false;
        if (prix != null ? !prix.equals(that.prix) : that.prix != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idType != null ? idType.hashCode() : 0);
        result = 31 * result + (prix != null ? prix.hashCode() : 0);
        return result;
    }
}
