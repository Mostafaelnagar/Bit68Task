package app.bt68.fmapp.onBoard;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import java.util.ArrayList;
import java.util.List;

import app.bt68.fmapp.R;
import app.bt68.fmapp.SplashScreenViewModel;
import app.bt68.fmapp.base.BaseFragment;
import app.bt68.fmapp.base.MovementManager;
import app.bt68.fmapp.base.constantsutils.Codes;
import app.bt68.fmapp.databinding.FragmentOnboardBinding;


public class OnBoardFragment extends BaseFragment {
    FragmentOnboardBinding fragmentOnboardBinding;
    SplashScreenViewModel splashScreenViewModel;
    OnBoardAdapter onBoardAdapter = new OnBoardAdapter();

    public OnBoardFragment() {
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
        fragmentOnboardBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_onboard, container, false);
        splashScreenViewModel = new SplashScreenViewModel();
        fragmentOnboardBinding.setOnBoardViewModels(splashScreenViewModel);
        liveDataListeners();
        // fill list screen

        final List<IntroItem> mList = new ArrayList<>();
        mList.add(new IntroItem("Fresh Food", "Lorem ipsum dolor sit amet, consectetur adipiscing elit ", R.drawable.v1));
        mList.add(new IntroItem("Fast Delivery", "Lorem ipsum dolor sit amet, consectetur adipiscing elit  ", R.drawable.v2));
        mList.add(new IntroItem("Easy Payment", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", R.drawable.v3));
        onBoardAdapter.updateData(mList);
        fragmentOnboardBinding.imageSlider.setSliderAdapter(onBoardAdapter);
        return fragmentOnboardBinding.getRoot();
    }


    private void liveDataListeners() {
        splashScreenViewModel.getClicksMutableLiveData().observe(this, result -> {
            if (result == View.VISIBLE || result == View.GONE) {
                accessLoadingBar(result);
            } else if (result == Codes.CATEGORIES) {
                MovementManager.startBaseActivity(getActivity(), result);
            }
        });


    }
}
