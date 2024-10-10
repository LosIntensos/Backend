package b4u.pocketpartners.backend.operations.domain.model.aggregates;

import b4u.pocketpartners.backend.groups.domain.model.aggregates.Group;
import b4u.pocketpartners.backend.operations.domain.model.valueobjects.Amount;
import b4u.pocketpartners.backend.operations.domain.model.valueobjects.DueDate;
import b4u.pocketpartners.backend.operations.domain.model.valueobjects.ExpenseName;
import b4u.pocketpartners.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import b4u.pocketpartners.backend.users.domain.model.aggregates.UserInformation;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Entity
public class Expense extends AuditableAbstractAggregateRoot<Expense> {

    @Embedded
    private ExpenseName name;

    @Embedded
    private Amount amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInformation userInformation;
  
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Getter
    @Embedded
    private DueDate dueDate;

    public Expense(String name, BigDecimal amount, UserInformation userInformation, Group group, LocalDate dueDate){
        this.name = new ExpenseName(name);
        this.amount = new Amount(amount);
        this.userInformation = userInformation;
        this.group = group;
        this.dueDate = new DueDate(dueDate);
    }


    public Expense() {}

    public void UpdateExpenseName(String newName){this.name = new ExpenseName(newName);}
  public void UpdateAmount(BigDecimal newAmount){this.amount = new Amount(newAmount);}

    public Expense UpdateInformation(String newName, BigDecimal newAmount, LocalDate newDueDate){
        this.name = new ExpenseName(newName);
        this.amount = new Amount(newAmount);
        this.dueDate = new DueDate(newDueDate);
        return this;
    }

    public String getName(){return name.getName();}

    public BigDecimal getAmount(){return amount.getAmount();}

    public LocalDate getDueDate(){return dueDate.getDueDate();}
}
