package com.mancj.example.Page;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
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
import com.mancj.example.adapter.HorizontalRecAdapter;
import com.mancj.example.adapter.HorizontalScrollModel;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment{


    public HomeFragment() {

    }

//    public HomeFragment newInstance(MainActivity mainActivity) {
//
//        return new HomeFragment();
//    }


    //horizontal scroll

    private TextView horizontallayoutTitle;
    private Button horizontalviewAllButton;
    private RecyclerView horizontalRecyclerView,horizontalRecyclerView2,horizontalRecyclerView3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewflip(view);
        HorizontalScrollRec(view);

    }

    public void viewflip(View view)
    {
        // -------View Flipper
        //1 - Create the animations, we will load the animations from
        //    the already made animations in the android.R.anim folder
        //    custom animations can be added into to res/anim folder
        Animation anim_in = AnimationUtils.loadAnimation(getContext(),android.R.anim.slide_in_left);
        Animation anim_out = AnimationUtils.loadAnimation(getContext(),android.R.anim.slide_out_right);


        //2 - Find the fipper in the XML
        ViewFlipper vf = view.findViewById(R.id.vf);

        //3 - Assisgn the animations
        vf.setInAnimation(anim_in);
        vf.setOutAnimation(anim_out);

        //4 - Set the flipping interval, that is the time between flips
        vf.setFlipInterval(8000);

        //5 - Start FLipping - optional here, can also be
        //    called on click for click to flip
        vf.startFlipping();
    }

    public void HorizontalScrollRec(View view){
        ///Horizontal Dokumen layout
        horizontallayoutTitle= view.findViewById(R.id.horizontal_scroll_layout_title);
        horizontalviewAllButton=view.findViewById(R.id.horizontal_scroll_view_all_button);
        horizontalRecyclerView=view.findViewById(R.id.horizontal_scroll_layout_recycler);

        List<HorizontalScrollModel> horizontalScrollModelListDokumen = new ArrayList<>();
        horizontalScrollModelListDokumen.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App1","mantap","Rp.500"));
        horizontalScrollModelListDokumen.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App1","keren","Rp.500"));
        horizontalScrollModelListDokumen.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"App1","asyik","Rp.500"));
        horizontalScrollModelListDokumen.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"Sertifikat","wow banget","Rp.500"));
        horizontalScrollModelListDokumen.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"Portfolio","wadaw","Rp.500"));
        horizontalScrollModelListDokumen.add(new HorizontalScrollModel(R.mipmap.ic_launcher,"Skripsi","luar biasa","Rp.500"));

        HorizontalRecAdapter horizontalDokumenScrollAdapter =new HorizontalRecAdapter(horizontalScrollModelListDokumen);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);

        horizontalRecyclerView.setAdapter(horizontalDokumenScrollAdapter);
        horizontalDokumenScrollAdapter.notifyDataSetChanged();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
