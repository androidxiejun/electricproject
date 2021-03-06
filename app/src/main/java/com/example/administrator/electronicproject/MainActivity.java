package com.example.administrator.electronicproject;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.administrator.electronicproject.ClassifyFragment.ClassifyFragment;
import com.example.administrator.electronicproject.FashionFragment.bean.DatasUtils;
import com.example.administrator.electronicproject.FashionFragment.view.FashionFragment;
import com.example.administrator.electronicproject.MessageFragment.MessageFragment;
import com.example.administrator.electronicproject.MineFragment.MineFragment;
import com.example.administrator.electronicproject.StoreFragment.StoreFragment;

public class MainActivity extends AppCompatActivity {
    private RadioGroup mRadioGroup;
    private StoreFragment storeFragment;
    private ClassifyFragment classifyFragment;
    private FashionFragment fashionFragment;
    private MessageFragment messageFragment;
    private MineFragment mineFragment;
    private FragmentManager manager;
    private Fragment mCurrentShowFragment;
    private RadioButton fasionBtn;
    private boolean isExit=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
        chooseRadioBtn();
        //默认选择时尚圈
        fasionBtn.setChecked(true);
        //获取屏幕的宽高
        DatasUtils.windowHight = getWindowManager().getDefaultDisplay().getHeight();
        DatasUtils.windowWight = getWindowManager().getDefaultDisplay().getWidth();
    }


    private Handler mHandler=new Handler(){
       @Override
       public void handleMessage(Message msg) {
           isExit=false;
       }
   };

    /**
     * 点击两次再退出程序
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            exit();
            return  false;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void exit(){
        if(isExit){
            finish();
            System.exit(0);
        }else{
            isExit=true;
            Toast.makeText(MainActivity.this, "再按一次，退出明星衣橱", Toast.LENGTH_SHORT).show();
            mHandler.sendEmptyMessageDelayed(0,2000);

        }
    }
    /**
     * 对fragment进行初始化
     */
    private void initFragment() {
        storeFragment=StoreFragment.newInstance();
        classifyFragment=ClassifyFragment.newInstance();
        fashionFragment=FashionFragment.newInstance();
        messageFragment=MessageFragment.newInstance();
        mineFragment=MineFragment.newInstance();
    }

    /**
     * 对控件进行初始化
     */
    private void initView() {
        mRadioGroup= (RadioGroup) findViewById(R.id.radio_group);
        manager=getSupportFragmentManager();
        fasionBtn= (RadioButton) findViewById(R.id.radio_button_fashion);
    }

    /**
     * 当点击RadioButton时会执行此方法，加载相应的fragment视图
     * @param fragment
     */
    private void chooseFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        if (mCurrentShowFragment != null && mCurrentShowFragment.isAdded()) {
            fragmentTransaction.hide(mCurrentShowFragment);
        }
        if (!fragment.isAdded()) {
            fragmentTransaction.add(R.id.frame_layout,fragment);
        } else {
            fragmentTransaction.show(fragment);
        }
        fragmentTransaction.commit();
        mCurrentShowFragment = fragment;
    }
    /**
     * 对RadioGroup行点击监听，选择不同的fragment
     */
    private void chooseRadioBtn() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radio_button_home:
                       chooseFragment(storeFragment);
                        break;
                    case R.id.radio_button_divider:
                        chooseFragment(classifyFragment);
                        break;
                    case R.id.radio_button_fashion:
                        chooseFragment(fashionFragment);
                        break;
                    case R.id.radio_button_message:
                        chooseFragment(messageFragment);
                        break;
                    case R.id.radio_button_mine:
                        chooseFragment(mineFragment);
                        break;
                }
            }
        });
    }


}
