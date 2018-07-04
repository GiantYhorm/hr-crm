package com.erkprog.zensofthrcrm.data.network.test;

import com.erkprog.zensofthrcrm.data.entity.Candidate;
import com.erkprog.zensofthrcrm.data.entity.CandidatesResponse;
import com.erkprog.zensofthrcrm.data.entity.CriteriasResponse;
import com.erkprog.zensofthrcrm.data.entity.Interview;
import com.erkprog.zensofthrcrm.data.entity.InterviewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestServiceTest {

  @GET("/all_candidates")
  Call<CandidatesResponse> getCandidates();

  @GET("/all_criterias")
  Call<CriteriasResponse> getCriteries();

  @GET("/candidate_detail")
  Call<Candidate> getDetailedCandidate();

  @GET("/all_interviews")
  Call<InterviewsResponse> getInterviews();

  @GET("/interviews/{interview_id}")
  Call<Interview> getDetailedInterview(@Path("interview_id") Integer interviewiId);

}
