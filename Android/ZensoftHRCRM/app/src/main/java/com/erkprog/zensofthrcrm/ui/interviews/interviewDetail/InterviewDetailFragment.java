package com.erkprog.zensofthrcrm.ui.interviews.interviewDetail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.erkprog.zensofthrcrm.R;
import com.erkprog.zensofthrcrm.data.entity.Evaluation;
import com.erkprog.zensofthrcrm.data.entity.Interview;
import com.erkprog.zensofthrcrm.data.entity.Interviewer;
import com.erkprog.zensofthrcrm.data.network.interviews.InterviewsRepository;

import java.util.ArrayList;
import java.util.List;

public class InterviewDetailFragment extends Fragment implements InterviewDetailContract.View {

  private static final String EXTRA_INTERVIEW_ID = "interview_id";

  private InterviewDetailContract.Presenter mPresenter;
  private Context mContext;

  private RecyclerView recyclerView;
  private RecyclerView.LayoutManager layoutManager;

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

    initUI(v);

    mPresenter = new InterviewDetailPresenter(this, new InterviewsRepository(this.getContext()),
        v.getContext());
    mPresenter.getDetailedInterview(mContext, getArguments().getInt(EXTRA_INTERVIEW_ID));

    recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_all_interviewers);

    return v;
  }

  private void initUI(View v) {
    mLayout = v.findViewById(R.id.cd_root_layout);
    mDepartment = v.findViewById(R.id.i_department);
    mInitial = v.findViewById(R.id.i_initial);
    mDate = v.findViewById(R.id.i_date);

  }

  @Override
  public void showInterviewDetails(Interview interview) {

    Log.d("me", "showInterviewDetails: " + interview.getCandidate().getPosition().getDepartment().getName());
    mDepartment.setText(interview.getCandidate().getPosition().getDepartment().getName());
    mInitial.setText(interview.getCandidate().getFirstName().toString() + " " + interview.getCandidate()
        .getLastName().toString());
    mDate.setText(interview.getDate());

    List<Title> list = getList(interview.getInterviewersList());



    InterviewersAdapter adapter = new InterviewersAdapter(mContext, list);
    recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    recyclerView.setAdapter(adapter);


  }

  private List<Title> getList(List<Interviewer> interviewers) {
    List<Title> list = new ArrayList<>();
    for (int i = 0; i < interviewers.size(); i++) {
      List<SubTitle> subTitles = new ArrayList<>();
      SubTitle subTitle;

      for (int j = 0; j< interviewers.get(i).getEvaluaionList().size(); j++){
        Evaluation evaluation = interviewers.get(i).getEvaluaionList().get(j);
        subTitle = new SubTitle(evaluation.getCriteria().getName(),evaluation.getRate());
        if(j==0)
        subTitle.setComment(interviewers.get(i).getComment());
        subTitles.add(subTitle);
      }


      Title model = new Title(interviewers.get(i).getUser().getEmail(),
          subTitles);
      list.add(model);
    }
    return list;
  }

  @Override
  public void showLoadingInterviewError() {

  }

  @Override
  public void showToast(String message) {

  }

}

