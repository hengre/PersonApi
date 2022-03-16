package dk.tec.personapi.resources;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import dk.tec.personapi.Singleton;
import dk.tec.personapi.service.IService;

public class PersonResource {

    public static final String PERSON_API = "http://10.0.2.2:8080/mysqlapi/api/person";
    private Context ctx;
    private JSONArray jsonArray;

    public PersonResource(Context ctx){
        this.ctx = ctx;
    }

    public void getAllPersons(IService serviceListener){

        String url = PERSON_API;

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        serviceListener.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                serviceListener.onError(error.getMessage());
            }
        });
        Singleton.getInstance(ctx).addToRequestQueue(jsonArrayRequest);
    }
}
