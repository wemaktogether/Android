package com.wmt.youngkim.arduinohost;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DeviceListAdapter extends BaseAdapter {
    private ArrayList<UsbDevice> mDevices = new ArrayList<>();

    @Override
    public int getCount() {
        return mDevices.size();
    }

    @Override
    public UsbDevice getItem(int position) {
        return mDevices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Context context = parent.getContext();

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.device_item, parent, false);
        }

        ImageView itemImg = (ImageView) view.findViewById(R.id.item_image);
        TextView itemTxt = (TextView) view.findViewById(R.id.item_name);
        UsbDevice item = getItem(position);

        itemImg.setImageDrawable(null);
        itemTxt.setText(item.getDeviceName());

        return view;
    }

    public void addItem(UsbDevice device) {
        mDevices.add(device);
    }
}
