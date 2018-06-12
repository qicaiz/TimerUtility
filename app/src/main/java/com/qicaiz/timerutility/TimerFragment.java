package com.qicaiz.timerutility;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimerFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button mCalculateBtn;
    private RadioGroup mTimerGroup;
    private RadioGroup mMethodGroup;
    private RadioGroup mUnitGroup;
    private EditText mFrequency;
    private EditText mDelay;
    private TextView mTvResult;

    public TimerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TimerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TimerFragment newInstance(String param1, String param2) {
        TimerFragment fragment = new TimerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timer, container, false);
        mFrequency = (EditText) view.findViewById(R.id.frequency);
        mDelay = (EditText) view.findViewById(R.id.delay);
        mUnitGroup = (RadioGroup) view.findViewById(R.id.rg_unit);
        mTvResult = (TextView) view.findViewById(R.id.tv_result);
        mCalculateBtn = (Button) view.findViewById(R.id.btn_calculate);
        mCalculateBtn.setOnClickListener(this);
        mTimerGroup = (RadioGroup) view.findViewById(R.id.rg_timer);
        mMethodGroup = (RadioGroup) view.findViewById(R.id.rg_method);
        return view;
    }

    @Override
    public void onClick(View v) {
        //获取晶振频率
        double frquency = Double.valueOf(mFrequency.getText().toString()) * Math.pow(10, 6);
        //获取定时时间
        double delay = 0;
        if (mUnitGroup.getCheckedRadioButtonId() == R.id.rb_ms) {
            delay = Float.valueOf(mDelay.getText().toString()) * Math.pow(10, -3);
        } else {
            delay = Float.valueOf(mDelay.getText().toString()) * Math.pow(10, -6);
        }

        mTimerGroup.getCheckedRadioButtonId();
        double result = 0;
        switch (mMethodGroup.getCheckedRadioButtonId()) {
            case R.id.rb_method0:
                break;
            case R.id.rb_method1:
                double delayMaxms = 65536 * 12 / frquency * 1000;
                if (delay > delayMaxms) {
                    // TODO: 2018/6/12 alertdialog
                    break;
                }
                result = 65536 - delay * frquency / 12;
                mTvResult.setText(Integer.toHexString((int) result));
                break;
            case R.id.rb_method2:
                result = 256 - delay * frquency / 12;
                mTvResult.setText(Integer.toHexString((int) result));
                //8位自动重装定时器
                break;
            case R.id.rb_method3:
                break;

        }
    }

}
