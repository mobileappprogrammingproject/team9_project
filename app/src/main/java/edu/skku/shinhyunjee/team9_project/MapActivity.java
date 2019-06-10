package edu.skku.shinhyunjee.team9_project;

import android.Manifest;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.*;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    String locationName;
    String restaurantName;
    double nowLat, nowLon;
    Button button;
    GoogleMap map;
    LatLng restaurant;
    boolean click=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(MapActivity.this);

        Intent intent = getIntent();
        locationName = intent.getStringExtra("location");
        restaurantName = intent.getStringExtra("restaurant");
        button=(Button)findViewById(R.id.myLocation);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(click==false) {
                    LatLng now = new LatLng(nowLat, nowLon);
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(now);
                    markerOptions.title("현재 위치");
                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                    map.addMarker(markerOptions);
                    map.moveCamera(CameraUpdateFactory.newLatLng(now));
                    map.animateCamera(CameraUpdateFactory.zoomTo(18));
                    Log.d("myLocation", "lat: " + nowLat + ", lon: " + nowLon);
                    click=true;
                    button.setText("식당 위치 확인");
                }
                else{
                    map.moveCamera(CameraUpdateFactory.newLatLng(restaurant));
                    map.animateCamera(CameraUpdateFactory.zoomTo(18));
                    click=false;
                    button.setText("내 위치 확인");
                }

            }
        });

        final LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        if ( Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission( getApplicationContext(),
                        android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {
            ActivityCompat.requestPermissions( MapActivity.this, new String[]
                    { android.Manifest.permission.ACCESS_FINE_LOCATION },0 );
        }
        else{
            Toast.makeText(MapActivity.this, "LocationManager is ready!", Toast.LENGTH_SHORT).show();
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                    0,
                    0,
                    networkLocationListener);
        }

    }

    final LocationListener networkLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            nowLon = location.getLongitude();
            nowLat = location.getLatitude();
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {}
        @Override
        public void onProviderEnabled(String provider) {}
        @Override
        public void onProviderDisabled(String provider) {}
    };

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map=googleMap;
        List<Address> addressList = null;
        Geocoder geocoder = new Geocoder(this);
        try{
            addressList=geocoder.getFromLocationName(locationName,5);
        } catch (Exception e){

        }
        String []splitStr = addressList.get(0).toString().split(",");
        String latitude = splitStr[10].substring(splitStr[10].indexOf("=") + 1); // 위도
        String longitude = splitStr[12].substring(splitStr[12].indexOf("=") + 1); // 경도
        Log.d("addressList lat, lon",latitude+", "+longitude);

        restaurant = new LatLng(Double.parseDouble(latitude),Double.parseDouble(longitude));

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(restaurant);
        markerOptions.title(restaurantName);
        googleMap.addMarker(markerOptions);

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(restaurant));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(18));
    }



}
