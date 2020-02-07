package app.bt68.fmapp.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import java.util.ArrayList;
import java.util.List;

import app.bt68.fmapp.R;
import app.bt68.fmapp.SplashScreenViewModel;
import app.bt68.fmapp.base.BaseFragment;
import app.bt68.fmapp.base.MovementManager;
import app.bt68.fmapp.base.constantsutils.Codes;
import app.bt68.fmapp.databinding.FragmentHomeBinding;
import app.bt68.fmapp.home.adapter.HomeSliderAdapter;
import app.bt68.fmapp.home.viewModels.HomeViewModels;
import app.bt68.fmapp.onBoard.IntroItem;
import app.bt68.fmapp.onBoard.OnBoardAdapter;


public class HomeFragment extends BaseFragment {
    FragmentHomeBinding homeBinding;
    HomeViewModels homeViewModels;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        homeViewModels = new HomeViewModels();
        homeBinding.setHomeViewModels(homeViewModels);
        liveDataListeners();
        checkConnection();
        // fill list screen

        final List<IntroItem> mList = new ArrayList<>();
        mList.add(new IntroItem("", "", R.drawable.home_slide1));
        mList.add(new IntroItem("", "", R.drawable.home_slide2));
        mList.add(new IntroItem("", "", R.drawable.home_slide3));
        mList.add(new IntroItem("", "", R.drawable.home_slide4));
        HomeSliderAdapter onBoardAdapter = new HomeSliderAdapter();
        onBoardAdapter.updateData(mList);
        homeBinding.imageSlider.setSliderAdapter(onBoardAdapter);
        return homeBinding.getRoot();
    }


    private void liveDataListeners() {
        homeViewModels.getClicksMutableLiveData().observe(this, result -> {
            if (result == View.VISIBLE || result == View.GONE) {
                accessLoadingBar(result);
            }
        });
        ConnectionLiveData.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isConnected) {
                if (isConnected) {
                    homeViewModels.getHomeData();
                } else {
                    showMessage(getActivity().getResources().getString(R.string.connection_invaild_msg), 0, 1);
                }
            }
        });

    }
}
