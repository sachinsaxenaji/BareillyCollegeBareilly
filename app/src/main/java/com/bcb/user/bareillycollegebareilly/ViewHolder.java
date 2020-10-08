package com.bcb.user.bareillycollegebareilly;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;
    public ViewHolder(View itemView) {
        super(itemView);

        mView=itemView;
    }

    public void setDetails(Context ctx, String title, String image, String description){

        TextView mTileTv=mView.findViewById(R.id.event_title);
        ImageView mImageTv=mView.findViewById(R.id.image);
        TextView mDetailTv=mView.findViewById(R.id.event_desc);

        mTileTv.setText(title);
        mDetailTv.setText(description);
        Picasso.get().load(image).into(mImageTv);
    }
}
