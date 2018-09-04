package libs.mohamedgamal.smartdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.concurrent.Callable;

/**
 * Created by Mohamed Gamal on 8/26/2018.
 */

public class SmartDialog {

    private final Dialog dialog;
    private TextView dialogDismissBtn;
    private TextView dialogMsg;
    private TextView dialogActionBtn;
    private TextView dialogTitle;
    private ImageView dialogImage;
    private ConstraintLayout smartDialogContainer;

    public SmartDialog(@NonNull Context context) {
        dialog = new Dialog(context);
        init();
    }

    private void init() {

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.smart_dialog_layout);
        setWidthAndHeight(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        smartDialogContainer = dialog.findViewById(R.id.smartDialogContainer);
        dialogMsg = dialog.findViewById(R.id.dialogMsg);
        dialogTitle = dialog.findViewById(R.id.dialogTitle);
        dialogActionBtn = dialog.findViewById(R.id.dialogActionBtn);
        dialogDismissBtn = dialog.findViewById(R.id.dialogDismissBtn);
        dialogImage = dialog.findViewById(R.id.dialogImage);

        dialogDismissBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialogActionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    public SmartDialog setDialogBackgroundColorResId(int colorResId) {
        smartDialogContainer.setBackgroundColor(colorResId);
        return this;
    }

    public SmartDialog setDialogBackgroundDrawable(Drawable drawable) {
        smartDialogContainer.setBackground(drawable);
        return this;
    }

    public SmartDialog setDialogImageDrawable(Drawable drawable) {
        dialogImage.setVisibility(View.VISIBLE);
        dialogImage.setImageDrawable(drawable);
        return this;
    }

    public SmartDialog setDialogImageDimensions(int width, int height) {
        dialogImage.getLayoutParams().height = height;
        dialogImage.getLayoutParams().width = width;
        return this;
    }

    public SmartDialog setDialogImageScaleType(ImageView.ScaleType scaleType) {
        dialogImage.setScaleType(scaleType);
        return this;
    }

    public SmartDialog setDismissBtnTextColorResId(int colorResId) {
        dialogDismissBtn.setTextColor(colorResId);
        return this;
    }

    public SmartDialog setDismissBtnTextSize(float textSize) {
        dialogDismissBtn.setTextSize(textSize);
        return this;
    }

    public SmartDialog setDismissBtnBackgroundColorResId(int colorResId) {
        dialogDismissBtn.setBackgroundColor(colorResId);
        return this;
    }

    public SmartDialog setDismissBtnText(String text) {
        dialogDismissBtn.setText(text);
        return this;
    }

    public SmartDialog disableDismissBtn() {
        dialogDismissBtn.setVisibility(View.GONE);
        return this;
    }

    public SmartDialog setActionBtnClickAction(final Callable action) {
        dialogActionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dialog.dismiss();
                    action.call();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return this;
    }

    public SmartDialog setActionBtnTextColorResId(int colorResId) {
        dialogActionBtn.setTextColor(colorResId);
        return this;
    }

    public SmartDialog setActionBtnTextSize(float textSize) {
        dialogActionBtn.setTextSize(textSize);
        return this;
    }

    public SmartDialog setActionBtnBackgroundColorResId(int colorResId) {
        dialogActionBtn.setBackgroundColor(colorResId);
        return this;
    }

    public SmartDialog setActionBtnText(String text) {
        dialogActionBtn.setText(text);
        return this;
    }

    public SmartDialog disableActionBtn() {
        dialogActionBtn.setVisibility(View.GONE);
        return this;
    }

    public SmartDialog setTitleTextColorResId(int colorResId) {
        dialogTitle.setTextColor(colorResId);
        return this;
    }

    public SmartDialog setTitleTextSize(float textSize) {
        dialogTitle.setTextSize(textSize);
        return this;
    }

    public SmartDialog setDialogTitle(String title) {
        dialogTitle.setVisibility(View.VISIBLE);
        dialogTitle.setText(title);
        return this;
    }

    public SmartDialog setMessageTextColorResId(int colorResId) {
        dialogMsg.setTextColor(colorResId);
        return this;
    }

    public SmartDialog setMessageTextSize(float textSize) {
        dialogMsg.setTextSize(textSize);
        return this;
    }

    public SmartDialog setMessage(String text) {
        dialogMsg.setText(text);
        return this;
    }

    private void setWidthAndHeight(int width, int height) {
        dialog.getWindow().setLayout(width, height);
    }

    public SmartDialog bottom() {
        dialog.getWindow().getAttributes().gravity = Gravity.BOTTOM;
        return this;
    }

    public SmartDialog top() {
        dialog.getWindow().getAttributes().gravity = Gravity.TOP;
        return this;
    }

    public SmartDialog center() {
        dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        return this;
    }

    public SmartDialog setAnimationStyle(int styleRes) {
        dialog.getWindow().getAttributes().windowAnimations = styleRes;
        return this;
    }

    public SmartDialog setCanceledOnTouchOutsideDialog(boolean canceledOnTouchOutside) {
        dialog.setCanceledOnTouchOutside(canceledOnTouchOutside);
        return this;
    }

    public SmartDialog showDialog() {
        dialog.show();
        return this;
    }

    public SmartDialog dismissDialog() {
        dialog.dismiss();
        return this;
    }

    public SmartDialog applyUpUpAnimation() {
        dialog.getWindow().getAttributes().windowAnimations = R.style.upUpStyle;
        return this;
    }

    public SmartDialog applyUpDownAnimation() {
        dialog.getWindow().getAttributes().windowAnimations = R.style.upDownStyle;
        return this;
    }

    public SmartDialog applyDownDownAnimation() {
        dialog.getWindow().getAttributes().windowAnimations = R.style.downDownStyle;
        return this;
    }

    public SmartDialog applyDownUpAnimation() {
        dialog.getWindow().getAttributes().windowAnimations = R.style.downUpStyle;
        return this;
    }

    public SmartDialog applyLeftLeftAnimation() {
        dialog.getWindow().getAttributes().windowAnimations = R.style.leftLeftStyle;
        return this;
    }

    public SmartDialog applyLeftRightAnimation() {
        dialog.getWindow().getAttributes().windowAnimations = R.style.leftRightStyle;
        return this;
    }

    public SmartDialog applyRightRightAnimation() {
        dialog.getWindow().getAttributes().windowAnimations = R.style.rightRightStyle;
        return this;
    }

    public SmartDialog applyRightLeftAnimation() {
        dialog.getWindow().getAttributes().windowAnimations = R.style.rightLeftStyle;
        return this;
    }


}
