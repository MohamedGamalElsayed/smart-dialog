package samples.mohamedgamal.smartdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.Callable;

import libs.mohamedgamal.smartdialog.SmartDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button defaultDialogBtn, animatedDialogBtn, customDialogBtn, customWithTitleDialogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        defaultDialogBtn = findViewById(R.id.defaultDialogBtn);
        animatedDialogBtn = findViewById(R.id.animatedDialogBtn);
        customDialogBtn = findViewById(R.id.customDialogBtn);
        customWithTitleDialogBtn = findViewById(R.id.customWithTitleDialogBtn);

        defaultDialogBtn.setOnClickListener(this);
        animatedDialogBtn.setOnClickListener(this);
        customDialogBtn.setOnClickListener(this);
        customWithTitleDialogBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.defaultDialogBtn:
                onDefaultDialogBtnClick();
                break;
            case R.id.animatedDialogBtn:
                onAnimatedDialogBtnClick();
                break;
            case R.id.customWithTitleDialogBtn:
                onCustomDialogWithTitleBtnClick();
                break;
            case R.id.customDialogBtn:
                onCustomDialogBtnClick();
        }
    }

    private void onDefaultDialogBtnClick() {

        new SmartDialog(this)
                .disableActionBtn()
                .showDialog();
    }

    private void onAnimatedDialogBtnClick() {

        new SmartDialog(this)
                .setDialogTitle(getResources().getString(R.string.app_name))
                .setMessage("Smart Dialog Sample")
                .setDismissBtnText("dismiss")
                .bottom()
                .applyDownDownAnimation()
                .setCanceledOnTouchOutsideDialog(false)
                .showDialog();
    }

    private void onCustomDialogBtnClick() {

        new SmartDialog(this)
                .setMessage("Press Ok to show toast")
                .setMessageTextSize(20)
                .setMessageTextColorResId(getResources().getColor(libs.mohamedgamal.smartdialog.R.color.black))
                .setDismissBtnText("cancel")
                .setDismissBtnTextColorResId(getResources().getColor(libs.mohamedgamal.smartdialog.R.color.white))
                .setDismissBtnBackgroundColorResId(getResources().getColor(R.color.green))
                .setActionBtnText("Ok")
                .setActionBtnTextColorResId(getResources().getColor(libs.mohamedgamal.smartdialog.R.color.white))
                .setActionBtnBackgroundColorResId(getResources().getColor(R.color.green))
                .setActionBtnClickAction(new Callable() {
                    @Override
                    public Object call() throws Exception {
                        Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_SHORT).show();
                        return null;
                    }
                })
                .setDialogImageDrawable(getResources().getDrawable(R.drawable.android))
                .setDialogBackgroundColorResId(getResources().getColor(R.color.dark_off_white))
                .top()
                .applyLeftLeftAnimation()
                .showDialog();
    }

    private void onCustomDialogWithTitleBtnClick() {

        new SmartDialog(this)
                .setDialogTitle("Smart Dialog (Title)")
                .setMessage("Press Ok to exit app")
                .setDismissBtnText("cancel")
                .setActionBtnText("Ok")
                .setActionBtnClickAction(new Callable() {
                    @Override
                    public Object call() throws Exception {
                        finish();
                        return null;
                    }
                })
                .setActionBtnTextColorResId(getResources().getColor(R.color.black))
                .setDismissBtnTextColorResId(getResources().getColor(R.color.black))
                .setDialogImageDrawable(getResources().getDrawable(R.drawable.android))
                .center()
                .applyUpUpAnimation()
                .showDialog();
    }
}
