package com.lemin.test.dao.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_carpet", schema = "testdb", catalog = "")
public class UserCarpetEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "id_user", nullable = true)
    private Integer idUser;
    @Basic
    @Column(name = "id_carpet", nullable = true)
    private Integer idCarpet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdCarpet() {
        return idCarpet;
    }

    public void setIdCarpet(Integer idCarpet) {
        this.idCarpet = idCarpet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserCarpetEntity that = (UserCarpetEntity) o;

        if (id != that.id) return false;
        if (idUser != null ? !idUser.equals(that.idUser) : that.idUser != null) return false;
        if (idCarpet != null ? !idCarpet.equals(that.idCarpet) : that.idCarpet != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idUser != null ? idUser.hashCode() : 0);
        result = 31 * result + (idCarpet != null ? idCarpet.hashCode() : 0);
        return result;
    }
}
