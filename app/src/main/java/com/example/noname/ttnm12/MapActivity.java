package com.example.noname.ttnm12;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap map;
    private Marker lastMarker;
    private Marker myMarker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.my_map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng myPostion = new LatLng(-2.545429,-62.928841);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(myPostion,9));
        myMarker = map.addMarker(new MarkerOptions()
                .title("Amazon")
                .snippet("Amazon")
                .position(myPostion)
        );

        LatLng drone1Pos = new LatLng(-2.555429,-62.748841);
        map.addMarker(new MarkerOptions()
                .position(drone1Pos)
                .title("drone_ggwp_01")
                .snippet("Khu vực 17")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_drone_map))
        );
        LatLng drone2Pos = new LatLng(-2.649429,-62.835841);
        map.addMarker(new MarkerOptions()
                .position(drone2Pos)
                .title("drone_ggwp_02")
                .snippet("Khu vực 22")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_drone_map))
        );
        LatLng drone3Pos = new LatLng(-2.430429,-62.980841);
        map.addMarker(new MarkerOptions()
                .position(drone3Pos)
                .title("drone_ggwp_03")
                .snippet("Khu vực 05")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_drone_map))
        );
        LatLng drone4Pos = new LatLng(-2.511429,-62.850841);
        map.addMarker(new MarkerOptions()
                .position(drone4Pos)
                .title("drone_ggwp_04")
                .snippet("Khu vực 13")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_drone_map))
        );
        LatLng drone5Pos = new LatLng(-2.590429,-62.970841);
        map.addMarker(new MarkerOptions()
                .position(drone5Pos)
                .title("drone_ggwp_05")
                .snippet("Khu vực 11")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_drone_map))
        );
        LatLng drone6Pos = new LatLng(-2.568429,-63.290841);
        map.addMarker(new MarkerOptions()
                .position(drone6Pos)
                .title("drone_ggwp_06")
                .snippet("Khu vực 02")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_drone_map))
        );

        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.equals(myMarker))
                    {
                        Log.e("log", "onMarkerClick: 123" );
                        return false;
                    }
                if(lastMarker == null) {
                    Log.e("log", "onMarkerClick: 456" );
                    lastMarker = marker;
                    return false;
                }
                if(marker.equals(lastMarker)) {
                    Log.e("log", "onMarkerClick: 312312" );
                    finish();
                    gotoDetailDrone();
                }
                else{
                    Log.e("log", "onMarkerClick: 432532" );
                    lastMarker = marker;
                }
                return false;
            }
        });
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void gotoDetailDrone() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("detail",true);
        startActivity(intent);
    }
}
