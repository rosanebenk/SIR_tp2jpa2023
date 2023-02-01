//package jpa;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//
//import javax.persistence.*;
//
//@Entity
//
//public class Message {
//    private Long id;
//
//    private String name;
//
//    private User user;
//
//    public Ticket() {
//    }
//
//    public Ticket(String name, User user) {
//        this.name = name;
//        this.user = user;
//    }
//
//    public Ticket(String name) {
//        this.name = name;
//    }
//
//    @Id
//    @GeneratedValue
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @ManyToOne
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    @Override
//    public String toString() {
//        return "Employee [id=" + id + ", name=" + name + ", user="
//                + user.getName() + "]";
//    }
//}
