package com.project.todolist.activities;

/**
 * Created by Sruthi Pusunuru on 11/14/2016.
 */


        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.OnMapReadyCallback;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.MarkerOptions;
        import com.project.todolist.R;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;


        import static com.project.todolist.R.id.map;

/**
 * This shows how to create a simple activity with a map and a marker on the map.
 */
public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(map);
        mapFragment.getMapAsync(this);


    }


    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
        map.getUiSettings().setMyLocationButtonEnabled(true);
    }
}
