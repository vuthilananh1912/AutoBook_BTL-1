package com.vtlallklmc.autobook_btl.Main_Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.vtlallklmc.autobook_btl.LoginActivity;
import com.vtlallklmc.autobook_btl.R;
import com.vtlallklmc.autobook_btl.User.User;
import com.vtlallklmc.autobook_btl.User.UserDatabaseData;

public class PersonalFragment extends Fragment {
    TextView fullname;
    TextInputEditText phoneNumber, waitingCar;

    UserDatabaseData userDatabaseData;
    Button logout;

    private MainActivity parentActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_fragment,container,false);

        parentActivity = (MainActivity) getActivity();

        userDatabaseData = new UserDatabaseData(inflater.getContext());

        //ánh xạ
        fullname = view.findViewById(R.id.fullname);
        phoneNumber = view.findViewById(R.id.phone);
        waitingCar = view.findViewById(R.id.waiting_car);
        logout = view.findViewById(R.id.btnLogOut);

        User userInfo = userDatabaseData.findUserLogin(parentActivity.getPhoneUser());

        fullname.setText("Xin chào "+userInfo.getFullname()+"!😚");
        phoneNumber.setText(userInfo.getPhone());
        waitingCar.setText(userInfo.getCarname());

        return view;
    }
}
