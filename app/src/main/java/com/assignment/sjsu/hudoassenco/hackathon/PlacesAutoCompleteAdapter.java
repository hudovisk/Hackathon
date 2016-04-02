package com.assignment.sjsu.hudoassenco.hackathon;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by hudoassenco on 4/2/16.
 */
public class PlacesAutoCompleteAdapter extends ArrayAdapter<String> implements Filterable {

    private ArrayList<String> mResultList;

    private final String URL = "";

    private RequestQueue mRequestQueue;

    public PlacesAutoCompleteAdapter(Context context, int resource) {
        super(context, resource);
        mRequestQueue = Volley.newRequestQueue(context);
    }

    @Override
    public int getCount() {
        return mResultList.size();
    }

    @Override
    public String getItem(int index) {
        return mResultList.get(index);
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                    // Retrieve the autocomplete results.

//                    CustomRequest jsObjRequest = new CustomRequest(Request.Method.GET, URL, params, this.createRequestSuccessListener(), this.createRequestErrorListener());
//
//                    mRequestQueue.add(jsObjRequest);

                    // Assign the data to the FilterResults
                    filterResults.values = mResultList;
                    filterResults.count = mResultList.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {
                    notifyDataSetChanged();
                }
                else {
                    notifyDataSetInvalidated();
                }
            }};
        return filter;
    }




}
