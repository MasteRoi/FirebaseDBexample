package sadika.roi.workoutdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

import static android.R.attr.name;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date d = new Date();
        CharSequence s = DateFormat.format("hh:mm:ss", d.getTime());
        CharSequence ds = DateFormat.format("dd/MM/yy", d.getTime());
        d.setTime(System.currentTimeMillis()+(60*60*1000));
        CharSequence s1 = DateFormat.format("hh:mm:ss", d.getTime());

        Button mUpdateButton = (Button) findViewById(R.id.updateButton);
        final EditText mEditStart = (EditText) findViewById(R.id.startTimeEdit);
        final EditText mEditEnd = (EditText) findViewById(R.id.endTimeEdit);
        final EditText mEditAddress = (EditText) findViewById(R.id.editAddress);
        final EditText mEditDate = (EditText) findViewById(R.id.editDate);
        final EditText mEditBranch = (EditText) findViewById(R.id.editBranch);
        final EditText mEditDesc = (EditText) findViewById(R.id.editDesc);
        mEditStart.setText(s);
        mEditEnd.setText(s1);
        mEditDate.setText(ds);

        // Parent
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference trainRef = database.getReference("Training");



        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trainRef.child("Start Training").setValue(mEditStart.getText().toString());
                trainRef.child("End Training").setValue(mEditEnd.getText().toString());
                trainRef.child("Address").setValue(mEditAddress.getText().toString());
                trainRef.child("Date").setValue(mEditDate.getText().toString());
                trainRef.child("Sport Branch").setValue(mEditBranch.getText().toString());
                trainRef.child("Description").setValue(mEditDesc.getText().toString());
            }
        });




    }



}


