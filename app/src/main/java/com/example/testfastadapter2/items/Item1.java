package com.example.testfastadapter2.items;

import android.view.View;
import android.widget.TextView;

import com.example.testfastadapter2.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.items.AbstractItem;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Item1 extends AbstractItem<Item1.ViewHolder> implements IItem<Item1.ViewHolder> {

    @NotNull
    @Override
    public ViewHolder getViewHolder(@NotNull View view) {
        return new ViewHolder(view);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item1_layout;
    }

    @Override
    public int getType() {
        return 0;
    }

    public class ViewHolder extends FastAdapter.ViewHolder<Item1> {
        TextView txv;

        public ViewHolder(@NotNull View itemView) {
            super(itemView);

            txv = itemView.findViewById(R.id.txv);
        }


        @Override
        public void bindView(@NotNull Item1 item, @NotNull List<Object> list) {
            txv.setText("ITEM 1");
        }

        @Override
        public void unbindView(@NotNull Item1 item) {
            txv.setText("");
        }
    }
}
