package Challenge;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.freecodecampeg.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class UI_Challenge1 extends AppCompatActivity {

    //edit txt
    private EditText editTxtName, editTxtEmail, editTxtPassword,editTxtPassRepeat;

    //btn
    private Button btnUploadImage, btnRegister;

    //text view
    private TextView txtWarnName, txtWarnEmail, txtWarnPass, txtWarnRepeatPass;

    //Spinner
    private Spinner spinnerCountry;

    //radio
    private RadioGroup rgGender;

    //checkbox
    private CheckBox agreementCheck;

    //constraint layout
    private ConstraintLayout parent;


    @Override  //starting point
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_challenge1); //link dgn xml

        initViews(); //find view by id

        //onclick on upload image
        btnUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UI_Challenge1.this, "Choose image", Toast.LENGTH_SHORT).show();
            }
        });


        //onclick on register
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initRegister();
            }
        });








    } //oncreate


    //init
    private void initViews(){
        Log.d("TAG","Initviews started");
        System.out.println("Initviews started");

        editTxtName= findViewById(R.id.editTxtName);
        editTxtEmail= findViewById(R.id.editTxtEmail);
        editTxtPassword= findViewById(R.id.editTxtPassword);
        editTxtPassRepeat= findViewById(R.id.editTxtPassRepeat);

        //btn
        btnUploadImage= findViewById(R.id.btnUploadImage);
        btnRegister= findViewById(R.id.btnRegister2);

        //textview
        txtWarnName= findViewById(R.id.txtWarnName);
        txtWarnEmail= findViewById(R.id.txtWarnEmail);
        txtWarnPass= findViewById(R.id.txtWarnPass);
        txtWarnRepeatPass= findViewById(R.id.txtWarnRepeatPass);

        //spinner
        spinnerCountry= findViewById(R.id.spinnerCountry);

        //checkbox
        agreementCheck= findViewById(R.id.agreementCheck);

        //radio group
        rgGender= findViewById(R.id.rgGender);

        //constraint
        parent= findViewById(R.id.parent);




    }


    //register
    private void initRegister(){
        Log.d("Register", "Init register started");

        if (validateData()){

            if (agreementCheck.isChecked()){ //checkbox is checked
                showSnackBar();
            }
            else {
                Toast.makeText(this, "You need to agree with the license", Toast.LENGTH_SHORT).show();
            }







        }//if valid
        else {
            Toast.makeText(this, "Not valid", Toast.LENGTH_SHORT).show();
        }




    }//endof register


    //show snack bar
    private void showSnackBar(){
        Log.d("Snack", "Show snack bar started");

        //change visibility of warning text
        txtWarnName.setVisibility(View.GONE);
        txtWarnEmail.setVisibility(View.GONE);
        txtWarnPass.setVisibility(View.GONE);
        txtWarnRepeatPass.setVisibility(View.GONE);

        //get user data
        String name= editTxtName.getText().toString();
        String email= editTxtEmail.getText().toString();
        String country= spinnerCountry.getSelectedItem().toString();

        String gender="";

        int radioButtonId= rgGender.getCheckedRadioButtonId();

        if (radioButtonId==R.id.rbMale){
            gender= "Male";
        }
        else {
            gender="Female";
        }

        //text in snack
        String snackText=
                String.format("Name: %s\n" +
                        "Email: %s\n" +
                        "Gender: %s\n" +
                        "County: %s\n", name, email, gender, country);



        //snack bar
        Snackbar.make(parent, snackText, Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { //clear all the edit text after clicking Dismiss
                        editTxtName.setText("");
                        editTxtEmail.setText("");
                        editTxtPassword.setText("");
                        editTxtPassRepeat.setText("");

                    }
                })
                .show();


    }//end of show snack bar

    //validate data
    private boolean validateData(){
        Log.d("Validate data", "Validating data started");

        if (editTxtName.getText().toString().equals("")){ //empty string
            txtWarnName.setVisibility(View.VISIBLE); //warning will appear
            txtWarnName.setText("Enter your name");
            return false;
        }


        if (editTxtEmail.getText().toString().equals("")){
            txtWarnEmail.setVisibility(View.VISIBLE);
            txtWarnEmail.setText("Enter your email");
            return false;
        }

        if (editTxtPassword.getText().toString().equals("")){
            txtWarnPass.setVisibility(View.VISIBLE);
            txtWarnPass.setText("Enter your password");
            return false;
        }

        if (editTxtPassRepeat.getText().toString().equals("")){
            txtWarnRepeatPass.setVisibility(View.VISIBLE);
            txtWarnRepeatPass.setText("Re-enter your password");
            return false;
        }

        //validate to make sure password is same
        if (! editTxtPassword.getText().toString().equals( editTxtPassRepeat.getText().toString()  )     ){
            txtWarnRepeatPass.setVisibility(View.VISIBLE);
            txtWarnRepeatPass.setText("Password does not match");
            return false;
        }

        return true;
    } //endof validate









}
