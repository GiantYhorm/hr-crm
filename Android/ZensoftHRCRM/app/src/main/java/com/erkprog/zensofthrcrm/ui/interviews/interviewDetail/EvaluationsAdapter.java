package com.erkprog.zensofthrcrm.ui.interviews.interviewDetail;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.erkprog.zensofthrcrm.R;
import com.erkprog.zensofthrcrm.data.entity.Evaluation;

import java.util.List;

class EvaluationsAdapter extends BaseAdapter {
  private Context mContext;
  private LayoutInflater mLayoutInflater;
  private List<Evaluation> mEvaluationList;

  EvaluationsAdapter(Context context, List<Evaluation> evaluationList) {
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

    rate.setText("" + evaluation.getRate());
    criteria.setText(evaluation.getCriteria().getName());

    return v;
  }
}


