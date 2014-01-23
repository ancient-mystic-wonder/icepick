package com.github.frankiesardo.icepick;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;
import icepick.Icepick;
import icepick.Icicle;

public class BaseCustomView extends TextView {

  @Icicle Integer backgroundColor = Integer.MAX_VALUE;

  public BaseCustomView(Context context) {
    super(context);
  }

  public BaseCustomView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public BaseCustomView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public void setBackgroundColorWithAnotherMethod(int color) {
    this.backgroundColor = color;
    setBackgroundColor(color);
  }

  @Override
  public Parcelable onSaveInstanceState() {
    return Icepick.saveInstanceState(this, super.onSaveInstanceState());
  }

  @Override
  public void onRestoreInstanceState(Parcelable state) {
    super.onRestoreInstanceState(Icepick.restoreInstanceState(this, state));
    if (backgroundColor != Integer.MAX_VALUE) {
      setBackgroundColorWithAnotherMethod(backgroundColor);
    }
  }
}
