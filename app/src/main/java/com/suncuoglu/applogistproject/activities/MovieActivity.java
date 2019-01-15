package com.suncuoglu.applogistproject.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.suncuoglu.applogistproject.model.Movie;
import com.suncuoglu.applogistproject.R;
import com.suncuoglu.applogistproject.adapters.TopRatedAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ArrayList<Movie> modelArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_activity);

        recyclerView = findViewById(R.id.recyclerView2);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

//        for (int i = 0; i < 20; i++) {
//            ViewModel model = new ViewModel("ASD", "mail@mail.com", R.drawable.beer);
//            modelArrayList.add(model);
//        }
        adapter = new TopRatedAdapter(modelArrayList, MovieActivity.this);
        recyclerView.setAdapter(adapter);

        new RequestTask().execute("http://");
    }
    class RequestTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... uri) {
//            HttpClient httpclient = new DefaultHttpClient();
//            HttpResponse response;
//            String responseString = null;
//            try {
//                response = httpclient.execute(new HttpGet(uri[0]));
//                StatusLine statusLine = response.getStatusLine();
//                if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
//                    ByteArrayOutputStream out = new ByteArrayOutputStream();
//                    response.getEntity().writeTo(out);
//                    responseString = out.toString();
//                    out.close();
//                } else {
//                    //Closes the connection.
//                    response.getEntity().getContent().close();
//                    throw new IOException(statusLine.getReasonPhrase());
//                }
//            } catch (ClientProtocolException e) {
//                e.printStackTrace();
//                //TODO Handle problems..
//            } catch (IOException e) {
//                //TODO Handle problems..
//                e.printStackTrace();
//            }
//            return responseString;
            return null;
        }
        @Override
        protected void onPostExecute(String result) {

            Log.d("API", "onPostExecute: " + result);
            try {
                JSONArray jsonArray = new JSONArray(result);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObj = jsonArray.getJSONObject(i);
                    //String movieID = jsonObj.getString("movie_id");


                    Movie model = new Movie();
                    modelArrayList.add(model);
                }

                adapter.notifyDataSetChanged();



            } catch (JSONException e) {
                e.printStackTrace();
            }


            super.onPostExecute(result);
            //Do anything with response..
        }
    }
}
