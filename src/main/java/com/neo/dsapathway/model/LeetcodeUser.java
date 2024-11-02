package com.neo.dsapathway.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeetcodeUser {

    private String username;
    private List<SubmissionNum> acSubmissionNum;

    public static class SubmissionNum {
        private String difficulty;
        private int count;
        private int submissions;
    }
}
