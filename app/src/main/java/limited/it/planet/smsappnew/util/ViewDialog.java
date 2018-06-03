package limited.it.planet.smsappnew.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import limited.it.planet.smsappnew.R;
import limited.it.planet.smsappnew.activity.MainActivity;

/**
 * Created by Tarikul on 4/24/2018.
 */

public class ViewDialog {
    FontCustomization fontCustomization;
     Dialog dialog;

    public void showDialog(final Activity activity, String msg){
        fontCustomization = new FontCustomization(activity);

        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog);

        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
        text.setText(msg);
        text.setTypeface(fontCustomization.getTexgyreHerosRegular());

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
        dialogButton.setTypeface(fontCustomization.getTexgyreHerosRegular());

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  dialog.dismiss();
                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
                ((Activity)activity).finish();
            }
        });

        dialog.show();

    }

    public void canCelDialog(){
        dialog.setCancelable(true);
    }
}
