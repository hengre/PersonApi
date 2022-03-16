package dk.tec.personapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import dk.tec.personapi.resources.PersonResource;
import dk.tec.personapi.service.IService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PersonResource getAll = new PersonResource(this);

        getAll.getAllPersons(new IService() {
            @Override
            public void onSuccess(JSONArray jsonArray) {
                Log.d("HG", "Response is: " + jsonArray.toString());
            }

            @Override
            public void onSuccess(JSONObject jsonArray) {

            }

            @Override
            public void onError(String err) {
                Log.d("HG", ""+ err);
            }
        });


    }
}