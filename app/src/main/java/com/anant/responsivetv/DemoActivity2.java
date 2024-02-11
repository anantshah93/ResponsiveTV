package com.anant.responsivetv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import static com.anant.responsivetv.SettingsTileModel.SettingTileType.TILE_CAMERA;
import static com.anant.responsivetv.SettingsTileModel.SettingTileType.TILE_CONNECTIVITY;
import static com.anant.responsivetv.SettingsTileModel.SettingTileType.TILE_DISPLAY_AND_AUDIO;
import static com.anant.responsivetv.SettingsTileModel.SettingTileType.TILE_INFO;
import static com.anant.responsivetv.SettingsTileModel.SettingTileType.TILE_PERIPHERALS;
import static com.anant.responsivetv.SettingsTileModel.SettingTileType.TILE_SYNC_PORTAL;
import static com.anant.responsivetv.SettingsTileModel.SettingTileType.TILE_SYSTEM;
import static com.anant.responsivetv.SettingsTileModel.SettingTileType.TILE_UPDATES;

public class DemoActivity2 extends AppCompatActivity implements SettingTileAdapter.ISettingsTileClickListener {
    private static final int GRID_COL = 4;
    private RecyclerView mRvSettingsTiles;
    private RecyclerView.Adapter mSettingsTileAdapter;
    private ArrayList<SettingsTileModel> mSettingTileList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);

        findViewById(R.id.btn_back_to_zoom).setOnClickListener(view -> finish());
        initViews();
    }

    private void initViews() {
        buildSettingsTiles();
        mRvSettingsTiles = findViewById(R.id.rv_settings_tiles);
        mRvSettingsTiles.setLayoutManager(new GridLayoutManager(this, GRID_COL));
        mSettingsTileAdapter = new SettingTileAdapter(this, this, mSettingTileList,0,false);
        mRvSettingsTiles.setAdapter(mSettingsTileAdapter);
    }

    private void buildSettingsTiles() {
        SettingsTileModel tile1 =
                new SettingsTileModel(this, TILE_SYNC_PORTAL, SettingsTileModel.Status.ERROR);
        SettingsTileModel tile2 =
                new SettingsTileModel(this, TILE_UPDATES, SettingsTileModel.Status.ERROR);
        SettingsTileModel tile3 =
                new SettingsTileModel(this, TILE_DISPLAY_AND_AUDIO, SettingsTileModel.Status.ERROR);
        SettingsTileModel tile4 =
                new SettingsTileModel(this, TILE_CAMERA, SettingsTileModel.Status.ERROR);
        SettingsTileModel tile5 =
                new SettingsTileModel(this, TILE_CONNECTIVITY, SettingsTileModel.Status.ERROR);
        SettingsTileModel tile6 =
                new SettingsTileModel(this, TILE_PERIPHERALS, SettingsTileModel.Status.ERROR);
        SettingsTileModel tile7 =
                new SettingsTileModel(this, TILE_SYSTEM, SettingsTileModel.Status.ERROR);
        SettingsTileModel tile8 =
                new SettingsTileModel(this, TILE_INFO, SettingsTileModel.Status.ERROR);

        mSettingTileList.add(tile1);
        mSettingTileList.add(tile2);
        mSettingTileList.add(tile3);
        mSettingTileList.add(tile4);
        mSettingTileList.add(tile5);
        mSettingTileList.add(tile6);
        mSettingTileList.add(tile7);
        mSettingTileList.add(tile8);

    }

    @Override
    public void onTileItemClicked(SettingsTileModel item) {

    }
}
