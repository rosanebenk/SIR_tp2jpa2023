//package metier;
//
//import metier.Ticket;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//
//import javax.persistence.*;
//
//@Entity
//public class Tag {
//    private Long id;
//
//    private String name;
//
//    private Ticket ticket;
//
//    public Tag() {
//    }
//
//        public Tag(String name, Ticket ticket) {
//        this.name = name;
//        this.ticket = ticket;
//    }
//
//    public Tag(String name) {
//        this.name = name;
//    }
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
//    public Ticket getTicket() {
//        return ticket;
//    }
//
//    public void setTicket(Ticket ticket) {
//        this.ticket = ticket;
//    }
//
//    @Override
//    public String toString() {
//        return "Employee [id=" + id + ", name=" + name + ", user="
//                + ticket.getName() + "]";
//    }
//}
