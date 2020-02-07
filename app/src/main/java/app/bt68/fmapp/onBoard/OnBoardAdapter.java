package app.bt68.fmapp.onBoard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

import app.bt68.fmapp.R;


public class OnBoardAdapter extends SliderViewAdapter<OnBoardAdapter.SliderAdapterVH> {
    private List<IntroItem> pagerList;
    private Context context;

    public OnBoardAdapter() {
        pagerList = new ArrayList<>();
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.onboard_slider_item, null);
        context = parent.getContext();
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        IntroItem introItem = pagerList.get(position);
        Glide.with(context).load(introItem.getImg()).into(viewHolder.imageViewBackground);
        viewHolder.title.setText(introItem.getTitle());
        viewHolder.desc.setText(introItem.getDesc());
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return pagerList.size();
    }

    public void updateData(@Nullable List<IntroItem> data) {
        this.pagerList.clear();
        this.pagerList.addAll(data);
        notifyDataSetChanged();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {
        View itemView;
        ImageView imageViewBackground;
        TextView title, desc;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            title = itemView.findViewById(R.id.tv_board_title);
            desc = itemView.findViewById(R.id.tv_board_desc);
            this.itemView = itemView;
        }
    }
}