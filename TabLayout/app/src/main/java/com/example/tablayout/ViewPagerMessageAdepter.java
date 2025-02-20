package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerMessageAdepter extends FragmentPagerAdapter {

    public ViewPagerMessageAdepter(@NonNull FragmentManager fm) {
        super(fm);
    }


    /*
     ekhane kon position kon fragment(design) thakbe ta set kora hoiche
     */
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new ChatsFragment();
        } else if (position==1) {
            return new StatusFragment();
        }else{
            return new CallsFragment();
        }
    }

    @Override
    /*
    ekhane koto gula fragment thakbe tar integer value dite hobe
    */
    public int getCount() {
        // fragment 3 ta neoya hoiche tai 3 value deoya hoiche
        return 3;
    }

    @Nullable
    @Override
    /*
    TabLayout e ki ki item lekha thak be ta deoya hoiche(Chats, Status, Calls)
     */
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Chats";
        } else if (position==1) {
            return "Status";
        }
        else {
            return "Calls";
        }
    }
}
