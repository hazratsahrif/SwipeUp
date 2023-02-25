package com.example.myapplication.ui.signup;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.provider.CalendarContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.EffectLayoutBinding;
import com.example.myapplication.databinding.FragmentBirthDayBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;


public class BirthDayFragment extends Fragment {
    FragmentBirthDayBinding binding;

    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBirthDayBinding.inflate(inflater,container,false);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);

        binding.etInput.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(getContext(), R.style.DialogTheme,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                                date.setText(day + "/" + (month + 1) + "/" + year);
                                binding.editText.setText((day + "/" + (month + 1) + "/" + year));
                            }
                        }, year, month, dayOfMonth);

                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.getDatePicker().setBackgroundColor(CalendarContract.Colors.TYPE_CALENDAR);
                datePickerDialog.show();
                if(binding.editText.toString().length()>0){
                    binding.btnNext.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.red));
                    binding.etInput.setBoxStrokeColor(ContextCompat.getColor(getContext(),R.color.green));


                }
                else {
                    binding.btnNext.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.hint_color));
                }

            }

        });


        binding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()>=8){
                    binding.btnNext.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.red));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.editText.getText().toString().length()>=8){
                    binding.btnNext.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.red));
                    NavHostFragment.findNavController(BirthDayFragment.this).navigate(R.id.action_birthDayFragment_to_setPasswordFragment);
                }
                else {
                    Toast.makeText(getContext(), "Please enter your birth date", Toast.LENGTH_SHORT).show();
                }

            }
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigateUp();
            }
        });
        return binding.getRoot();
    }
    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        String date = String.valueOf((new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year)));
        Toast.makeText(getContext(), "Date"+date, Toast.LENGTH_SHORT).show();

    }

    private void setDate() {
    }
}