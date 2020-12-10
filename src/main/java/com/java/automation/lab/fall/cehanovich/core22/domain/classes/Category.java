package com.java.automation.lab.fall.cehanovich.core22.domain.classes;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Comparator;
import java.util.Set;

@XmlRootElement(name = "Category")
@XmlType(propOrder = {"id", "subcategories", "name"})
public class Category extends AbstractEntity implements Comparable<Category> {
    private Set<Subcategory> subcategories;
    private String name;

    public Category(long id, Set<Subcategory> subcategories, String name) {
        this.setId(id);
        this.subcategories = subcategories;
        this.name = name;
    }
    public Set<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Set<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Category {\nID: " + this.getId() + "Subcategories" + subcategories.toString() + "Name: " + name + "\n}";
    }

    @Override
    public boolean equals(Object that) {
        if (that == null) {
            return false;
        }
        if (this.getClass() != that.getClass()) {
            return false;
        }
        if (this == that) {
            return true;
        }
        Category other = (Category) that;
        return this.getId() == other.getId() && subcategories.equals(other.subcategories) && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return (int) (subcategories.hashCode() + this.getId() + name.hashCode());
    }

    @Override
    public int compareTo(Category a) {
        return (int) (this.getId() - a.getId());
    }

    public static Comparator<Category> SubcategoriesComparator = new Comparator<Category>() {

        @Override
        public int compare(Category a1, Category a2) {
            return (a1.getSubcategories().size() - a2.getSubcategories().size());
        }
    };

    public static Comparator<Category> NameComparator = new Comparator<Category>() {

        @Override
        public int compare(Category a1, Category a2) {
            return (a1.getName().compareTo(a2.getName()));
        }
    };
}
