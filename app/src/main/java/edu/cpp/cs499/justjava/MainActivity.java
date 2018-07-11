package edu.cpp.cs499.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display(1);
    }

    private int quantity = 1;
    private int basePrice = 5;

    private int whipPrice;
    private int chocPrice;

    public int getWhipPrice() {
        if (getCheckWhip()) {
            whipPrice = 1;
        } else {
            whipPrice = 0;
        }
        return whipPrice;
    }

    public int getChocPrice() {
        if (getCheckChoc()) {
            chocPrice = 2;
        } else {
            chocPrice = 0;
        }
        return chocPrice;
    }

    public void setChocPrice(int chocPrice) {
        this.chocPrice = chocPrice;
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = (basePrice + getWhipPrice() + getChocPrice()) * quantity;
        String priceMessage = getName();
        priceMessage = priceMessage + "\nAdd Whipped cream? " + getCheckWhip();
        priceMessage = priceMessage + "\nAdd Chocolate? " + getCheckChoc();
        priceMessage = priceMessage + "\nQuantity : " + quantity;
        priceMessage = priceMessage + "\nTotal: $" + price;
        priceMessage = priceMessage + "\nThank you ..!";
        displayMessage(priceMessage);
    }

    private boolean getCheckWhip() {
        CheckBox whipCheck = findViewById(R.id.is_Checked_Whip);
        return whipCheck.isChecked();
    }
    private boolean getCheckChoc() {
        CheckBox ChocCheck = findViewById(R.id.is_Checked_Chocolate);
        return ChocCheck.isChecked();
    }
    private String getName() {
        EditText name = (EditText) findViewById(R.id.name_edit_text);
        return name.getText().toString();
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(Integer.toString(number));
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void increment(View view) {
//        int quantity = 3;
        if (quantity != 10) {
            quantity++;
        } else {
            Toast.makeText(this, "You cannot order more than 10 cups",Toast.LENGTH_LONG).show();
        }
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(Integer.toString(quantity));
    }

    public void decrement(View view) {
//        int quantity = 1;
        if (quantity != 1) {
            quantity--;
        } else {
            Toast.makeText(this, "You cannot order less than 1 cup", Toast.LENGTH_LONG).show();
        }
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(Integer.toString(quantity));
    }
}
