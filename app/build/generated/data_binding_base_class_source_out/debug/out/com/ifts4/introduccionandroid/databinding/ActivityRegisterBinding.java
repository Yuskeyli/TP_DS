// Generated by view binder compiler. Do not edit!
package com.ifts4.introduccionandroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ifts4.introduccionandroid.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRegisterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnNext;

  @NonNull
  public final EditText editTextAge;

  @NonNull
  public final EditText editTextLastName;

  @NonNull
  public final EditText editTextName;

  @NonNull
  public final Spinner spinnerColors;

  @NonNull
  public final TextView tvTitleSpinner;

  private ActivityRegisterBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnNext,
      @NonNull EditText editTextAge, @NonNull EditText editTextLastName,
      @NonNull EditText editTextName, @NonNull Spinner spinnerColors,
      @NonNull TextView tvTitleSpinner) {
    this.rootView = rootView;
    this.btnNext = btnNext;
    this.editTextAge = editTextAge;
    this.editTextLastName = editTextLastName;
    this.editTextName = editTextName;
    this.spinnerColors = spinnerColors;
    this.tvTitleSpinner = tvTitleSpinner;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnNext;
      Button btnNext = ViewBindings.findChildViewById(rootView, id);
      if (btnNext == null) {
        break missingId;
      }

      id = R.id.editTextAge;
      EditText editTextAge = ViewBindings.findChildViewById(rootView, id);
      if (editTextAge == null) {
        break missingId;
      }

      id = R.id.editTextLastName;
      EditText editTextLastName = ViewBindings.findChildViewById(rootView, id);
      if (editTextLastName == null) {
        break missingId;
      }

      id = R.id.editTextName;
      EditText editTextName = ViewBindings.findChildViewById(rootView, id);
      if (editTextName == null) {
        break missingId;
      }

      id = R.id.spinnerColors;
      Spinner spinnerColors = ViewBindings.findChildViewById(rootView, id);
      if (spinnerColors == null) {
        break missingId;
      }

      id = R.id.tvTitleSpinner;
      TextView tvTitleSpinner = ViewBindings.findChildViewById(rootView, id);
      if (tvTitleSpinner == null) {
        break missingId;
      }

      return new ActivityRegisterBinding((ConstraintLayout) rootView, btnNext, editTextAge,
          editTextLastName, editTextName, spinnerColors, tvTitleSpinner);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
