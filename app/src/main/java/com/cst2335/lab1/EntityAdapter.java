package com.cst2335.lab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class EntityAdapter extends BaseAdapter {
    private Context context;
    private List<Entity> entityList;

    public EntityAdapter(Context context, List<Entity> entityList) {
        this.context = context;
        this.entityList = entityList;
    }

    @Override
    public int getCount() {
        return entityList.size();
    }

    @Override
    public Object getItem(int position) {
        return entityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.entity_item, parent, false);
        }

        ImageView entityIcon = convertView.findViewById(R.id.entityIcon);
        TextView entityName = convertView.findViewById(R.id.entityName);
        final TextView entityDescription = convertView.findViewById(R.id.entityDescription);

        Entity entity = (Entity) getItem(position);

        entityName.setText(entity.getName());
        entityDescription.setText(entity.getDescription());

        String iconName = "entity_" + entity.getType();
        int resId = context.getResources().getIdentifier(iconName, "drawable", context.getPackageName());

        entityIcon.setImageResource(resId);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entityDescription.getVisibility() == View.GONE) {
                    entityDescription.setVisibility(View.VISIBLE);
                } else {
                    entityDescription.setVisibility(View.GONE);
                }
            }
        });

        return convertView;
    }
}
