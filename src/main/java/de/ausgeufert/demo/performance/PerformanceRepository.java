package de.ausgeufert.demo.performance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<Performance, PerformanceId> {

}
