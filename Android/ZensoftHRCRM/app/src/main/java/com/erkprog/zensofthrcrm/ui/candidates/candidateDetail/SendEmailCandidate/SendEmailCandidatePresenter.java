package com.erkprog.zensofthrcrm.ui.candidates.candidateDetail.SendEmailCandidate;

import com.erkprog.zensofthrcrm.data.db.SQLiteHelper;
import com.erkprog.zensofthrcrm.data.network.ApiInterface;

public class SendEmailCandidatePresenter implements SendEmailCandidateContract.Presenter {

  private SendEmailCandidateContract.View mView;
  private ApiInterface mService;


  SendEmailCandidatePresenter(ApiInterface service) {
    mService = service;
  }

  @Override
  public void bind(SendEmailCandidateContract.View view) {
    mView = view;
  }

  @Override
  public void unbind() {
    mView = null;
  }

  private boolean isViewAttached() {
    return mView != null;
  }

  @Override
  public void sendEmail() {

  }

  @Override
  public void getTemplates() {

  }
}
