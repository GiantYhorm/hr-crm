package com.erkprog.zensofthrcrm.ui.interviews.interviewDetail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.erkprog.zensofthrcrm.R;
import com.erkprog.zensofthrcrm.data.entity.Evaluation;
import com.erkprog.zensofthrcrm.data.entity.Interview;
import com.erkprog.zensofthrcrm.data.entity.Interviewer;
import com.erkprog.zensofthrcrm.data.network.interviews.InterviewsRepository;

import java.util.ArrayList;
import java.util.List;

public class InterviewDetailFragment extends Fragment implements InterviewDetailContract.View {

  private InterviewDetailContract.Presenter mPresenter;
  private ProgressBar progressBar;
  private RecyclerView.LayoutManager layoutManager;
  private Context mContext;


  private InterviewersAdapter mInterviewersAdapter;
  private EvaluationAdapter mEvaluationAdapter;

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

    mInterviewersAdapter = new InterviewersAdapter(getActivity(), new ArrayList<Interviewer>());
    mEvaluationAdapter = new EvaluationAdapter(getActivity(), new ArrayList<Evaluation>());
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


  class InterviewersAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<Interviewer> mInterviewerList;

    InterviewersAdapter(Context context, List<Interviewer> interviewerList) {
      mContext = context;
      mInterviewerList = interviewerList;
      mLayoutInflater = LayoutInflater.from(mContext);
    }

    public void setData(List<Interviewer> newData) {
      mInterviewerList = newData;
      this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
      return mInterviewerList.size();
    }

    @Override
    public Object getItem(int position) {
      return mInterviewerList.get(position);
    }

    @Override
    public long getItemId(int position) {
      return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      View v = mLayoutInflater.inflate(R.layout.interview_interviewer_comment_item, parent, false);

      TextView mComment = v.findViewById(R.id.interview_interviewer_comment);
      TextView mInterviewer = v.findViewById(R.id.interviewer_label);

      Interviewer interviewer = (Interviewer) getItem(position);
      mEvaluationAdapter.setData(interviewer.getEvaluationList());

      mComment.setText(interviewer.getComment());
      mInterviewer.setText(interviewer.getUser().getEmail());


      return v;
    }
  }

  class EvaluationAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<Evaluation> mEvaluationList;

    EvaluationAdapter(Context context, List<Evaluation> evaluationList) {
      mContext = context;
      mEvaluationList = evaluationList;
      mLayoutInflater = LayoutInflater.from(mContext);
    }

    public void setData(List<Evaluation> newData) {
      mEvaluationList = newData;
      this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
      return mEvaluationList.size();
    }

    @Override
    public Object getItem(int position) {
      return mEvaluationList.get(position);
    }

    @Override
    public long getItemId(int position) {
      return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      View v = mLayoutInflater.inflate(R.layout.interview_evaluation_item, parent, false);

      TextView criteria = v.findViewById(R.id.interview_interviewer_criteria);
      TextView rate = v.findViewById(R.id.rate);

      Evaluation evaluation = (Evaluation) getItem(position);

      Log.d("me", "dfdf = " + evaluation);

      rate.setText("" + evaluation.getRate());
      criteria.setText(evaluation.getCriteria().getName());

      return v;
    }
  }

}
