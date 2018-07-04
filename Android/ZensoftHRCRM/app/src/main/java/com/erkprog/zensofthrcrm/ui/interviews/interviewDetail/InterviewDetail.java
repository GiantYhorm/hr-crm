package com.erkprog.zensofthrcrm.ui.interviews.interviewDetail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.erkprog.zensofthrcrm.R;

public class InterviewDetail extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_interview_detail);

    Bundle args = new Bundle();
    args.putInt("interviewId", getIntent().getExtras().getInt("interviewId"));

    FragmentManager fm = getSupportFragmentManager();
    Fragment fragment = fm.findFragmentById(R.id.interview_detail_container);

    if (fragment == null) {
      fragment = new InterviewDetailFragment();
      fragment.setArguments(args);
      fm.beginTransaction()
          .add(R.id.interview_detail_container, fragment)
          .commit();
    }

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }


  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
