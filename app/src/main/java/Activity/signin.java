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

import com.example.clickshop.Mpreference;
import com.example.clickshop.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import io.github.muddz.styleabletoast.StyleableToast;

public class signin extends AppCompatActivity {
    Button sign_in;
    TextView forgot_password ,no_account;
    EditText signin_email,signin_password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        sign_in=findViewById(R.id.btn_signin);
        forgot_password=findViewById(R.id.forget_password);
        signin_email=findViewById(R.id.signin_email);
        signin_password=findViewById(R.id.signin_password);
        no_account=findViewById(R.id.dont_have_acc);
        mAuth = FirebaseAuth.getInstance();
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=signin_email.getText().toString().trim();
                String password=signin_password.getText().toString().trim();
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    signin_email.setError("enter the valid email");
                    signin_email.requestFocus();
                }
                else if (signin_password.length()<6){
                    signin_password.setError("pls enter the password containing atleast 6 characters");
                    signin_password.requestFocus();
                }else {


                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                StyleableToast.makeText(signin.this, "successfully signed", R.style.mytoast).show();
                                Mpreference.setLogin(signin.this);
                                Intent i = new Intent(signin.this, ProductView.class);
                                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(i);
                            } else {

                                StyleableToast.makeText(signin.this, task.getException().getLocalizedMessage().toString(), R.style.mytoast).show();
                            }
                        }
                    });
                }
            }

        });
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        no_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(signin.this, signup.class);
                startActivity(intent);

            }
        });


    }
}