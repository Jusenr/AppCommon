package com.myself.appcommon.activity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dsw.calendar.Test;
import com.myself.appcommon.R;
import com.myself.appcommon.api.HttpTag;
import com.myself.appcommon.base.BaseActivity;
import com.myself.appcommon.base.Main2Activity;
import com.myself.appcommon.base.Main3Activity;
import com.myself.appcommon.calendar.caldroidsample.CaldroidSampleActivity;
import com.myself.appcommon.calendar.calendarcomponent.CalendarActivity;
import com.myself.appcommon.calendar.mycalendar.MyCalendarActivity;
import com.myself.appcommon.calendar.mycalendar2.mainview.Calendar2Activity;
import com.myself.appcommon.calendar.timessquare.SampleTimesSquareActivity;
import com.myself.appcommon.config.Constants;
import com.myself.appcommon.http.HttpEngine;
import com.myself.appcommon.http.command.HttpDataResponse;
import com.myself.appcommon.http.command.HttpPostRequest;
import com.myself.appcommon.http.task.TaskManager;
import com.myself.appcommon.manager.ThemeSettingsHelper;
import com.myself.appcommon.util.DialogUtil;

public class MainActivity extends BaseActivity implements HttpDataResponse, ThemeSettingsHelper.ThemeCallback {
    public static final String TAG = "Calendar2Activity";

    private ThemeSettingsHelper mThemeSettingsHelper;
    private Button mTestSendRequest;
    private Button mTestReact;
    private Button mTestReact2;
    private Button mTestWebview;
    private Button mTestChoice;
    private Button mTestChoice2;
    private Button mCalendar;
    private Button mCaldroidSample;
    private Button mMyCalendar;
    private Button mCalendar2;
    private Button mCalendar3;
    private Button mTest;
    private Button mBasic;
    private Button mBase;

    @Override
    public boolean needTranslucent() {
        return true;
    }

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initStaticData() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        mThemeSettingsHelper = ThemeSettingsHelper.getThemeSettingsHelper(this);
        mThemeSettingsHelper.changeTheme(this, ThemeSettingsHelper.THEME_NIGHT);
        setStatusBarAlpha(0);
        mTestSendRequest = (Button) findViewById(R.id.test_send_request);
        mTestReact = (Button) findViewById(R.id.test_react);
        mTestReact2 = (Button) findViewById(R.id.test_react2);
        mTestWebview = (Button) findViewById(R.id.test_webview);
        mTestChoice = (Button) findViewById(R.id.test_choice);
        mTestChoice2 = (Button) findViewById(R.id.test_choice2);
        mCalendar = (Button) findViewById(R.id.test_calendar);
        mCaldroidSample = (Button) findViewById(R.id.test_caldroid_sample);
        mMyCalendar = (Button) findViewById(R.id.test_my_calendar);
        mCalendar2 = (Button) findViewById(R.id.test_calendar2);
        mCalendar3 = (Button) findViewById(R.id.test_calendar3);
        mTest = (Button) findViewById(R.id.test_this);
        mBasic = (Button) findViewById(R.id.test_basic);
        mBase = (Button) findViewById(R.id.test_base);
    }

    @Override
    public void initListener() {
        mThemeSettingsHelper.registerThemeCallback(this);
        mTestSendRequest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goToActivity(NextActivity.class, false);
                sendRequest();
            }
        });
        mTestReact.setVisibility(View.GONE);
        mTestReact2.setVisibility(View.GONE);
        mTestReact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                goToActivity(ReactNativeActivity.class, false);
            }
        });
        mTestReact2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                goToActivity(ReactNative2Activity.class, false);
            }
        });
        mTestWebview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goToActivity(WebviewActivity.class, false);
            }
        });
        mTestChoice.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goToActivity(ChoiceTestActivity.class, false);
            }
        });
        mTestChoice2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goToActivity(ChoiceTest2Activity.class, false);
            }
        });
        mCalendar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goToActivity(CalendarActivity.class, false);
            }
        });
        mCaldroidSample.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goToActivity(CaldroidSampleActivity.class, false);
            }
        });
        mMyCalendar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goToActivity(MyCalendarActivity.class, false);
            }
        });
        mCalendar2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goToActivity(Calendar2Activity.class, false);
            }
        });
        mCalendar3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goToActivity(SampleTimesSquareActivity.class, false);
            }
        });
        mTest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Test.getLastMonthDays();
            }
        });
        mBasic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goToActivity(Main2Activity.class, false);
            }
        });
        mBase.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goToActivity(Main3Activity.class, false);
            }
        });
    }

    @Override
    public void onHttpRecvOK(HttpTag tag, Object extraInfo, Object result) {
        DialogUtil.showToast(this, (String) result, Toast.LENGTH_LONG);
//        Log.e(TAG, "onHttpRecvOK: " + result);
    }

    @Override
    public void onHttpRecvError(HttpTag tag, HttpEngine.HttpCode retCode, String msg) {
        DialogUtil.showToast(this, "onHttpRecvError retCode:" + retCode + " msg:" + msg, Toast.LENGTH_LONG);
    }

    @Override
    public void onHttpRecvCancelled(HttpTag tag) {
        DialogUtil.showToast(this, "onHttpRecvCancelled", Toast.LENGTH_LONG);
    }

    private void sendRequest() {
        HttpPostRequest request = new HttpPostRequest();
        request.setTag(HttpTag.TEST);
        request.setSort(Constants.REQUEST_METHOD_POST); // application/x-www-form-urlencoded
        //request.setSort(Constants.REQUEST_METHOD_POST_MULTIPLE); // multipart/form-data
        request.setGzip(true);
        request.setRetry(false);
        request.setNeedAuth(false);
        TaskManager.startHttpDataRequset(request, this);

    }

    @Override
    public void applyTheme() {
        if (mThemeSettingsHelper.isDefaultTheme()) {

        }
    }
}
