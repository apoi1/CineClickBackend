package dev.apoi2.cineclick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public ReviewModel createReview(String reviewBody, String imdbId){
        ReviewModel review = reviewRepository.insert(new ReviewModel(reviewBody));

        mongoTemplate.update(MovieModel.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                    .apply(new Update().push("reviewIds").value(review.getId()))
                    .first();

        return review;
    }
}
