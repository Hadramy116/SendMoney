package mr.send.money.sendmoney;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mr.send.money.sendmoney.entites.Account;
import mr.send.money.sendmoney.entites.AppRole;
import mr.send.money.sendmoney.entites.RoleName;
import mr.send.money.sendmoney.repository.AccountRepository;
import mr.send.money.sendmoney.repository.RoleRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RoleRepositoryTest {
	@Autowired
	private TestEntityManager testEntityManager;
	@Autowired
	private RoleRepository roleRepository;
	
	@Test
	public void whenFindByRoleName_thenReturnRole() {
		AppRole role=new AppRole(RoleName.SIMPLE_USER);
		testEntityManager.persist(role);
		testEntityManager.flush();
		
		AppRole found=roleRepository.findAppRoleByRoleName(role.getRoleName());
	
		assertEquals(found.getRoleName(), role.getRoleName());
	}
	
}
