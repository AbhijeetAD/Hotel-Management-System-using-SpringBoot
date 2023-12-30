package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Review;

import com.example.demo.exceptionhandling.ReviewsNotFoundException;
import com.example.demo.repository.ReviewRepository;

import com.example.demo.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(int reviewId, Review updatedReview) {
        Review existingReview = reviewRepository.findById(reviewId).orElse(null);

        if (existingReview != null) {
            existingReview.setComment(updatedReview.getComment());
            existingReview.setRating(updatedReview.getRating());

            return reviewRepository.save(existingReview);
        } else {
            throw new ReviewsNotFoundException(reviewId);
        }
    }

    @Override
    public void deleteReview(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public Review getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewsNotFoundException(reviewId));
    }

    @Override
    public Iterable<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}