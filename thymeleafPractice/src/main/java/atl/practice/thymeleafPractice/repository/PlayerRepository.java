package atl.practice.thymeleafPractice.repository;

import atl.practice.thymeleafPractice.model.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Players, Long> {
}
