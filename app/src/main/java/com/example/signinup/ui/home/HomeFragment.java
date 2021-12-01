package com.example.signinup.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.signinup.MyHelper;
import com.example.signinup.R;
import com.example.signinup.databinding.FragmentMainBinding;
import com.example.signinup.filmsAdapter;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    public FragmentMainBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentMainBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        MyHelper.fill();

        RecyclerView recyclerViewTrend = binding.scrollView2.findViewById(R.id.recTrend);
        filmsAdapter adapterTrend = new filmsAdapter(getLayoutInflater(), MyHelper.Urls);
        recyclerViewTrend.setAdapter(adapterTrend);

        RecyclerView recyclerViewNew = binding.scrollView2.findViewById(R.id.recNew);
        filmsAdapter adapterNew = new filmsAdapter(getLayoutInflater(), MyHelper.Urls);
        recyclerViewNew.setAdapter(adapterNew);

        RecyclerView recyclerViewForyou = binding.scrollView2.findViewById(R.id.recForyou);
        filmsAdapter adapterForyou = new filmsAdapter(getLayoutInflater(), MyHelper.Urls);
        recyclerViewForyou.setAdapter(adapterForyou);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}