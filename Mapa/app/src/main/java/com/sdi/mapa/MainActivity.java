package com.sdi.mapa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sdi.mapa.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    ActivityMainBinding binding;
    private MapView mMapView;
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mMapView = binding.mapView;
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(this);

    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        if (mMap != null) {
            //19.541902077732306, -96.92722866981264
            LatLng loc = new LatLng(19.541902077732306, -96.92722866981264);
            MarkerOptions mko = new MarkerOptions()
                    .position(loc)
                    .title("Facultad de Estadística e Informática");

            mMap.addMarker(mko);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 10));
        }
    }
}