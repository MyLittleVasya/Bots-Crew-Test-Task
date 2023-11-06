package com.bots_crew_testing.entity.repo;

import com.bots_crew_testing.entity.Lector;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO for {@link Lector}.
 */
public interface LectorRepository extends JpaRepository<Lector, Long> {

  List<Lector> findByFullNameContaining(String searchArgument);

}
