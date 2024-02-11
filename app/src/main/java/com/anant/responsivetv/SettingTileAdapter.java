package com.anant.responsivetv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SettingTileAdapter
        extends RecyclerView.Adapter<SettingTileAdapter.SettingsViewHolder> {
    private List<SettingsTileModel> mSettingsTileList;
    private Context mContext;
    private int mRowCount;
    private ISettingsTileClickListener mTileClickListener;
    private boolean mIsTapConnected;

    public interface ISettingsTileClickListener {
        void onTileItemClicked(SettingsTileModel item);
    }

    public SettingTileAdapter(Context context, ISettingsTileClickListener tileClickListener,
                              List<SettingsTileModel> settingsTileList, int rowCount,
                              boolean tapConnected) {
        mSettingsTileList = settingsTileList;
        mTileClickListener = tileClickListener;
        mContext = context;
        mRowCount = rowCount;
        mIsTapConnected = tapConnected;
    }

    class SettingsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView mImgStatusIndicator, mImgTileIcon;
        TextView mTxtTileLabel;
        CardView mCardView;
        SettingsTileModel mTileModel;

        SettingsViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            mCardView = (CardView) v;
            mTxtTileLabel = v.findViewById(R.id.txt_tile_label);
            mImgStatusIndicator = v.findViewById(R.id.img_status_indicator);
            mImgTileIcon = v.findViewById(R.id.img_tile_icon);
        }

        public void setData(SettingsTileModel settingTile) {
            mTileModel = settingTile;
            mTxtTileLabel.setText(settingTile.getTileName());
            mImgTileIcon.setBackgroundResource(settingTile.getTileIconIdNormal());
            mImgStatusIndicator.setBackgroundResource(settingTile.getTileStatusId());
        }

        @Override
        public void onClick(View v) {
            if (mTileClickListener != null) {
                mTileClickListener.onTileItemClicked(mTileModel);
            }
        }
    }

    @Override
    public SettingsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.grid_item_settings, parent, false);
        return new SettingsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SettingsViewHolder holder, int position) {
        SettingsTileModel settingTile = mSettingsTileList.get(position);
        holder.setData(settingTile);
        holder.mCardView.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                holder.mCardView.setCardBackgroundColor(
                        ContextCompat.getColor(mContext, R.color.purple_color));
                holder.mTxtTileLabel
                        .setTextColor(ContextCompat.getColor(mContext, android.R.color.white));
                holder.mImgTileIcon.setBackgroundResource(settingTile.getTileIconIdFocused());
            } else {
                holder.mCardView.setCardBackgroundColor(
                        ContextCompat.getColor(mContext, android.R.color.white));
                holder.mTxtTileLabel
                        .setTextColor(ContextCompat.getColor(mContext, R.color.dark_text));
                holder.mImgTileIcon.setBackgroundResource(settingTile.getTileIconIdNormal());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSettingsTileList.size();
    }

}