package com.mancj.example.Page;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.mancj.example.MainActivity;
import com.mancj.example.R;
import com.mancj.example.adapter.HorizontalNewAdapter;
import com.mancj.example.adapter.HorizontalRecAdapter;
import com.mancj.example.adapter.HorizontalTopAdapter;
import com.mancj.example.adapter.HorizontalScrollModel;
import com.mancj.example.adapter.JumboAdapter;
import com.mancj.example.adapter.JumboModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment{


    public HomeFragment() {

    }

//    public HomeFragment newInstance(MainActivity mainActivity) {
//
//        return new HomeFragment();
//    }


    /////banner Slider
    private ViewPager bannerSliderViewPager;
    private List<JumboModel>sliderModelList;
    private int currentPage =2;
    private Timer timer;
    final private  long DELAYTIME=3000;
    final private long PERIOD_TIME=3000;
    ////banner slider




    //horizontal scroll

    private TextView horizontallayoutTitle;
    private Button horizontalviewAllButton;
    private RecyclerView horizontalRecyclerView,horizontalRecyclerView2,horizontalRecyclerView3;

    //Horizontal Scroll

    @Nullable
    @Override




    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        viewflip(view);
        JumboSlider(view);
        HorizontalScrollNew(view);
        HorizontalScrollRec(view);
        HorizontalScrollTop(view);

    }

//    public void viewflip(View view)
//    {
//        // -------View Flipper
//        //1 - Create the animations, we will load the animations from
//        //    the already made animations in the android.R.anim folder
//        //    custom animations can be added into to res/anim folder
//        Animation anim_in = AnimationUtils.loadAnimation(getContext(),android.R.anim.slide_in_left);
//        Animation anim_out = AnimationUtils.loadAnimation(getContext(),android.R.anim.slide_out_right);
//
//
//        //2 - Find the fipper in the XML
//        ViewFlipper vf = view.findViewById(R.id.vf);
//
//        //3 - Assisgn the animations
//        vf.setInAnimation(anim_in);
//        vf.setOutAnimation(anim_out);
//
//        //4 - Set the flipping interval, that is the time between flips
//        vf.setFlipInterval(8000);
//
//        //5 - Start FLipping - optional here, can also be
//        //    called on click for click to flip
//        vf.startFlipping();
//    }


    public void JumboSlider(View view){
        ////banner slider
        bannerSliderViewPager=view.findViewById(R.id.jumbo_slider_view_pager);

        sliderModelList=new ArrayList<JumboModel>();
        sliderModelList.add(new JumboModel(R.mipmap.ic_launcher,"#077AE4"));
        sliderModelList.add(new JumboModel(R.mipmap.ic_launcher,"#00000f"));
        sliderModelList.add(new JumboModel(R.mipmap.ic_launcher,"#077AE4"));
        sliderModelList.add(new JumboModel(R.mipmap.ic_launcher,"#00000f"));
        sliderModelList.add(new JumboModel(R.mipmap.ic_launcher,"#077AE4"));
        sliderModelList.add(new JumboModel(R.mipmap.ic_launcher,"#00000f"));
        sliderModelList.add(new JumboModel(R.mipmap.ic_launcher,"#077AE4"));
        sliderModelList.add(new JumboModel(R.mipmap.ic_launcher,"#00000f"));
        sliderModelList.add(new JumboModel(R.mipmap.ic_launcher,"#077AE4"));

        JumboAdapter jumboAdapter=new JumboAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(jumboAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(35);

        ViewPager.OnPageChangeListener onPageChangeListener=new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                currentPage=i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (i==ViewPager.SCROLL_STATE_IDLE){
                    pageLooper();
                }
            }
        };

        bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

        startBannerSlideShow();
        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pageLooper();
                stopBannerSliderSHow();
                if (event.getAction()==MotionEvent.ACTION_UP){
                    startBannerSlideShow();
                }
                return false;
            }
        });
        ////banner slider
    }


    public void HorizontalScrollRec(View view){
        ///Horizontal Rec layout
        horizontallayoutTitle= view.findViewById(R.id.horizontal_scroll_layout_title);
        horizontalviewAllButton=view.findViewById(R.id.horizontal_scroll_view_all_button);
        horizontalRecyclerView=view.findViewById(R.id.horizontal_scroll_layout_recycler);

        List<HorizontalScrollModel> horizontalScrollModelListRec = new ArrayList<>();
        horizontalScrollModelListRec.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App1","Smart Home","Rp.2000000"));
        horizontalScrollModelListRec.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App2","Security","Rp.1500000"));
        horizontalScrollModelListRec.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App3","Sensors","Rp.3000000"));
        horizontalScrollModelListRec.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App3","Educations","Rp.1000000"));
        horizontalScrollModelListRec.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App4","Enterprise","Rp.2000000"));
        horizontalScrollModelListRec.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App5","Outdoors","Rp.1500000"));

        HorizontalRecAdapter horizontalRecScrollAdapter =new HorizontalRecAdapter(horizontalScrollModelListRec);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);

        horizontalRecyclerView.setAdapter(horizontalRecScrollAdapter);
        horizontalRecScrollAdapter.notifyDataSetChanged();
    }

    public void HorizontalScrollTop(View view){
        ///Horizontal Top layout
        horizontallayoutTitle= view.findViewById(R.id.horizontal_scroll_layout_title1);
        horizontalviewAllButton=view.findViewById(R.id.horizontal_scroll_view_all_button1);
        horizontalRecyclerView2=view.findViewById(R.id.horizontal_scroll_layout_recycler1);

        List<HorizontalScrollModel> horizontalScrollModelListTop = new ArrayList<>();
        horizontalScrollModelListTop.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App1","Smart Home","Rp.2000000"));
        horizontalScrollModelListTop.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App2","Security","Rp.1500000"));
        horizontalScrollModelListTop.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App3","Sensors","Rp.3000000"));
        horizontalScrollModelListTop.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App3","Educations","Rp.1000000"));
        horizontalScrollModelListTop.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App4","Enterprise","Rp.2000000"));
        horizontalScrollModelListTop.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App5","Outdoors","Rp.1500000"));

        HorizontalTopAdapter horizontalTopScrollAdapter =new HorizontalTopAdapter(horizontalScrollModelListTop);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecyclerView2.setLayoutManager(linearLayoutManager);

        horizontalRecyclerView2.setAdapter(horizontalTopScrollAdapter);
        horizontalTopScrollAdapter.notifyDataSetChanged();
    }
    public void HorizontalScrollNew(View view){
        ///Horizontal New layout
        horizontallayoutTitle= view.findViewById(R.id.horizontal_scroll_layout_title2);
        horizontalviewAllButton=view.findViewById(R.id.horizontal_scroll_view_all_button2);
        horizontalRecyclerView3=view.findViewById(R.id.horizontal_scroll_layout_recycler2);

        List<HorizontalScrollModel> horizontalScrollModelListNew = new ArrayList<>();
        horizontalScrollModelListNew.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App1","Smart Home","Rp.2000000"));
        horizontalScrollModelListNew.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App2","Security","Rp.1500000"));
        horizontalScrollModelListNew.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App3","Sensors","Rp.3000000"));
        horizontalScrollModelListNew.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App3","Educations","Rp.1000000"));
        horizontalScrollModelListNew.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App4","Enterprise","Rp.2000000"));
        horizontalScrollModelListNew.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App5","Outdoors","Rp.1500000"));

        HorizontalNewAdapter horizontalNewScrollAdapter =new HorizontalNewAdapter(horizontalScrollModelListNew);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecyclerView3.setLayoutManager(linearLayoutManager);

        horizontalRecyclerView3.setAdapter(horizontalNewScrollAdapter);
        horizontalNewScrollAdapter.notifyDataSetChanged();
    }


    ////Jumbo slider
    private void pageLooper(){
        if (currentPage== sliderModelList.size()-2){
            currentPage=2;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
        if (currentPage== 1){
            currentPage=sliderModelList.size()-3;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }

    }

    private void startBannerSlideShow(){
        final Handler handler= new Handler();
        final Runnable update= new Runnable() {
            @Override
            public void run() {
                if (currentPage>= sliderModelList.size()){
                    currentPage=1;
                }
                bannerSliderViewPager.setCurrentItem(currentPage++,true);
            }
        };
        timer= new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },DELAYTIME,PERIOD_TIME );
    }

    private void stopBannerSliderSHow(){
        timer.cancel();
    }
    ////Jumbo slider



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
