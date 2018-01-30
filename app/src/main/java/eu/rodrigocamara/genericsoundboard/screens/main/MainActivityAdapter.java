package eu.rodrigocamara.genericsoundboard.screens.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.rodrigocamara.genericsoundboard.R;
import eu.rodrigocamara.genericsoundboard.data.model.SoundProfile;

/**
 * Created by Rodrigo Câmara on 30/01/2018.
 */

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.MainActivityViewHolder> {
    private Context mContext;
    private ListItemClickListener mOnClickListener;
    private List<SoundProfile> mDataSet;

    public class MainActivityViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_sound_profile_image)
        ImageView ivProfilePicture;
        @BindView(R.id.tv_sound_profile_name)
        TextView tvProfileName;
        @BindView(R.id.tv_sound_profile_sound_quantity)
        TextView tvSoundQuantity;

        private MainActivityViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnClickListener.onListItemClick(mDataSet.get(getAdapterPosition()).getId());
                }
            });
        }
    }

    public MainActivityAdapter(Context context, ListItemClickListener clickListener) {
        mContext = context;
        mOnClickListener = clickListener;
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    public void replaceData(List<SoundProfile> soundProfiles) {
        if (soundProfiles != null) {
            mDataSet = soundProfiles;
        }
        notifyDataSetChanged();
    }

    @Override
    public MainActivityAdapter.MainActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.sound_profile_item, parent, false);
        return new MainActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainActivityViewHolder holder, int position) {
        Picasso.with(mContext).load(mDataSet.get(position).getImgURL()).placeholder(R.drawable.ic_launcher_background).into(holder.ivProfilePicture);
        holder.tvProfileName.setText(mDataSet.get(position).getName());
        holder.tvSoundQuantity.setText(String.valueOf(mDataSet.get(position).getNumberOfSounds()));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
