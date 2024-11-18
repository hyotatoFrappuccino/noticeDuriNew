package com.studioP.noticeDuriNew;

import com.studioP.noticeDuriNew.entity.User;
import com.studioP.noticeDuriNew.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NoticeDuriNewApplicationTests {


	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EntityManager em;

	@Test
	void test() {
		User hyojae = new User(1L, "hyojae");
		em.persist(hyojae);
		System.out.println("================");
		userRepository.save(hyojae);
//		em.persist();
	}

}
