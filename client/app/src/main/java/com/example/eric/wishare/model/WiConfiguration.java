package com.example.eric.wishare.model;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.net.wifi.WifiConfiguration;
import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint("ParcelCreator")
public class WiConfiguration extends WifiConfiguration implements Parcelable {

    private String mSSID;
    private String mPassword;
    private String mNetworkID;

    public WiConfiguration(String mSSID, String mPassword, String network_id) {
        super();
        this.mSSID = mSSID;
        this.mPassword = mPassword;
        this.mNetworkID = network_id;
        SSID = mSSID;
    }

    public WiConfiguration(String mSSID, String mPassword) {
        super();
        this.mSSID = mSSID;
        this.mPassword = mPassword;
        SSID = mSSID;
    }

    public WiConfiguration(WifiConfiguration config, String pwd) {
        this.mSSID = config.SSID;
        this.mPassword = pwd;
    }


    public WiConfiguration(Parcel source) {
//        System.out.println("SOURCE.READSTRING(SSID = ): " + source.readString());
        this.mSSID = source.readString();
        this.mPassword = source.readString();
    }

    public static final Creator<WiConfiguration> CREATOR = new Creator<WiConfiguration>() {
        @Override
        public WiConfiguration createFromParcel(Parcel source) {
            return new WiConfiguration(source);
        }

        @Override
        public WiConfiguration[] newArray(int size) {
            return new WiConfiguration[size];
        }
    };

    public String getSSID() {
        return mSSID.replace("\"", "");
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public void setSSID(String ssid) {
        mSSID = ssid;
    }

    public String getNetworkID(){return mNetworkID;}

    @Override
    public int describeContents() {
        return super.describeContents();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSSID);
        dest.writeString(mPassword);
    }

    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("ssid", mSSID);
            json.put("pwd", mPassword);
        } catch (JSONException e) {

        }
        return json;
    }

    public ContentValues toContentValues(){
        ContentValues vals = new ContentValues();
        vals.put("SSID", mSSID);
        vals.put("password", mPassword);
        return vals;
    }
}
