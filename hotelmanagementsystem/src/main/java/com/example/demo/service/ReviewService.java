package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Review;

import com.example.demo.exceptionhandling.ReviewsNotFoundException;

public interface ReviewService {

	 Review createReview(Review review);

	    Review updateReview(int reviewId, Review updatedReview);

	    void deleteReview(int reviewId);

	    Review getReviewById(int reviewId);

	    Iterable<Review> getAllReviews();

	
	
	
}
