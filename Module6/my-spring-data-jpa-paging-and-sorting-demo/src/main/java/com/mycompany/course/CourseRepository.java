package com.mycompany.course;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository extends ListPagingAndSortingRepository
// ListPagingAndSortingRepository extends PagingAndSortingRepository
public interface CourseRepository extends JpaRepository<Course, Long> {

}