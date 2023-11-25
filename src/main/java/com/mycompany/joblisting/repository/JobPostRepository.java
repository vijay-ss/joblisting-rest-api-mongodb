package com.mycompany.joblisting.repository;

import com.mycompany.joblisting.model.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobPostRepository extends MongoRepository<JobPost, String> {

}
