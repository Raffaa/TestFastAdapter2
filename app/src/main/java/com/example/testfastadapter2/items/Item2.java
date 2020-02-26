package com.example.testfastadapter2.items;

import android.view.View;
import android.widget.TextView;

import com.example.testfastadapter2.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.items.AbstractItem;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Item2 extends AbstractItem<Item2.ViewHolder> implements IItem<Item2.ViewHolder> {
    @NotNull
    @Override
    public ViewHolder getViewHolder(@NotNull View view) {
        return new ViewHolder(view);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item2_layout;
    }

    @Override
    public int getType() {
        return 0;
    }

    public class ViewHolder extends FastAdapter.ViewHolder<Item2> {

        TextView txv;

        public ViewHolder(@NotNull View itemView) {
            super(itemView);

            txv = itemView.findViewById(R.id.txv);
        }

        @Override
        public void bindView(@NotNull Item2 item, @NotNull List<Object> list) {
            txv.setText("ITEM 2");
        }

        @Override
        public void unbindView(@NotNull Item2 item) {
            txv.setText("");
        }
    }
}
