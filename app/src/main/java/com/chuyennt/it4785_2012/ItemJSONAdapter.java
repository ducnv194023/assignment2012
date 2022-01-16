package com.chuyennt.it4785_2012;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;


public class ItemJSONAdapter extends RecyclerView.Adapter<ItemJSONAdapter.ItemViewHolder> {

    JSONArray jsonArray;
    ItemClickListener itemClickListener;

    public ItemJSONAdapter(JSONArray jsonArray, ItemClickListener itemClickListener) {
        this.jsonArray = jsonArray;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(itemView, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(position);
            JSONObject jsonObjectAvatar = new JSONObject(jsonObject.getString("avatar"));
            Log.v("Tag","https://lebavui.github.io"+jsonObjectAvatar.getString("photo"));
            new DownloadImageTask(holder.avatar).execute("https://lebavui.github.io"+jsonObjectAvatar.getString("thumbnail"));
            holder.userName.setText(jsonObject.getString("name"));
            holder.email.setText(jsonObject.getString("email"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView userName;
        TextView email;

        public ItemViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
            super(itemView);

            avatar = itemView.findViewById(R.id.avatar);
            userName = itemView.findViewById(R.id.userName);
            email = itemView.findViewById(R.id.email);
            ItemClickListener _itemClickListener = itemClickListener;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (_itemClickListener != null) {
                        try {
                            _itemClickListener.onItemClick(jsonArray.getJSONObject(getAdapterPosition()));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView Image;

        public DownloadImageTask(ImageView bmImage) {
            this.Image = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            Image.setImageBitmap(result);
        }
    }
}
