package Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.clickshop.R;
import com.example.clickshop.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


import io.github.muddz.styleabletoast.StyleableToast;

public class signup extends AppCompatActivity {
    EditText signup_password,confirm_password,username,signup_email;
    Button signup_btn;
    TextView already_account;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        signup_password=findViewById(R.id.signup_password);
        confirm_password=findViewById(R.id.signup_confpassword);
        username=findViewById(R.id.username);
        signup_email=findViewById(R.id.signup_email);
        signup_btn=findViewById(R.id.btn_signup);
        already_account=findViewById(R.id.havean_account);

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edtUsername=username.getText().toString().trim();
                String txtpassword=signup_password.getText().toString().trim();
                String txtEmail=signup_email.getText().toString().trim();
                String txtconformpass=confirm_password.getText().toString().trim();
                if(edtUsername.isEmpty()){
                    username.setError("pls enter username");
                    username.requestFocus();}

              else  if (!Patterns.EMAIL_ADDRESS.matcher(txtEmail).matches()){
                    signup_email.setError("enter the valid email");
                    signup_email.requestFocus();
                }

                else  if (txtpassword.length()<6){
                    signup_password.setError("pls enter the password containing atleast six digits");
                    signup_password.requestFocus();
                }

                else if (!txtpassword.equals(txtconformpass)){
                    confirm_password.setError("pls enter the same password");
                    confirm_password.requestFocus();

            }else
            {
                    mAuth.createUserWithEmailAndPassword(txtEmail, txtpassword)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                       User user = new User(edtUsername, txtpassword,  txtconformpass,txtEmail);
                                        insertUser(user);

                                    } else {
                                        StyleableToast.makeText(signup.this,task.getException().getLocalizedMessage(),R.style.mytoast).show();
                                    }
                                }
                            });
                }

            }


        });
        already_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(signup.this, signin.class);
                startActivity(intent);
            }
        });
    }

    private void insertUser(User user) {
      //  Log.d("TAG", "insertUser: ");
        FirebaseDatabase.getInstance().getReference("user").child(FirebaseAuth.getInstance().getUid())
                .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    StyleableToast.makeText(signup.this,"user registered successfully",R.style.mytoast).show();
              Intent intent=new Intent(signup.this,signin.class);
              startActivity(intent);
                } else {
                    StyleableToast.makeText(signup.this,"registerion failed",R.style.mytoast).show();
                }

            }
        });
    }
}