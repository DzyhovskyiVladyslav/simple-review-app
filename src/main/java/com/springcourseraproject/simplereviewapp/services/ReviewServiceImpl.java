package com.springcourseraproject.simplereviewapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springcourseraproject.simplereviewapp.exceptions.ResourceNotFoundException;
import com.springcourseraproject.simplereviewapp.models.Review;
import com.springcourseraproject.simplereviewapp.repositories.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

	private ReviewRepository reviewRepository;

	public ReviewServiceImpl(ReviewRepository reviewRepository) {
		super();
		this.reviewRepository = reviewRepository;
	}
	
	public Review saveReview(Review review) {
		return reviewRepository.save(review);
	}

	public List<Review> getAllReviews() {
		return reviewRepository.findAll();
	}

	public Review getReviewById(long id) {
		return reviewRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Review", "Id", id));
	}

	public Review updateReview(Review review, long id) {
		Review existingReview = reviewRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Review", "Id", id));
		existingReview.setName(review.getName());
		existingReview.setEmail(review.getEmail());
		existingReview.setProduct(review.getProduct());
		existingReview.setRate(review.getRate());
		existingReview.setComment(review.getComment());
		reviewRepository.save(existingReview);
		return existingReview;
	}

	public void deleteReview(long id) {
		reviewRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Review", "Id", id));
		reviewRepository.deleteById(id);
	}
}