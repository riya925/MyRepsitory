package com.example.project.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.project.R;
import com.example.project.RecordScreen;

public class HomeFragment extends Fragment implements View.OnClickListener
{
    private CardView recordcard,partiescard,analysiscard,orderscard,paymentscard,
            predictioncard,timespancard,budgetcard,feedbackcard;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);

        recordcard=root.findViewById(R.id.record_card);
        partiescard=root.findViewById(R.id.parties_card);
        orderscard=root.findViewById(R.id.orders_card);
        paymentscard=root.findViewById(R.id.payments_card);
        analysiscard=root.findViewById(R.id.analysis_card);
//        predictioncard=root.findViewById(R.id.prediction_card);
//        timespancard=root.findViewById(R.id.timespan_card);
//        budgetcard=root.findViewById(R.id.budget_card);
        feedbackcard=root.findViewById(R.id.feedback_card);

        recordcard.setOnClickListener(this);
        partiescard.setOnClickListener(this);
        orderscard.setOnClickListener(this);
        paymentscard.setOnClickListener(this);
        analysiscard.setOnClickListener(this);
//        predictioncard.setOnClickListener(this);
//        timespancard.setOnClickListener(this);
//        budgetcard.setOnClickListener(this);
        feedbackcard.setOnClickListener(this);

//        recordcard.setVisibility(View.INVISIBLE);
//
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch(view.getId()){
            case R.id.record_card : i=new Intent(getContext(),RecordScreen.class);
                                    startActivity(i);
                                    break;
            case R.id.parties_card: i=new Intent(getContext(),Parties.class);
                                    startActivity(i);
                                    break;
//            case R.id.orders_card : i=new Intent(getContext(),Orders.class);
//                                    startActivity(i);
//                                    break;
//            case R.id.payments_card: i=new Intent(getContext(),Payments.class);
//                                     startActivity(i);
//                                     break;
            case R.id.analysis_card: i=new Intent(getContext(),Prediction.class);
                                     startActivity(i);
                                     break;
//            case R.id.prediction_card: i=new Intent(getContext(),Prediction.class);
//                                        startActivity(i);
//                                        break;
//            case R.id.timespan_card: i=new Intent(getContext(),TimeSpan.class);
//                                    startActivity(i);
//                                    break;
//            case R.id.budget_card: i=new Intent(getContext(),Budget.class);
//                                    startActivity(i);
//                                    break;
            case R.id.feedback_card: i=new Intent(getContext(),Feedback.class);
                                    startActivity(i);
                                    break;
            default:break;
        }
    }
}