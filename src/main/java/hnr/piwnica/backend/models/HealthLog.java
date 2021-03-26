package hnr.piwnica.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class HealthLog {
    @Id
    @GeneratedValue
    private Integer id;

    private Date date;

    protected HealthLog() {
    }

    public HealthLog(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }
}
