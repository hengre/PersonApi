package dk.tec.personapi.service;


import org.json.JSONArray;
import org.json.JSONObject;

public interface IService {
    public void onSuccess(JSONArray jsonArray);
    public void onSuccess(JSONObject jsonArray);
    public void onError(String err);
}
