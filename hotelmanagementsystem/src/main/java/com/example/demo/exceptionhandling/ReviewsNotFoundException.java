package com.example.demo.exceptionhandling;

public class ReviewsNotFoundException extends RuntimeException {

    public ReviewsNotFoundException(int reviewId) {
        super("Review not found with id: " + reviewId);
    }
}