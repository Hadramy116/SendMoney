package mr.send.money.sendmoney;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mr.send.money.sendmoney.entites.Account;
import mr.send.money.sendmoney.entites.AppUser;
import mr.send.money.sendmoney.repository.AccountRepository;
import mr.send.money.sendmoney.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AccountRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;
	@Autowired
	private AccountRepository accountRepository;
	
	
	@Test
	public void whenFindByNumAccount_thenReturnAccount() {
		Account account=new Account("45789");
		testEntityManager.persist(account);
		testEntityManager.flush();
		
		Account found=accountRepository.findByNumAccount(account.getNumAccount());
	
		assertEquals(found.getNumAccount(), account.getNumAccount());
	}
	
	
	
}
