package com.android.zk.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.zk.mvc.mvp.mvvm.R;
import com.android.zk.mvp.contract.MvpContract;
import com.android.zk.mvp.presenter.MvpPresenterImpl;

/**
 * MvpFragment
 *
 * @author zhukui
 */
public class MvpFragment extends Fragment implements MvpContract.View {

    private static final String ARG_PARAM_1 = "param_1";

    private String mParam1;

    private TextView mTextView;

    private MvpContract.Presenter mPresenter;

    public static MvpFragment newInstance(String param1) {
        MvpFragment fragment = new MvpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM_1);
        }
        //初始化presenter
        mPresenter = new MvpPresenterImpl(this);
        setPresenter(mPresenter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mvp, container, false);
        mTextView = view.findViewById(R.id.tv_result);
        final Button button = view.findViewById(R.id.btn_get_data);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getData();
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.start();
        mPresenter.getData();
    }

    @Override
    public void showLoading() {
        Toast.makeText(getContext(), "Loading...", Toast.LENGTH_LONG).show();
    }

    @Override
    public void refreshUI(String result) {
        mTextView.setText(result);
    }

    @Override
    public void showError() {

    }

    @Override
    public void setPresenter(MvpContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter.detachView();
    }
}
