package com.erkprog.zensofthrcrm.data.network.test;

import com.erkprog.zensofthrcrm.data.entity.CandidatesResponse;
import com.erkprog.zensofthrcrm.data.entity.CriteriasResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestServiceTest {

    @GET("/all_candidates")
    Call<CandidatesResponse> getCandidates();

    @GET("/all_criterias")
    Call<CriteriasResponse> getCriteries();
}
