package com.Deepak.DevProductivityTracker.repo;

import com.Deepak.DevProductivityTracker.entity.DeveloperTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperTaskRepo extends JpaRepository<DeveloperTask , Long> {
}
