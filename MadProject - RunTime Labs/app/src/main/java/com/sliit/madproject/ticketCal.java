package com.sliit.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ticketCal extends AppCompatActivity {

    TextView textTicCount, textTicIncome, textTicTax;
    EditText etTotCount, etSoldCount, etTicketPrice;
    Button btnTicCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_cal);

        textTicCount = (TextView) findViewById(R.id.textTicCount);
        textTicIncome = (TextView) findViewById(R.id.textTicIncome);
        textTicTax = (TextView) findViewById(R.id.textTicTax);

        etTotCount = findViewById(R.id.etTotCount);
        etSoldCount = findViewById(R.id.etSoldCount);
        etTicketPrice = findViewById(R.id.etTicketPrice);

        btnTicCal = findViewById(R.id.btnTicCal);

        btnTicCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticketCal.this.CalTicketCenter();
            }
        });
    }

    public void CalTicketCenter() {
        String ticketCount = etTotCount.getText().toString();
        String ticketSold = etSoldCount.getText().toString();
        String ticketPrice = etTicketPrice.getText().toString();

        float totCountV = Float.parseFloat(ticketCount);
        float totSoldV = Float.parseFloat(ticketSold);
        float priceV = Float.parseFloat(ticketPrice);

        int avbTicketResult = (int) (totCountV - totSoldV);
        float totIncomeResult = totSoldV * priceV;
        float artistTaxResult = (float) ((totCountV * priceV) * 0.12);

        String avbTicket = "Avalible ticket Count : " + avbTicketResult;
        String totIncome = "Total ticket income : " + totIncomeResult;
        String artTax = "Artist Tax : " + artistTaxResult;

        textTicCount.setText(avbTicket);
        textTicIncome.setText(totIncome);
        textTicTax.setText(artTax);
    }
}