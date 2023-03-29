package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rozmiar", schema = "java", catalog = "")
@NamedQuery(name = "jednostkirozmiar", query = "select r from RozmiarEntity r")
public class RozmiarEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "r_id")
    private int rId;
    @Basic
    @Column(name = "r_nazwa")
    private String rNazwa;

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public String getrNazwa() {
        return rNazwa;
    }

    public void setrNazwa(String rNazwa) {
        this.rNazwa = rNazwa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RozmiarEntity that = (RozmiarEntity) o;
        return rId == that.rId && Objects.equals(rNazwa, that.rNazwa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rId, rNazwa);
    }

    @Override
    public String toString() {
        return getrNazwa();
    }
}
