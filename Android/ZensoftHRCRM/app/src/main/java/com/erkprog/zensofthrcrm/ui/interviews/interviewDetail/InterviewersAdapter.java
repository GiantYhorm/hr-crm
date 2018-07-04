package com.erkprog.zensofthrcrm.ui.interviews.interviewDetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.erkprog.zensofthrcrm.R;
import com.erkprog.zensofthrcrm.data.entity.Interviewer;

import java.util.List;

class InterviewersAdapter extends BaseAdapter {
  private Context mContext;
  private LayoutInflater mLayoutInflater;
  private List<Interviewer> mInterviewerList;
  private EvaluationsAdapter mEvaluationsAdapter;

  InterviewersAdapter(Context context, List<Interviewer> interviewerList, EvaluationsAdapter
      mEvaluationsAdapter) {
    mContext = context;
    mInterviewerList = interviewerList;
    mLayoutInflater = LayoutInflater.from(mContext);
    this.mEvaluationsAdapter = mEvaluationsAdapter;
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
    mEvaluationsAdapter.setData(interviewer.getEvaluationList());

    mComment.setText(interviewer.getComment());
    mInterviewer.setText(interviewer.getUser().getEmail());


    return v;
  }
}