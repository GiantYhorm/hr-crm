package com.erkprog.zensofthrcrm.ui.candidates.candidateDetail.SendEmailCandidate;

import com.erkprog.zensofthrcrm.data.entity.Candidate;
import com.erkprog.zensofthrcrm.ui.BaseView;
import com.erkprog.zensofthrcrm.ui.ILifecycle;

public interface SendEmailCandidateContract extends BaseView {

  interface View extends BaseView {

    void showMessage(String t);

    void showProgress();

    void showTemplates();

    void onEmailSent();

  }

  interface Presenter extends ILifecycle<View> {

    void sendEmail();

    void getTemplates();


  }

}
