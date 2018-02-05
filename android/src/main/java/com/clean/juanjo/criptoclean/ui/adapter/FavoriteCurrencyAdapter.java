package com.clean.juanjo.criptoclean.ui.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.clean.juanjo.criptoclean.R;
import com.clean.juanjo.presentation.base.model.Cripto;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by juanj on 04/01/2018.
 */

public class FavoriteCurrencyAdapter extends RecyclerView.Adapter<FavoriteCurrencyAdapter.CriptoViewHolder> {
    private List<Cripto> list;

    public FavoriteCurrencyAdapter() {
        list = new ArrayList<>();
    }

    @Override
    public FavoriteCurrencyAdapter.CriptoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_fav_crypto, parent,
                false);
        CriptoViewHolder criptoViewHolder = new CriptoViewHolder(v);

        return criptoViewHolder;
    }

    @Override
    public void onBindViewHolder(FavoriteCurrencyAdapter.CriptoViewHolder criptoViewHolder, int position) {

        criptoViewHolder.tvTitle.setText(String.format("%s. %s (%s) ",list.get(position).getRank(),
                list.get(position).getName(),list.get(position).getSymbol()));
        criptoViewHolder.tvUsdPrice.setText(String.format("%.2f USD",list.get(position).getPriceUsd()));
        criptoViewHolder.tvEurPrice.setText(String.format("%.2f EUR",list.get(position).getPriceEur()));
        criptoViewHolder.tvBtcPrice.setText(String.format("%s BTC",list.get(position).getPriceBtc()));

        if(list.get(position).getPercentChange1h() > 0 )
            criptoViewHolder.tvOneHourChange.setTextColor(Color.parseColor("#1B5E20"));
        else
            criptoViewHolder.tvOneHourChange.setTextColor(Color.parseColor("#B71C1C"));

        if(list.get(position).getPercentChange24h() > 0 )
            criptoViewHolder.tvOneDayChange.setTextColor(Color.parseColor("#1B5E20"));
        else
            criptoViewHolder.tvOneDayChange.setTextColor(Color.parseColor("#B71C1C"));

        if(list.get(position).getPercentChange7d() > 0 )
            criptoViewHolder.tvOneWekChange.setTextColor(Color.parseColor("#1B5E20"));
        else
            criptoViewHolder.tvOneWekChange.setTextColor(Color.parseColor("#B71C1C"));

        criptoViewHolder.tvOneHourChange.setText(String.format("1H: %.2f %%",list.get(position).getPercentChange1h()));
        criptoViewHolder.tvOneDayChange.setText(String.format("24H: %.2f %%",list.get(position).getPercentChange24h()));
        criptoViewHolder.tvOneWekChange.setText(String.format("7D: %.2f %% ",list.get(position).getPercentChange7d()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public Cripto getItem(int position){
        return list.get(position);
    }

    public void refreshData(List<Cripto> cripto){

        if(cripto != null){
            list.clear();
            list = cripto;
        }
        notifyDataSetChanged();

    }

    public static class CriptoViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_cripto_title)
        TextView tvTitle;
        @BindView(R.id.tv_cripto_usd)
        TextView tvUsdPrice;
        @BindView(R.id.tv_cripto_btc)
        TextView tvBtcPrice;
        @BindView(R.id.tv_cripto_eur)
        TextView tvEurPrice;
        @BindView(R.id.tv_cripto_1h)
        TextView tvOneHourChange;
        @BindView(R.id.tv_cripto_24h)
        TextView tvOneDayChange;
        @BindView(R.id.tv_cripto_7d)
        TextView tvOneWekChange;

        public CriptoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
