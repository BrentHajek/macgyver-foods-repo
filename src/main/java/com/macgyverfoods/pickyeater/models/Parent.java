package com.macgyverfoods.pickyeater.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Parent {

    @Id
    @GeneratedValue
    private Long id;

    private String parentFirstName;
    private String parentLastName;
    private String email;

    @OneToMany (mappedBy = "parent")
    private Collection<Child> children;

    public Long getId() {
        return id;
    }

    public String getParentFirstName() {
        return parentFirstName;
    }

    public String getParentLastName() {
        return parentLastName;
    }

    public String getEmail() {
        return email;
    }

    public Collection<Child> getChild() {
        return children;
    }

    public Parent() {}

    public Parent(String parentFirstName, String parentLastName, String email, Collection<Child> children) {
        this.parentFirstName = parentFirstName;
        this.parentLastName = parentLastName;
        this.email = email;
        this.children = children;
    }

    public void addChild(Child childToAdd) {
        children.add(childToAdd);
    }
}
