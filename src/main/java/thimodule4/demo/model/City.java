package thimodule4.demo.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class City {
    private int id;
    private String name;
    private String city;
    private double area;
    private int population;
    private double gpa;
    private String description;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 100)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "area", nullable = false, precision = 0)
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Basic
    @Column(name = "population", nullable = false)
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Basic
    @Column(name = "gpa", nullable = false, precision = 0)
    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return id == city1.id &&
                Double.compare(city1.area, area) == 0 &&
                population == city1.population &&
                Double.compare(city1.gpa, gpa) == 0 &&
                Objects.equals(name, city1.name) &&
                Objects.equals(city, city1.city) &&
                Objects.equals(description, city1.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, area, population, gpa, description);
    }
}
