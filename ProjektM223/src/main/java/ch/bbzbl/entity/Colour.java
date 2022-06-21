package ch.bbzbl.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Colour implements Serializable{
    private static final long serialVersionUID = 1L;

    @Version
    private long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Language) {
            Language language = (Language) obj;
            return language.getId() == id;
        }

        return false;
    }

    @Override
    public String toString() {
        return name;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}