package com.abhishek.interiit2016.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.abhishek.interiit2016.R;
import com.abhishek.interiit2016.activities.ResultsActivity;
import com.abhishek.interiit2016.activities.Sports;
import com.abhishek.interiit2016.activities.Standings;
import com.abhishek.interiit2016.activities.Teams;
import com.abhishek.interiit2016.utils.APIConstants;
import com.afollestad.materialdialogs.MaterialDialog;
import com.etiennelawlor.imagegallery.library.activities.FullScreenImageGalleryActivity;
import com.etiennelawlor.imagegallery.library.activities.ImageGalleryActivity;
import com.etiennelawlor.imagegallery.library.adapters.FullScreenImageGalleryAdapter;
import com.etiennelawlor.imagegallery.library.adapters.ImageGalleryAdapter;
import com.etiennelawlor.imagegallery.library.enums.PaletteColorType;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.ButterKnife;

/**
 * Created by GUNDA ABHISHEK on 24-06-2016.
 */
public class HomeFragment extends Fragment implements ImageGalleryAdapter.ImageThumbnailLoader, FullScreenImageGalleryAdapter.FullScreenImageLoader{
    private Drawable color;
    private PaletteColorType paletteColorType;
    String[] images = new String[10];
    SharedPreferences sharedPreferences;
    String gender;
    //private RelativeLayout results,fixtures,standings,teams,photos;
    public HomeFragment() {
    }

    @SuppressLint("ValidFragment")
    public HomeFragment(Drawable color) {
        this.color = color;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        images[0]="https://images.unsplash.com/photo-1437422061949-f6efbde0a471?q=80&amp;fm=jpg&amp;s=e23055c9ba7686b8fe583fb8318a1f88";
        images[1]="https://images.unsplash.com/photo-1434139240289-56c519f77cb0?q=80&amp;fm=jpg&amp;s=13f8a0d1c2f96b5f311dedeb17cddb60";
        images[2]="https://images.unsplash.com/photo-1429152937938-07b5f2828cdd?q=80&amp;fm=jpg&amp;s=a4f424db0ae5a398297df5ae5e0520d6";
        images[3]="https://images.unsplash.com/photo-1430866880825-336a7d7814eb?q=80&amp;fm=jpg&amp;s=450de8563ac041f48b1563b499f56895";
        images[4]="https://images.unsplash.com/photo-1429547584745-d8bec594c82e?q=80&amp;fm=jpg&amp;s=e9a7d9973088122a3e453cb2af541201";
        images[5]="https://images.unsplash.com/photo-1429277158984-614d155e0017?q=80&amp;fm=jpg&amp;s=138f154e17a304b296c953323862633b";
        images[6]="https://images.unsplash.com/photo-1429042007245-890c9e2603af?q=80&amp;fm=jpg&amp;s=8b76d20174cf46bffe32ea18f05551d3";
        images[7]="https://images.unsplash.com/photo-1429091967365-492aaa5accfe?q=80&amp;fm=jpg&amp;s=b7430cfe5508430aea39fcf3b0645878";
        images[8]="https://images.unsplash.com/photo-1430132594682-16e1185b17c5?q=80&amp;fm=jpg&amp;s=a70abbfff85382d11b03b9bbc71649c3";
        images[9]="https://images.unsplash.com/photo-1415871989540-61fe9268d3c8?q=80&amp;fm=jpg&amp;s=061a03a7abe860a6c165cc3994feaba2";
        ButterKnife.bind(view);
        ImageGalleryActivity.setImageThumbnailLoader(this);
        FullScreenImageGalleryActivity.setFullScreenImageLoader(this);
        paletteColorType = PaletteColorType.VIBRANT;
        RelativeLayout results= (RelativeLayout) view.findViewById(R.id.results);
        RelativeLayout fixtures= (RelativeLayout) view.findViewById(R.id.fixtures);
        final RelativeLayout standings= (RelativeLayout) view.findViewById(R.id.standings);
        RelativeLayout teams= (RelativeLayout) view.findViewById(R.id.teams);
        RelativeLayout photos= (RelativeLayout) view.findViewById(R.id.photos);
        sharedPreferences = this.getActivity().getSharedPreferences(APIConstants.USER_SPORT_SELECTED, Context.MODE_PRIVATE);
        gender = sharedPreferences.getString("Gender","Male");
        photos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ImageGalleryActivity.class);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(ImageGalleryActivity.KEY_IMAGES, new ArrayList<>(Arrays.asList(images)));
                bundle.putString(ImageGalleryActivity.KEY_TITLE, "Unsplash Images");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        standings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), Standings.class);
                startActivity(intent);
            }
        });
        teams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Teams.class);
                startActivity(intent);
            }
        });
        results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ResultsActivity.class);
                startActivity(intent);
            }
        });
        fixtures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Sports.class);
                startActivity(intent);
            }
        });
//        FloatingActionButton floatingActionButton =(FloatingActionButton)view.findViewById(R.id.fab3);
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new MaterialDialog.Builder(getActivity())
//                        .title("Select gender")
//                        .items(R.array.gender)
//                        .itemsCallbackSingleChoice(2, new MaterialDialog.ListCallbackSingleChoice() {
//                            @Override
//                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
//                                SharedPreferences.Editor editor = sharedPreferences.edit();
//                                editor.putString("Gender",text.toString());
//                                editor.commit();
//                                return true; // allow selection
//                            }
//                        })
//                        .positiveText("Submit")
//                        .show();
//            }
//        });
        return view;
    }

    @Override
    public void loadFullScreenImage(final ImageView iv, String imageUrl, int width, final LinearLayout bgLinearLayout) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Picasso.with(iv.getContext())
                    .load(imageUrl)
                    .resize(width, 0)
                    .into(iv, new Callback() {
                        @Override
                        public void onSuccess() {
                            Bitmap bitmap = ((BitmapDrawable) iv.getDrawable()).getBitmap();
                            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                                public void onGenerated(Palette palette) {
                                    applyPalette(palette, bgLinearLayout);
                                }
                            });
                        }

                        @Override
                        public void onError() {

                        }
                    });
        } else {
            iv.setImageDrawable(null);
        }
    }

    @Override
    public void loadImageThumbnail(ImageView iv, String imageUrl, int dimension) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Picasso.with(iv.getContext())
                    .load(imageUrl)
                    .resize(dimension, dimension)
                    .centerCrop()
                    .into(iv);
        } else {
            iv.setImageDrawable(null);
        }

    }
    private void applyPalette(Palette palette, LinearLayout bgLinearLayout){
        int bgColor = getBackgroundColor(palette);
        if (bgColor != -1)
            bgLinearLayout.setBackgroundColor(bgColor);
    }

    private int getBackgroundColor(Palette palette) {
        int bgColor = -1;

        int vibrantColor = palette.getVibrantColor(0x000000);
        int lightVibrantColor = palette.getLightVibrantColor(0x000000);
        int darkVibrantColor = palette.getDarkVibrantColor(0x000000);

        int mutedColor = palette.getMutedColor(0x000000);
        int lightMutedColor = palette.getLightMutedColor(0x000000);
        int darkMutedColor = palette.getDarkMutedColor(0x000000);

        if (paletteColorType != null) {
            switch (paletteColorType) {
                case VIBRANT:
                    if (vibrantColor != 0) { // primary option
                        bgColor = vibrantColor;
                    } else if (lightVibrantColor != 0) { // fallback options
                        bgColor = lightVibrantColor;
                    } else if (darkVibrantColor != 0) {
                        bgColor = darkVibrantColor;
                    } else if (mutedColor != 0) {
                        bgColor = mutedColor;
                    } else if (lightMutedColor != 0) {
                        bgColor = lightMutedColor;
                    } else if (darkMutedColor != 0) {
                        bgColor = darkMutedColor;
                    }
                    break;
                case LIGHT_VIBRANT:
                    if (lightVibrantColor != 0) { // primary option
                        bgColor = lightVibrantColor;
                    } else if (vibrantColor != 0) { // fallback options
                        bgColor = vibrantColor;
                    } else if (darkVibrantColor != 0) {
                        bgColor = darkVibrantColor;
                    } else if (mutedColor != 0) {
                        bgColor = mutedColor;
                    } else if (lightMutedColor != 0) {
                        bgColor = lightMutedColor;
                    } else if (darkMutedColor != 0) {
                        bgColor = darkMutedColor;
                    }
                    break;
                case DARK_VIBRANT:
                    if (darkVibrantColor != 0) { // primary option
                        bgColor = darkVibrantColor;
                    } else if (vibrantColor != 0) { // fallback options
                        bgColor = vibrantColor;
                    } else if (lightVibrantColor != 0) {
                        bgColor = lightVibrantColor;
                    } else if (mutedColor != 0) {
                        bgColor = mutedColor;
                    } else if (lightMutedColor != 0) {
                        bgColor = lightMutedColor;
                    } else if (darkMutedColor != 0) {
                        bgColor = darkMutedColor;
                    }
                    break;
                case MUTED:
                    if (mutedColor != 0) { // primary option
                        bgColor = mutedColor;
                    } else if (lightMutedColor != 0) { // fallback options
                        bgColor = lightMutedColor;
                    } else if (darkMutedColor != 0) {
                        bgColor = darkMutedColor;
                    } else if (vibrantColor != 0) {
                        bgColor = vibrantColor;
                    } else if (lightVibrantColor != 0) {
                        bgColor = lightVibrantColor;
                    } else if (darkVibrantColor != 0) {
                        bgColor = darkVibrantColor;
                    }
                    break;
                case LIGHT_MUTED:
                    if (lightMutedColor != 0) { // primary option
                        bgColor = lightMutedColor;
                    } else if (mutedColor != 0) { // fallback options
                        bgColor = mutedColor;
                    } else if (darkMutedColor != 0) {
                        bgColor = darkMutedColor;
                    } else if (vibrantColor != 0) {
                        bgColor = vibrantColor;
                    } else if (lightVibrantColor != 0) {
                        bgColor = lightVibrantColor;
                    } else if (darkVibrantColor != 0) {
                        bgColor = darkVibrantColor;
                    }
                    break;
                case DARK_MUTED:
                    if (darkMutedColor != 0) { // primary option
                        bgColor = darkMutedColor;
                    } else if (mutedColor != 0) { // fallback options
                        bgColor = mutedColor;
                    } else if (lightMutedColor != 0) {
                        bgColor = lightMutedColor;
                    } else if (vibrantColor != 0) {
                        bgColor = vibrantColor;
                    } else if (lightVibrantColor != 0) {
                        bgColor = lightVibrantColor;
                    } else if (darkVibrantColor != 0) {
                        bgColor = darkVibrantColor;
                    }
                    break;
                default:
                    break;
            }
        }

        return bgColor;
    }
}
