package eu.rodrigocamara.genericsoundboard.screens.profile;

import android.content.Context;
import android.support.v4.view.ViewCompat;
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
import eu.rodrigocamara.genericsoundboard.C;
import eu.rodrigocamara.genericsoundboard.R;
import eu.rodrigocamara.genericsoundboard.data.model.Sound;

/**
 * Created by Rodrigo Câmara on 01/02/2018.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileAdapterViewHolder> {
    private Context mContext;
    private ProfileAdapter.ListItemClickListener mOnClickListener;
    private List<Sound> mDataSet;

    public class ProfileAdapterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_sound_image)
        ImageView ivProfilePicture;
        @BindView(R.id.tv_sound_name)
        TextView tvSoundName;

        private ProfileAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnClickListener.onListItemClick(mDataSet.get(getAdapterPosition()));
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public ProfileAdapter(Context context, ProfileAdapter.ListItemClickListener clickListener) {
        mContext = context;
        mOnClickListener = clickListener;
    }

    public interface ListItemClickListener {
        void onListItemClick(Sound sound);
    }

    public void replaceData(List<Sound> sounds) {
        if (sounds != null) {
            mDataSet = sounds;
        }
        notifyDataSetChanged();
    }

    @Override
    public ProfileAdapter.ProfileAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.sound_item, parent, false);
        return new ProfileAdapter.ProfileAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfileAdapter.ProfileAdapterViewHolder holder, int position) {
        Picasso.with(mContext).load(mDataSet.get(position).getImgURL()).placeholder(R.drawable.ic_launcher_background).into(holder.ivProfilePicture);
        //ViewCompat.setTransitionName(holder.ivProfilePicture, String.valueOf(position) + C.TRANSITION_POSTFIX);
        holder.tvSoundName.setText(mDataSet.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}