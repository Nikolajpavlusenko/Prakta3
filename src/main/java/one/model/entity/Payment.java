package one.model.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table( name="payment",
        uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
//@SecondaryTables({
//        @SecondaryTable(name="user"), @SecondaryTable(name="car")
//})
@NamedQuery(name = "Payment.getAll", query = "SELECT p from Payment p")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @NotNull
    @Column(name = "date")
    private LocalDate date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @JoinColumn(name = "utility_id", referencedColumnName = "id",  insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Utility utility;
    @JoinColumn(name = "client_id", referencedColumnName = "id",  insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User client;

    @Basic(optional = false)
    @NotNull
    @Column(name = "utility_id")
    private long utilityId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "client_id")
    private long clientId;

    public Payment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getUtilityId() {
        return utilityId;
    }

    public void setUtilityId(long utilityId) {
        this.utilityId = utilityId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public static class Builder{
        Payment payment = new Payment();

        public Builder id(long id){
            payment.id = id;
            return this;
        }
        public Builder date(LocalDate date){
            payment.date = date;
            return this;
        }
        public Builder amount(int amount){
            payment.amount = amount;
            return this;
        }
        public Builder price(int price){
            payment.price = price;
            return this;
        }
        public Builder clientId(long clientId){
            payment.clientId = clientId;
            return this;
        }
        public Builder utilityId(long utilityId){
            payment.utilityId = utilityId;
            return this;
        }
        public Payment build(){
            return payment;
        }
    }
}
