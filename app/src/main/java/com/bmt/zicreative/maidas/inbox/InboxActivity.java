package com.bmt.zicreative.maidas.inbox;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.bmt.zicreative.maidas.R;
import com.bmt.zicreative.maidas.base.BaseActivity;
import com.bmt.zicreative.maidas.base.BasePresenter;
import com.bmt.zicreative.maidas.history.HistoryActivity;
import com.bmt.zicreative.maidas.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

/**
 * Created By Herwin DJ on 10/18/2018
 **/

public class InboxActivity extends BaseActivity implements InboxContract.View {

    @Inject
    InboxPresenter inboxPresenter;

    @BindView(R.id.tv_inbox_kosong)
    TextView tvInboxKosong;

    @Override
    protected void bindData() {

    }

    @BindView(R.id.inbox_list_view)
    RecyclerView rvInbox;

    @Override
    public int getLayout() {
        return R.layout.inbox_activity;
    }

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        showBackIconToolbar(true);
        setTitleToolbar("Inbox Notification");
        tvInboxKosong.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            startActivity(new Intent(InboxActivity.this, MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public BasePresenter attachPresenter() {
        return inboxPresenter;
    }

    @Override
    public void onDataSuccess() {

    }

    @Override
    public void onDataFailure(String message) {

    }
}
