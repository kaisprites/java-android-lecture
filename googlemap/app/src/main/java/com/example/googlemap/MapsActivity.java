package com.example.googlemap;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback,
                    GoogleMap.OnPolylineClickListener,
                    GoogleMap.OnPolygonClickListener {

    private GoogleMap mMap;
    private LatLng sinchon, jongsam, cityhall;
    private LatLng w1, w2, w3, w4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Polyline polyline1 = mMap.addPolyline(new PolylineOptions()
                        .clickable(true)
                        .add(sinchon, jongsam, cityhall)
                );
            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Polygon polygon = mMap.addPolygon(new PolygonOptions()
//                        .clickable(true)
//                        .add(sinchon, jongsam, cityhall)
//                );
                Polygon polygon1 = mMap.addPolygon(new PolygonOptions()
                        .clickable(true)
                        .add(w1,w2,w3,w4)
                );
                polygon1.setFillColor(Color.BLUE);
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        sinchon = new LatLng(37.55530680880367, 126.9369337314057);
        jongsam = new LatLng(37.57245603601235, 126.98881308013505);
        cityhall = new LatLng(37.56667176926742, 126.97841321556027);
        w1 = new LatLng(-27.457, 153.040);
        w2 = new LatLng(-33.852, 151.211);
        w3 = new LatLng(-37.813, 144.962);
        w4 = new LatLng(-34.928, 138.599);
        mMap.addMarker(new MarkerOptions().position(sinchon).title("sinchon"));
        mMap.addMarker(new MarkerOptions().position(jongsam).title("jongsam"));
        mMap.addMarker(new MarkerOptions().position(cityhall).title("cityhall"));
        mMap.addMarker(new MarkerOptions().position(w1).title("w1"));
        mMap.addMarker(new MarkerOptions().position(w2).title("w2"));
        mMap.addMarker(new MarkerOptions().position(w3).title("w3"));
        mMap.addMarker(new MarkerOptions().position(w4).title("w4"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(w1));
        googleMap.setOnPolylineClickListener(this);
        googleMap.setOnPolygonClickListener(this);
    }

    @Override
    public void onPolygonClick(Polygon polygon) {

    }

    @Override
    public void onPolylineClick(Polyline polyline) {

    }
}
