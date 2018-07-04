package com.erkprog.zensofthrcrm.ui.interviews.interviewDetail;

import android.content.Context;
import android.util.Log;

import com.erkprog.zensofthrcrm.data.entity.Interview;


public class InterviewDetailPresenter implements InterviewDetailContract.Presenter,
    InterviewDetailContract.Repository.OnFinishedListener {

  private InterviewDetailContract.View mView;
  private InterviewDetailContract.Repository mRepository;
  private Context mContext;

  public InterviewDetailPresenter(InterviewDetailContract.View mView, InterviewDetailContract.Repository
      mRepository, Context mContext) {
    this.mView = mView;
    this.mRepository = mRepository;
    this.mContext = mContext;
  }


  @Override
  public void onDestroy() {

  }

  @Override
  public void getDetailedInterview(Context mContext, Integer interviewId) {
    mRepository.getInterviewDetails(this, mContext, interviewId);
  }

  @Override
  public void onFinished(Interview interview) {
    mView.showInterviewDetails(interview);
  }

  @Override
  public void onFailure(Throwable t) {
    Log.d("me", "onFailure: " + t.getMessage());
  }
}
