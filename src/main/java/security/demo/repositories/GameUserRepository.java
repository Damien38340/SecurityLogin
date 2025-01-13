package security.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import security.demo.entities.GameUserEntity;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
@Repository
public interface GameUserRepository extends JpaRepository<GameUserEntity, Integer> {

    Optional<GameUserEntity> findByUsername(String username);
}
