package com.wmt.youngkim.arduinohost;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends Activity {
    private static final String TAG = "MainActiity";

    private List<UsbDevice> devices;

    private ListView mDeviceListView;
    private DeviceListAdapter mDeviceListAdapter;
    private DeviceManager mDeviceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDeviceListView = (ListView) findViewById(R.id.device_list);
        mDeviceListAdapter = new DeviceListAdapter();
        mDeviceListView.setAdapter(mDeviceListAdapter);
        mDeviceListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                UsbDevice device = (UsbDevice) adapterView.getItemAtPosition(position);
                // TODO: Show device spec on fragment layout
            }
        });

        // TODO: list up USB devices
        check_devices();

        /*
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.deviceFragment, new DeviceFragment());
        fragmentTransaction.commit();
        */
    }

    private void check_devices() {
        UsbManager manager = (UsbManager) getSystemService(Context.USB_SERVICE);

        HashMap<String, UsbDevice> deviceList = manager.getDeviceList();
        Iterator<UsbDevice> deviceIterator = deviceList.values().iterator();
        while (deviceIterator.hasNext()) {
            UsbDevice device = deviceIterator.next();
            mDeviceListAdapter.addItem(device);
        }
    }

}
