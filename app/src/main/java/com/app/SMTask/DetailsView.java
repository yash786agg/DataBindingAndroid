package com.app.SMTask;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import com.app.SMTask.databinding.DetailsViewLayoutBinding;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * Created by Yash on 13/6/18.
 */

public class DetailsView extends AppCompatActivity implements View.OnClickListener
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        /* Intialization of DetailsView Data Binding */
        DetailsViewLayoutBinding binding = DataBindingUtil.setContentView(this,R.layout.details_view_layout);

         /* Intialization of ButterKnife */
        ButterKnife.bind(this);

        // Getting data in bundle form Previous Screen.
        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            String htmlTxtParams = bundle.getString(getString(R.string.htmlTxtParams));

            if (!TextUtils.isEmpty(htmlTxtParams))
                binding.setLoadData(htmlTxtParams);
        }
    }

    @Override//Click listener on backBtn
    @OnClick({R.id.backBtn})
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.backBtn:
                moveToPreviousScreen();
                break;
        }
    }

    @Override
    public void onBackPressed()
    {
        moveToPreviousScreen();
    }

    private void moveToPreviousScreen()
    {
        finish();
    }
}
