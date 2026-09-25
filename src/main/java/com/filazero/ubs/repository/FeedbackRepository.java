package com.filazero.ubs.repository;
import com.filazero.ubs.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {}
