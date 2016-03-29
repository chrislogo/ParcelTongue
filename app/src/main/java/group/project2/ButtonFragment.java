package group.project2;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ButtonFragment extends Fragment {

    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.button_fragment, container, false);

        button = (Button) view.findViewById(R.id.newChatButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent myIntent = new Intent(getActivity(), NewChatActivity.class);
                //startActivity(myIntent);

            }
        });

        return view;
    }

}
