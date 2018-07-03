package service.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Service
@Table(
        name = "rate",
        uniqueConstraints = @UniqueConstraint(columnNames = {"src","dst","date"})
)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rate implements Serializable{

    private long id;
    private String src;
    private String dst;
    private double taux;
    private Date date;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NotNull
    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @NotNull
    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    @NotNull
    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @NotNull
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate that = (Rate) o;
        return Double.compare(that.taux, taux) == 0 &&
                Objects.equals(src, that.src) &&
                Objects.equals(dst, that.dst) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(src, dst, taux, date);
    }

    @Override
    public String toString() {
        return "TauxService{" +
                "id=" + id +
                ", src='" + src + '\'' +
                ", dst='" + dst + '\'' +
                ", taux=" + taux +
                ", date=" + date +
                '}';
    }
}
