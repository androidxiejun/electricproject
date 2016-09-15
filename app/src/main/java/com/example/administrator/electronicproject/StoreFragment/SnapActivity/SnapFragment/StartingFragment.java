package com.example.administrator.electronicproject.StoreFragment.SnapActivity.SnapFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.electronicproject.R;
import com.example.administrator.electronicproject.StoreFragment.SnapActivity.SnapBean.StartingBean;
import com.example.administrator.electronicproject.StoreFragment.SnapActivity.SnapUtils.SnapHttpUtils;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/9/13.
 */
public class StartingFragment extends Fragment {
    private Context context;
    private PullToRefreshListView mListView;
    private MyListTwoAdapter adapter;
    private List<StartingBean.DataBean.ItemsBean> items;
    public static StartingFragment newInstance(){
        return new StartingFragment();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.snap_snaping_fragment,container,false);
        initView(view);
        initInfo();
        return view;
    }

    private void initInfo() {
        SnapHttpUtils.create().queryStartingBean().enqueue(new Callback<StartingBean>() {
            @Override
            public void onResponse(Call<StartingBean> call, Response<StartingBean> response) {
                items= response.body().getData().getItems();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<StartingBean> call, Throwable t) {

            }
        });
    }

    private void initView(View view) {
        View view2=LayoutInflater.from(context).inflate(R.layout.snap_foot_item,null);
        mListView= (PullToRefreshListView) view.findViewById(R.id.snap_pull_to_list_view);
        adapter=new MyListTwoAdapter();
        ListView refreshableView = mListView.getRefreshableView();
        refreshableView.addFooterView(view2);
        mListView.setAdapter(adapter);
    }
    class MyListTwoAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return items == null ? 0 : items.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view2, ViewGroup viewGroup) {
            StartingBean.DataBean.ItemsBean.ComponentBean component = items.get(i).getComponent();
            View view = view2;
            ViewHolder viewHolder = null;
            if(view==null){
                view = LayoutInflater.from(context).inflate(R.layout.snap_list_view_two_item, viewGroup,false);
                viewHolder=new ViewHolder(view);
            }else{
                viewHolder= (ViewHolder) view.getTag();
            }
            viewHolder.title.setText(component.getTitle());
            Picasso.with(context).load(component.getPicUrl()).into(viewHolder.imageView);
            return view;
        }

        class ViewHolder {
            public ImageView imageView;
            public TextView title;

            public ViewHolder(View view) {
                view.setTag(this);
                this.imageView = (ImageView) view.findViewById(R.id.snap_list_view_two_img);
                this.title = (TextView) view.findViewById(R.id.snap_list_view_two_title);
            }
        }
    }
}
