package com.doctordoc.doctordoc_paciente.presentation.presenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.doctordoc.doctordoc_paciente.R;
import com.doctordoc.doctordoc_paciente.data.entity.Locale;
import com.doctordoc.doctordoc_paciente.presentation.fragment.LocaleFragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import com.google.maps.android.ui.IconGenerator;

public class StoreRenderer extends DefaultClusterRenderer<Locale> {

    private IconGenerator mIconGenerator;
    private IconGenerator mClusterIconGenerator;
    private final ImageView mImageView;
    private final ImageView mClusterImageView;
    private final int mDimension;
    private Context context;
    private LocaleFragment fragment;

    public StoreRenderer(Context context, LocaleFragment fragment, GoogleMap mMap, ClusterManager mClusterManager) {
        super(context, mMap, mClusterManager);

        this.fragment = fragment;
        this.context = context;

        mIconGenerator = new IconGenerator(context);
        mClusterIconGenerator = new IconGenerator(context);

        View multiProfile = fragment.getLayoutInflater(null).inflate(R.layout.multi_profile, null);
        mClusterIconGenerator.setContentView(multiProfile);
        mClusterImageView = (ImageView) multiProfile.findViewById(R.id.image);

        mImageView = new ImageView(context);
        mDimension = (int) context.getResources().getDimension(R.dimen.custom_profile_image);
        mImageView.setLayoutParams(new ViewGroup.LayoutParams(mDimension, mDimension));
        int padding = (int) context.getResources().getDimension(R.dimen.custom_profile_padding);
        mImageView.setPadding(padding, padding, padding, padding);
        mIconGenerator.setContentView(mImageView);
    }

    @Override
    protected void onBeforeClusterItemRendered(Locale locale, MarkerOptions markerOptions) {

        if(locale.getLocalId().equals("2")){
            mImageView.setImageResource(R.drawable.laluz);

        }

        if(locale.getLocalId().equals("1")){
            mImageView.setImageResource(R.drawable.ricpal);
        }

        if(locale.getLocalId().equals("3")){
            mImageView.setImageResource(R.drawable.perjap);

        }

        Bitmap icon = mIconGenerator.makeIcon();
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon));
    }

    @Override
    protected void onBeforeClusterRendered(Cluster<Locale> cluster, MarkerOptions markerOptions) {
        mClusterImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_med));
        Bitmap icon = mClusterIconGenerator.makeIcon(String.valueOf(cluster.getSize()));
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon));
    }

    @Override
    protected boolean shouldRenderAsCluster(Cluster cluster) {
        return cluster.getSize() > 1;
    }

}