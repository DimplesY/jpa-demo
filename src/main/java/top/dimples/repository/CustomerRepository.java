package top.dimples.repository;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;
import top.dimples.model.Customer;
import top.dimples.projection.CustomerProjection;

/**
 * @author Dimples_YJ
 * @create 2024/9/21
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    CustomerProjection findByLastName(String lastName);

}
