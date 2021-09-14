package model;

import android.os.Parcel;
import android.os.Parcelable;

public class data implements Parcelable {

    private String nama,umur,alamat;
//    private int id;



//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public data(String nama, String umur, String alamat){
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
    }

    protected data(Parcel in) {
        nama = in.readString();
        umur = in.readString();
        alamat = in.readString();

    }

    public static final Creator<data> CREATOR = new Creator<data>() {
        @Override
        public data createFromParcel(Parcel in) {
            return new data(in);
        }

        @Override
        public data[] newArray(int size) {
            return new data[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(umur);
        dest.writeString(alamat);

    }
}
