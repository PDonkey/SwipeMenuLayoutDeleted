package com.swipemenulayoutdeleted;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.swipemenulayoutdeleted.data.DataBean;

import java.util.List;

import static android.R.id.list;

/**
 * Created by Administrator on 2017/9/4.
 *
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder>{
    private Context mMontext;
    private List<DataBean> beanList;
    public RecycleAdapter(Context context, List<DataBean> list){
        this.mMontext=context;
        this.beanList=list;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(mMontext).inflate(R.layout.item_rec_view,null);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final DataBean dataBean=beanList.get(position);
        Glide.with(mMontext).load(dataBean.getImgUrl()).into(holder.iv_avatar);
        holder.tv_title.setText(dataBean.getName());
        holder.tv_subTitle.setText(dataBean.getContent());

        holder.contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(mMontext, dataBean.getContent(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.view_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                beanList.remove(position);
                notifyDataSetChanged();
            }
        });

        holder.tv_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DataBean data = beanList.get(position);
                beanList.remove(position);
                beanList.add(0, data);
                notifyDataSetChanged();
            }
        });
        holder.view_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.swipeMenuLayout.collapseSmooth();
                Toast.makeText(mMontext, "编辑", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title;
        TextView tv_subTitle;
        TextView view_del;
        TextView view_edit;
        TextView tv_top;
        ImageView iv_avatar;
        SwipeMenuLayout swipeMenuLayout;
        View contentView;

        private MyViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.item_tv_title);
            tv_subTitle = (TextView) itemView.findViewById(R.id.item_tv_subTitle);
            tv_top = (TextView) itemView.findViewById(R.id.item_tv_top);
            contentView = itemView.findViewById(R.id.item_content);

            view_del = (TextView) itemView.findViewById(R.id.item_tv_del);
            view_edit = (TextView) itemView.findViewById(R.id.item_tv_edit);
            swipeMenuLayout = (SwipeMenuLayout) itemView.findViewById(R.id.item_layout_swip);
            iv_avatar = (ImageView) itemView.findViewById(R.id.item_avatar);
        }
    }
}
