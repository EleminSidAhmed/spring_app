package com.lemin.test.dao.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "h_user", schema = "testdb")
public class HUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "id_prix", nullable = true)
    private Integer idPrix;
    @Basic
    @Column(name = "quantity", nullable = true)
    private Integer quantity;
    @Basic
    @Column(name = "id_user", nullable = true)
    private Integer idUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdPrix() {
        return idPrix;
    }

    public void setIdPrix(Integer idPrix) {
        this.idPrix = idPrix;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HUserEntity that = (HUserEntity) o;

        if (id != that.id) return false;
        if (idPrix != null ? !idPrix.equals(that.idPrix) : that.idPrix != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (idUser != null ? !idUser.equals(that.idUser) : that.idUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idPrix != null ? idPrix.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (idUser != null ? idUser.hashCode() : 0);
        return result;
    }
}
