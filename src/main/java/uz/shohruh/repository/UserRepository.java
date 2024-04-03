package uz.shohruh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.shohruh.model.Role;
import uz.shohruh.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Modifying
    @Query(value = "update User set role = :role where username = :username", nativeQuery = true)
    void updateUserRole(@Param("username") String username, @Param("role")Role role);
}
