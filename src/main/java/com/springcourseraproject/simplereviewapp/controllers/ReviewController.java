package com.springcourseraproject.simplereviewapp.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcourseraproject.simplereviewapp.models.Review;
import com.springcourseraproject.simplereviewapp.services.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

	private ReviewService reviewService;
	
	public ReviewController(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}
	
	@PostMapping()
	public ResponseEntity<Review> saveReview(@RequestBody Review review) {
		return new ResponseEntity<Review>(reviewService.saveReview(review), HttpStatus.OK);
	}
	
	@GetMapping()
	public List<Review> getAllReviews() {
		return reviewService.getAllReviews();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Review> getReviewById(@PathVariable("id") long reviewId) {
		return new ResponseEntity<Review>(reviewService.getReviewById(reviewId), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Review> updateReview(@PathVariable("id") long reviewId, @RequestBody Review review) {
		return new ResponseEntity<Review>(reviewService.updateReview(review, reviewId), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteReview(@PathVariable("id") long reviewId) {
		reviewService.deleteReview(reviewId);
		return new ResponseEntity<String>("Review deleted succesfully.", HttpStatus.OK);
	}
}
