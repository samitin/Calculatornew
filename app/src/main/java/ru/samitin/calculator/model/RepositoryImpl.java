package ru.samitin.calculator.model;

import android.os.Parcel;
import android.os.Parcelable;

public class RepositoryImpl implements Repository,Parcelable {
    private Double number=Double.NaN;

    public RepositoryImpl(Parcel in) {
        if (in.readByte() == 0) {
            number = null;
        } else {
            number = in.readDouble();
        }
    }

    public RepositoryImpl() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (number == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(number);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RepositoryImpl> CREATOR = new Creator<RepositoryImpl>() {
        @Override
        public RepositoryImpl createFromParcel(Parcel in) {
            return new RepositoryImpl(in);
        }

        @Override
        public RepositoryImpl[] newArray(int size) {
            return new RepositoryImpl[size];
        }
    };

    @Override
    public Double getNumber() {
        return number;
    }

    @Override
    public void setNumber(Double numder) {
        this.number=numder;
    }

    @Override
    public Double procent(Double num) {
        number=number%num;
        return number;
    }

    @Override
    public Double plus(Double num) {
        number=number+num;
        return number;
    }

    @Override
    public Double minus(Double num) {
        number=number-num;
        return number;
    }

    @Override
    public Double multiply(Double num) {
        number=number*num;
        return number;
    }

    @Override
    public Double division(Double num) {
        number=number/num;
        return number;
    }

    @Override
    public void clear() {
        number=Double.NaN;
    }

    @Override
    public boolean isNaN() {
        return number.equals(Double.NaN) ;
    }

}
