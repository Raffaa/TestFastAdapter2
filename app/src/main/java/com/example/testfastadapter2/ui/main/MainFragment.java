package com.example.testfastadapter2.ui.main;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testfastadapter2.R;
import com.example.testfastadapter2.adapters.MyStickyHeaderAdapter;
import com.example.testfastadapter2.items.Item1;
import com.example.testfastadapter2.items.Item2;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.timehop.stickyheadersrecyclerview.decorators.StickyRecyclerHeadersDecoration;

import java.util.Arrays;

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.main_fragment, container, false);
        RecyclerView rv = root.findViewById(R.id.recyclerview);
        ItemAdapter<Item1> item1Adpt = new ItemAdapter<>();
        ItemAdapter<Item2> item2Adat = new ItemAdapter<>();
        FastAdapter<IItem<?>> fastAdpt = FastAdapter.with(Arrays.asList(item1Adpt, item2Adat));
        MyStickyHeaderAdapter stickyAdpt = new MyStickyHeaderAdapter();

        rv.setAdapter(stickyAdpt.wrap(fastAdpt));
        final StickyRecyclerHeadersDecoration deco = new StickyRecyclerHeadersDecoration(stickyAdpt);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.addItemDecoration(deco);
        rv.addItemDecoration(new DividerItemDecoration(rv.getContext(), DividerItemDecoration.HORIZONTAL));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv.getContext(),
                DividerItemDecoration.VERTICAL);
        Drawable divider = getResources().getDrawable(R.drawable.divider);
        int inset = getResources().getDimensionPixelSize(R.dimen.divider_margin);
        InsetDrawable insetDivider = new InsetDrawable(divider, inset, 0, inset, 0);
        dividerItemDecoration.setDrawable(insetDivider);
        rv.addItemDecoration(dividerItemDecoration);


        stickyAdpt.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                deco.invalidateHeaders();
            }
        });

        //addChartRVListeners();

        for(int i = 0;i < 20; i++) {
            if(i < 10) {
                item1Adpt.add(new Item1());
            } else {
                item2Adat.add(new Item2());
            }
        }

        fastAdpt.notifyAdapterDataSetChanged();

        return root;
    }

}
