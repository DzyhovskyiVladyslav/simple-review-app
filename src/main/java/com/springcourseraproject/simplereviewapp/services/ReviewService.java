package com.springcourseraproject.simplereviewapp.services;

import java.util.List;

import com.springcourseraproject.simplereviewapp.models.Review;

public interface ReviewService {
	Review saveReview(Review review);
	List<Review> getAllReviews();
	Review getReviewById(long id);
	Review updateReview(Review review, long id);
	void deleteReview(long id);
}
