package com.anant.responsivetv;

import android.content.Context;

public class SettingsTileModel {

    public enum Status {
        OK, ERROR, UPDATE
    }

    public enum SettingTileType {
        TILE_SYNC_PORTAL, TILE_UPDATES, TILE_DISPLAY_AND_AUDIO, TILE_CAMERA, TILE_CONNECTIVITY,
        TILE_PERIPHERALS, TILE_SYSTEM, TILE_INFO
    }

    private SettingTileType mSettingTileType;
    private String mTileName;
    private int mTileIconIdNormal, mTileIconIdFocused, mTileStatusId;
    private Status mTileStatus;

    public SettingsTileModel(Context context, SettingTileType tile, Status initialStatus) {
        mSettingTileType = tile;
        setTileStatus(initialStatus);
        switch (tile) {
            case TILE_SYNC_PORTAL:
                mTileName = context.getString(R.string.sync_portal);
                mTileIconIdNormal = R.drawable.ic_sync_n;
                mTileIconIdFocused = R.drawable.ic_sync_f;
                break;
            case TILE_UPDATES:
                mTileName = context.getString(R.string.updates);
                mTileIconIdNormal = R.drawable.ic_download_n;
                mTileIconIdFocused = R.drawable.ic_download_f;
                break;
            case TILE_DISPLAY_AND_AUDIO:
                mTileName = context.getString(R.string.display_and_audio);
                mTileIconIdNormal = R.drawable.ic_tv_n;
                mTileIconIdFocused = R.drawable.ic_tv_f;
                break;
            case TILE_CAMERA:
                mTileName = context.getString(R.string.camera);
                mTileIconIdNormal = R.drawable.ic_camera_n;
                mTileIconIdFocused = R.drawable.ic_camera_f;
                break;
            case TILE_CONNECTIVITY:
                mTileName = context.getString(R.string.connectivity);
                mTileIconIdNormal = R.drawable.ic_connectivity_n;
                mTileIconIdFocused = R.drawable.ic_connectivity_f;
                break;
            case TILE_PERIPHERALS:
                mTileName = context.getString(R.string.peripherals);
                mTileIconIdNormal = R.drawable.ic_usb_n;
                mTileIconIdFocused = R.drawable.ic_usb_f;
                break;
            case TILE_SYSTEM:
                mTileName = context.getString(R.string.system);
                mTileIconIdNormal = R.drawable.ic_settings_n;
                mTileIconIdFocused = R.drawable.ic_settings_f;
                break;
            case TILE_INFO:
                mTileName = context.getString(R.string.info);
                mTileIconIdNormal = R.drawable.ic_sync_n;
                mTileIconIdFocused = R.drawable.ic_sync_f;
                break;
        }
    }

    public SettingTileType getSettingTileType() {
        return mSettingTileType;
    }

    public String getTileName() {
        return mTileName;
    }

    public int getTileIconIdNormal() {
        return mTileIconIdNormal;
    }

    public int getTileIconIdFocused() {
        return mTileIconIdFocused;
    }

    public Status getTileStatus() {
        return mTileStatus;
    }

    public int getTileStatusId() {
        return mTileStatusId;
    }

    public void setTileStatus(Status status) {
        mTileStatus = status;
        switch (status) {
            case OK:
                mTileStatusId = R.drawable.circle_ok;
                break;
            case ERROR:
                mTileStatusId = R.drawable.circle_error;
                break;
            case UPDATE:
                mTileStatusId = R.drawable.circle_update;
                break;
        }
    }
}
