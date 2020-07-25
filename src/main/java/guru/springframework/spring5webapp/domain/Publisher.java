package guru.springframework.spring5webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String addressLine1;
    private String city;
    private String state;
    private String zip;

    private Set<Book> books = new HashSet<>();

    public Publisher() {
    }

    @Override
    public String toString() {
        return String.format("Publisher(id: %d, name: %s, address: %s, city: %s, state: %s, zip:%s)", this.id, this.name, this.addressLine1, this.city, this.state, this.zip);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj== null || getClass() != obj.getClass()) return false;

        Publisher publisher = (Publisher)obj;
        return id != null ? id.equals(publisher.id) : publisher.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
