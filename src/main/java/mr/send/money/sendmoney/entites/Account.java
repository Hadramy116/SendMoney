package mr.send.money.sendmoney.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account implements Serializable{

	  @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private int id;
      private String numAccount;
      private Double balance;
      private AppUser appUser;

      public Account() {
      }

      public Account(String numAccount, Double balance, AppUser appUser) {
            this.numAccount = numAccount;
            this.balance = balance;
            this.appUser = appUser;
      }
      
      

      public Account(String numAccount) {
		super();
		this.numAccount = numAccount;
	}

	public int getId() {
            return id;
      }

      public void setId(int id) {
            this.id = id;
      }

      public String getNumAccount() {
            return numAccount;
      }

      public void setNumAccount(String numAccount) {
            this.numAccount = numAccount;
      }

      public Double getBalance() {
            return balance;
      }

      public void setBalance(Double balance) {
            this.balance = balance;
      }

      public AppUser getAppUser() {
            return appUser;
      }

      public void setAppUser(AppUser appUser) {
            this.appUser = appUser;
      }
}
