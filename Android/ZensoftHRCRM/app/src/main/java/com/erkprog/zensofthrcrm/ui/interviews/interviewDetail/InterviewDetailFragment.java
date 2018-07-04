package com.erkprog.zensofthrcrm.ui.interviews.interviewDetail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.erkprog.zensofthrcrm.R;
import com.erkprog.zensofthrcrm.data.entity.Evaluation;
import com.erkprog.zensofthrcrm.data.entity.Interview;
import com.erkprog.zensofthrcrm.data.entity.Interviewer;
import com.erkprog.zensofthrcrm.data.network.interviews.InterviewsRepository;

import java.util.ArrayList;

public class InterviewDetailFragment extends Fragment implements InterviewDetailContract.View {

  private InterviewDetailContract.Presenter mPresenter;
  private Context mContext;

  private InterviewersAdapter mInterviewersAdapter;
  private EvaluationsAdapter mEvaluationAdapter;

  private LinearLayout mLayout;
  private TextView mInitial;
  private TextView mDepartment;
  private TextView mDate;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_interview_detail, container, false);

    initializeViews(v);

    mPresenter = new InterviewDetailPresenter(this, new InterviewsRepository(this.getContext()),
        v.getContext());
    mPresenter.getDetailedInterview(mContext, getArguments().getInt("interviewId"));

    return v;
  }

  private void initializeViews(View v) {

    mLayout = v.findViewById(R.id.i_root_layout);
    mContext = v.getContext();
    mInitial = v.findViewById(R.id.i_initial);
    mDepartment = v.findViewById(R.id.i_department);
    mDate = v.findViewById(R.id.i_date);

    mEvaluationAdapter = new EvaluationsAdapter(getActivity(), new ArrayList<Evaluation>());
    mInterviewersAdapter = new InterviewersAdapter(getActivity(), new ArrayList<Interviewer>(),mEvaluationAdapter);
  }

  @Override
  public void showInterviewDetails(Interview interview) {

    mDepartment.setText(interview.getCandidate().getPosition().getDepartment().getName());
    mInitial.setText(interview.getCandidate().getFirstName().toString() + " " + interview.getCandidate()
        .getLastName().toString());
    mDate.setText(interview.getDate());

    mInterviewersAdapter.setData(interview.getInterviewersList());

    addViewsToLayout();
  }

  private void addViewsToLayout() {

    addAdapterView(mInterviewersAdapter, mEvaluationAdapter);

  }

  private void addAdapterView(final BaseAdapter interviewers, final BaseAdapter evaluations) {
    int interviewersCount = interviewers.getCount();
    for (int i = 0; i < interviewersCount; i++) {
      View item = interviewers.getView(i, null, null);
      mLayout.addView(item);
      for (int j = 0; j < evaluations.getCount(); j++) {
        View item1 = evaluations.getView(j, null, null);
        mLayout.addView(item1);
      }
    }
  }

  @Override
  public void showLoadingInterviewError() {

  }

  @Override
  public void showToast(String message) {

  }
}

