package br.com.flexpag.payments.repository;

import br.com.flexpag.payments.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}

