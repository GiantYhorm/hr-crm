package com.erkprog.zensofthrcrm.ui.candidates.candidateDetail.SendEmailCandidate;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.erkprog.zensofthrcrm.CRMApplication;
import com.erkprog.zensofthrcrm.R;
import com.erkprog.zensofthrcrm.data.entity.Candidate;
import com.erkprog.zensofthrcrm.ui.candidates.candidateDetail.CandidateDetailFragment;
import com.erkprog.zensofthrcrm.ui.candidates.candidateDetail.editCandidate.RxEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class SendEmailCandidateFragment extends Fragment implements SendEmailCandidateContract.View {

  private SendEmailCandidateContract.Presenter mPresenter;
  private Candidate mCandidate;

  @BindView(R.id.se_progress_bar)
  ProgressBar mProgressBar;

  @BindView(R.id.se_message)
  EditText mMessage;

  @BindView(R.id.se_save)
  Button mSave;

  @BindView(R.id.se_subject)
  EditText mSubject;

  @BindView(R.id.se_use_templates)
  Button mTemplates;

  @BindView(R.id.se_attach)
  Button mAttachments;


  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mPresenter = new SendEmailCandidatePresenter(CRMApplication.getInstance(requireContext())
        .getApiService());
    mPresenter.bind(this);


  }


  @Override
  public void onDestroy() {
    super.onDestroy();
    mPresenter.unbind();
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_send_email_candidate, container, false);
    Bundle bundle = getArguments();

    ButterKnife.bind(this, v);

    if (bundle != null)
      mCandidate = (Candidate) bundle.getSerializable("candidate");

    setViews();


    dismissProgress();


    return v;
  }

  private void setViews() {

  }

  private void subscribeObs() {


  }

  @Override
  public void dismissProgress() {
    mProgressBar.setVisibility(View.GONE);
  }


  @Override
  public void showMessage(String message) {
    dismissProgress();
    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
  }

  @Override
  public boolean hasInternetConnection(Context context) {
    ConnectivityManager connectivityManager
        = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    if (connectivityManager != null) {
      NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
      return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    return false;
  }

  @Override
  public void showProgress() {

    mProgressBar.setVisibility(View.VISIBLE);
  }

  @Override
  public void showTemplates() {

  }

  @Override
  public void onEmailSent() {

  }


}