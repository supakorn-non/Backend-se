package th.ac.ku.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ac.ku.Backend.model.CustomerAccount;

import java.util.List;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Integer> {
    CustomerAccount findByName(String name);
    CustomerAccount findByEmail(String email);
    CustomerAccount findByTel(String tel);
}
