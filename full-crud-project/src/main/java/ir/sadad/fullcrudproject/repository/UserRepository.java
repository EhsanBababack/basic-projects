package ir.sadad.fullcrudproject.repository;


import ir.sadad.fullcrudproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}