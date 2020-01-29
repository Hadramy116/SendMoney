package mr.send.money.sendmoney;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import mr.send.money.sendmoney.entites.AppUser;
import mr.send.money.sendmoney.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private TestEntityManager testEntityManager;
	@Autowired
	private UserRepository userRepository;
	
	
	@Test
	public void whenFindByName_thenReturnUser() {
		AppUser user=new AppUser("Ahmed");
		testEntityManager.persist(user);
		testEntityManager.flush();
		
		AppUser found=userRepository.findByUserName(user.getUserName());
	
		assertEquals(found.getUserName(), user.getUserName());
	}
	
	

}
