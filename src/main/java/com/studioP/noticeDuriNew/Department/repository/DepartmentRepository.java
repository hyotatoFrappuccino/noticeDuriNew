package com.studioP.noticeDuriNew.Department.repository;

import com.studioP.noticeDuriNew.Department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
