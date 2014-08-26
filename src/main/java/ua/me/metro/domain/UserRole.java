package ua.me.metro.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Roles")
public class UserRole {

    @Column(name="id")
    @Id
    private Integer id;

    @Column(name="roles", nullable=false)
    @Enumerated(EnumType.STRING)
    private ListRole role;

    @ManyToMany(mappedBy="userRoles", cascade=CascadeType.ALL)
    private Set<User> users = new HashSet<>();

    public ListRole getRole() {
        return role;
    }
    public void setRole(ListRole role) {
        this.role = role;
    }

    public UserRole() {
    }

    public UserRole(Integer id, ListRole role) {
        this.id = id;
        this.role = role;

    }

}
