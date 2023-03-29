package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "predkosci", schema = "java", catalog = "")
@NamedQuery(name = "jednostkipredkosc", query = "select p from PredkosciEntity p")
public class PredkosciEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "p_id")
    private int pId;
    @Basic
    @Column(name = "p_nazwa")
    private String pNazwa;

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpNazwa() {
        return pNazwa;
    }

    public void setpNazwa(String pNazwa) {
        this.pNazwa = pNazwa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PredkosciEntity that = (PredkosciEntity) o;
        return pId == that.pId && Objects.equals(pNazwa, that.pNazwa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pId, pNazwa);
    }

    @Override
    public String toString() {
        return getpNazwa();
    }
}
