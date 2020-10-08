package com.bcb.login;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bcb.user.bareillycollegebareilly.R;

public class SlideAdapter extends PagerAdapter {


    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context){
        this.context = context;
    }

    public int[] slide_image={

            R.drawable.about,
            R.drawable.course,
            R.drawable.syllabus,
            R.drawable.contact
    };

    public int[] slide_colour={

            R.color.deepPurole,
            R.color.green,
            R.color.yello,
            R.color.pink
    };
    public String[] slide_heading ={

            "About",
            "Course",
            "Syllabus",
            "Contact"
    };

    public String[] slide_dics ={

            "Bareilly College, Bareilly is a premier institute of M. J. P. Rohilkhand University located in Bareilly in the Indian state of Utter Pradesh",
            " It is usually the belief that the education must be based on the needs of the society. The new subjects are being added and faculty are being improved according to the requirement of the students.",
            "Syllabus are available of all the coerces in pdf format which can be open with help of adobe reader ",
            "get information and quarry regarding from the contact menu in Bareilly College Bareilly App"
    };

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);


        ImageView slideImageview = (ImageView)view.findViewById(R.id.slideimageview);
        TextView slideTexyview = (TextView)view.findViewById(R.id.slideheading);
        TextView slidedescription = (TextView)view.findViewById(R.id.slidedesc);
       // RelativeLayout slideColour = (RelativeLayout) view.findViewById(R.id.slidecolour);

        slideImageview.setImageResource(slide_image[position]);
       // slideImageview.setBackgroundColor(slide_colour[position]);
        slideTexyview.setText(slide_heading[position]);
        slidedescription.setText(slide_dics[position]);
        slidedescription.setTextColor(slide_colour[position]);
       // slideColour.setBackgroundColor(slide_colour[position]);

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }

}
