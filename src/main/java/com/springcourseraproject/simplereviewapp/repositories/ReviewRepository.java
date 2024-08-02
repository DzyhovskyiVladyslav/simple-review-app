package com.springcourseraproject.simplereviewapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springcourseraproject.simplereviewapp.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>  {

}
