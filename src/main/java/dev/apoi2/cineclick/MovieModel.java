package dev.apoi2.cineclick;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies") // For setting up the table I am gonna work with
@Data // for automatically create getter and setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieModel {
    @Id // This annotation only affects the "id" variable is below
    private ObjectId id; // Now this is gonna behave as the primary key in the mongoDB table
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference // This is for making a relation with the review document trough spring boot
    private List<ReviewModel> reviewIds;
}
