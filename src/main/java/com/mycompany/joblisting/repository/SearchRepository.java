package com.mycompany.joblisting.repository;

import com.mycompany.joblisting.model.JobPost;

import java.util.List;

public interface SearchRepository {
    List<JobPost> findByText(String text);
}
