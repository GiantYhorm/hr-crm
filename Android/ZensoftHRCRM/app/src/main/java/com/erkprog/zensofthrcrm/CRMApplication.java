package com.erkprog.zensofthrcrm;

import android.app.Application;

import com.erkprog.zensofthrcrm.data.network.NetworkBuilder;
import com.erkprog.zensofthrcrm.data.network.RetrofitService;

public class CRMApplication extends Application {

  private RetrofitService sService;

  @Override
  public void onCreate() {
    super.onCreate();
    sService = NetworkBuilder.initService();
  }

  public RetrofitService getService() {
    return sService;
  }


}
