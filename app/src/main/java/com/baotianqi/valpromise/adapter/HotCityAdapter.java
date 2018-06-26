package com.baotianqi.valpromise.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.baotianqi.valpromise.R;
import com.baotianqi.valpromise.bean.CityBean;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by kuanglingbo on 2018/3/18.
 */

public class HotCityAdapter extends BaseAdapter {

    private final List<CityBean.Hot> list;

    private final Context context;

    private final LayoutInflater layoutInflater;

    private int cuurIndex = -1;

    public HotCityAdapter (Context context, List<CityBean.Hot> list) {
        this.context = context;
        this.list = list;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount () {
        if (list != null) {
            return list.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem (int position) {
        return list.get(position);
    }

    @Override
    public long getItemId (int position) {
        return position;
    }

    public int getCuurIndex () {
        return cuurIndex;
    }

    public void setCuurIndex (int cuurIndex) {
        this.cuurIndex = cuurIndex;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.hot_city_item_view, parent, false);
        }

        TextView tv = (TextView) convertView;


        final CityBean.Hot cityOv = list.get(position);
        tv.setText(cityOv.getCnName());
        convertView.setTag(cityOv);

        return convertView;
    }

    /**
     * 刷新单个item
     */
    public void refresGridView (GridView gridView, int position) {
        int start = gridView.getFirstVisiblePosition();
        int last = gridView.getLastVisiblePosition();
        for (int i = start, j = last; i <= j; i++) {
            View convertView = gridView.getChildAt(position - start);
            TextView textView;
            if (convertView != null) {
                textView = (TextView) convertView;
                if (position == i) {
                    textView.setBackgroundResource(R.drawable.shape_city_defaut_bg);//被选择是的背景
                    textView.setTextColor(Color.WHITE);
                } else {
                    textView.setBackgroundResource(R.drawable.shape_city_select_bg);//未被选择时的背景
                    textView.setTextColor(context.getResources().getColor(R.color.tv_6));
                }
            }
        }
    }

    public void setData (@Nullable List<CityBean.Hot> hotCityList) {
        if (hotCityList != null) {
            list.addAll(hotCityList);
            notifyDataSetChanged();
        }
    }
}
