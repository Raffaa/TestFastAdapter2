package com.example.testfastadapter2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testfastadapter2.R;
import com.example.testfastadapter2.items.Item2;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.util.List;

public class MyStickyHeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements StickyRecyclerHeadersAdapter {

    private FastAdapter<IItem<? extends RecyclerView.ViewHolder>> adpt;

    public MyStickyHeaderAdapter wrap(FastAdapter<IItem<? extends RecyclerView.ViewHolder>> fastAdapter) {
        this.adpt = fastAdapter;

        return this;
    }

    @Override
    public long getHeaderId(int position) {
        if(adpt.getItem(position) instanceof Item2) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header_layout, viewGroup, false);

        return new RecyclerView.ViewHolder(v) {};
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        FrameLayout layout = (FrameLayout) viewHolder.itemView;
        String headerText = adpt.getItem(i) instanceof Item2 ? "Item2" : "Item 1";
        ((TextView) layout.findViewById(R.id.txv)).setText(headerText);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FastAdapter fa = this.adpt;

        return fa.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        this.adpt.onBindViewHolder(holder, position);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, @NonNull List<Object> payloads) {
        this.adpt.onBindViewHolder(holder, position, payloads);
    }


    @Override
    public void setHasStableIds(boolean hasStableIds) {
        this.adpt.setHasStableIds(hasStableIds);
    }

    @Override
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder holder) {
        this.adpt.onViewRecycled(holder);
    }

    @Override
    public boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder holder) {
        return this.adpt.onFailedToRecycleView(holder);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder holder) {
        this.adpt.onViewDetachedFromWindow(holder);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder holder) {
        this.adpt.onViewAttachedToWindow(holder);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        this.adpt.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        this.adpt.onDetachedFromRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return adpt.getItemCount();
    }

    @Override
    public int getNumColumns() {
        return 0;
    }

    @Override
    public int getSpanSize(int i) {
        return 0;
    }

    @Override
    public void registerAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver obs) {
        super.registerAdapterDataObserver(obs);
        adpt.registerAdapterDataObserver(obs);
    }

    @Override
    public void unregisterAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver observer) {
        super.unregisterAdapterDataObserver(observer);
        adpt.unregisterAdapterDataObserver(observer);
    }

    @Override
    public int getItemViewType(int position) {
        return adpt.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return adpt.getItemId(position);
    }

}
