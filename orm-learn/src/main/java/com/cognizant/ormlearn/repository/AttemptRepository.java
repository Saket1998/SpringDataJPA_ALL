package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Attempt;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {
	@Query(value = "SELECT at FROM Attempt at join fetch at.user WHERE at.id=?2 AND at.user.id=?1")
	public Attempt getAttempt(int userId, int attemptId);
}
