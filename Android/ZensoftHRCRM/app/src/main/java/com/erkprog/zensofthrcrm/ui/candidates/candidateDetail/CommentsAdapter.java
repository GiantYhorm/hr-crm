package com.erkprog.zensofthrcrm.ui.candidates.candidateDetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.erkprog.zensofthrcrm.R;
import com.erkprog.zensofthrcrm.data.entity.Comment;
import com.erkprog.zensofthrcrm.data.entity.User;

import java.util.List;

class CommentsAdapter extends BaseAdapter {
  private List<Comment> mCommentsList;

  CommentsAdapter(List<Comment> data) {
    mCommentsList = data;
  }

  public void setData(List<Comment> newData) {
    mCommentsList = newData;
    this.notifyDataSetChanged();
  }

  @Override
  public int getCount() {
    return mCommentsList.size();
  }

  @Override
  public Object getItem(int position) {
    return mCommentsList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    ViewHolder holder;

    if (convertView == null) {
      convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cd_comment_item, parent, false);
      holder = new ViewHolder(convertView);

      convertView.setTag(holder);
    } else {
      holder = (ViewHolder) convertView.getTag();
    }

    Comment comment = (Comment) getItem(position);

    if (comment != null) {
      User user = comment.getCreatedBy();
      holder.date.setText(comment.getCreated());
      holder.text.setText(comment.getText());

      if (user != null) {
        String name = String.format("%1s %2s", user.getFirstName(), user.getLastName());
        holder.createdBy.setText(name);
      }

    }

    return convertView;
  }

  static class ViewHolder {

    TextView createdBy;
    TextView date;
    TextView text;

    ViewHolder(View v) {
      createdBy = v.findViewById(R.id.cd_comment_username);
      date = v.findViewById(R.id.cd_comment_date);
      text = v.findViewById(R.id.cd_comment_text);
    }
  }
}