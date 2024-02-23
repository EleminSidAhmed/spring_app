package com.lemin.test.dao.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_command", schema = "testdb")
public class UserCommandEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "id_user", nullable = true)
    private Integer idUser;
    @Basic
    @Column(name = "nbr_piece", nullable = true)
    private Integer nbrPiece;
    @Basic
    @Column(name = "type", nullable = true, length = 10)
    private String type;
    @Basic
    @Column(name = "livraison", nullable = true)
    private Byte livraison;

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

    public Integer getNbrPiece() {
        return nbrPiece;
    }

    public void setNbrPiece(Integer nbrPiece) {
        this.nbrPiece = nbrPiece;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Byte getLivraison() {
        return livraison;
    }

    public void setLivraison(Byte livraison) {
        this.livraison = livraison;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserCommandEntity that = (UserCommandEntity) o;

        if (id != that.id) return false;
        if (idUser != null ? !idUser.equals(that.idUser) : that.idUser != null) return false;
        if (nbrPiece != null ? !nbrPiece.equals(that.nbrPiece) : that.nbrPiece != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (livraison != null ? !livraison.equals(that.livraison) : that.livraison != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idUser != null ? idUser.hashCode() : 0);
        result = 31 * result + (nbrPiece != null ? nbrPiece.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (livraison != null ? livraison.hashCode() : 0);
        return result;
    }
}
