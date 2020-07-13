package cm.ubuea.covider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class dmLogin extends AppCompatActivity {

    EditText name_p,id_p,id_token;
    Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_login);

        name_p = (EditText) findViewById(R.id.name_p);
        id_p = (EditText) findViewById(R.id.id_p);
        id_token = (EditText) findViewById(R.id.id_token);

        Button login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validation();
                // Toast.makeText(getApplicationContext(), "Message sent, will be in touch", Toast.LENGTH_LONG).show();
                Intent gotoDisTracking = new Intent(getApplicationContext(), dmList.class);
                startActivity(gotoDisTracking);

            }
        });


//    private void validation() {
//        String mName = name_p.getText().toString();
//        String mId = id_p.getText().toString();
//       // String mToken = id_token.getText().toString();
//
//        //validate for empty edittext field
//
//        if (mName.matches("")){
//             //Toast.makeText(getApplicationContext(), "Enter Name", Toast.LENGTH_LONG).show();
//            name_p.setError("Enter Name");
//            return false;
//        }
//        //validate for name to not contain numbers, symbols
//        if (!mName.matches("[a-zA-Z]+")){
//            Toast.makeText(getApplicationContext(), "Enter Valid Name", Toast.LENGTH_LONG).show();
//            return;
//        }
//        //validate email
//
//        //if email is empty
//        //validate for empty edittext field
//
////        if (mEmail.matches("")){
////            Toast.makeText(getApplicationContext(), "Enter Name", Toast.LENGTH_LONG).show();
////            return;
////        }
////        if (!Patterns.EMAIL_ADDRESS.matcher(mEmail).matches()){
////            Toast.makeText(getApplicationContext(), "Enter Valid Name", Toast.LENGTH_LONG).show();
////            return;
////        }
//
//        // if id field is empty
//        if (mId.matches("")){
//            Toast.makeText(getApplicationContext(), "Enter ID", Toast.LENGTH_LONG).show();
//            return;
//        }
//        //validate id
//        if (!(Patterns.PHONE.matcher(mId).matches() || mId.length() !=4)){
//            Toast.makeText(getApplicationContext(), "Enter Valid ID", Toast.LENGTH_LONG).show();
//            return;
//        }
//
//        // if id token field is empty
////        if (.matches("")){
////            Toast.makeText(getApplicationContext(), "Enter ID", Toast.LENGTH_LONG).show();
////            return;
////        }
////        //validate id
////        if (!Patterns.PHONE.matcher(mId).matches()){
////            Toast.makeText(getApplicationContext(), "Enter Valid ID", Toast.LENGTH_LONG).show();
////            return;
////        }
//
//        private boolean validateName () {
//            String nameInput = name_p.getEditableText().getFilters().toString().trim();
//            if (nameInput.isEmpty()) {
//                name_p.setError("Enter Name");
//                return false;
//            } else if (!Patterns.PHONE.matcher(nameInput).matches()) {
//                name_p.setError("Enter Valid Name");
//            } else {
//                name_p.setError(null);
//            }
//        }
    }}
