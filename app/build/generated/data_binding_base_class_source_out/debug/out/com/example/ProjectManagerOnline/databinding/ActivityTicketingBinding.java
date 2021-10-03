// Generated by view binder compiler. Do not edit!
package com.example.ProjectManagerOnline.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.ProjectManagerOnline.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityTicketingBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final BottomNavigationView bottomNav;

  @NonNull
  public final Button btnAddCat;

  @NonNull
  public final Button btnViewallActivity;

  @NonNull
  public final EditText etAddCategory;

  @NonNull
  public final EditText etPrice;

  @NonNull
  public final EditText etTicketCont;

  @NonNull
  public final ImageView img1;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView1;

  @NonNull
  public final TextView topic1;

  private ActivityTicketingBinding(@NonNull RelativeLayout rootView,
      @NonNull BottomNavigationView bottomNav, @NonNull Button btnAddCat,
      @NonNull Button btnViewallActivity, @NonNull EditText etAddCategory,
      @NonNull EditText etPrice, @NonNull EditText etTicketCont, @NonNull ImageView img1,
      @NonNull TextView textView, @NonNull TextView textView1, @NonNull TextView topic1) {
    this.rootView = rootView;
    this.bottomNav = bottomNav;
    this.btnAddCat = btnAddCat;
    this.btnViewallActivity = btnViewallActivity;
    this.etAddCategory = etAddCategory;
    this.etPrice = etPrice;
    this.etTicketCont = etTicketCont;
    this.img1 = img1;
    this.textView = textView;
    this.textView1 = textView1;
    this.topic1 = topic1;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTicketingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTicketingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_ticketing, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTicketingBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bottom_nav;
      BottomNavigationView bottomNav = ViewBindings.findChildViewById(rootView, id);
      if (bottomNav == null) {
        break missingId;
      }

      id = R.id.btn_add_cat;
      Button btnAddCat = ViewBindings.findChildViewById(rootView, id);
      if (btnAddCat == null) {
        break missingId;
      }

      id = R.id.btn_viewall_activity;
      Button btnViewallActivity = ViewBindings.findChildViewById(rootView, id);
      if (btnViewallActivity == null) {
        break missingId;
      }

      id = R.id.etAddCategory;
      EditText etAddCategory = ViewBindings.findChildViewById(rootView, id);
      if (etAddCategory == null) {
        break missingId;
      }

      id = R.id.etPrice;
      EditText etPrice = ViewBindings.findChildViewById(rootView, id);
      if (etPrice == null) {
        break missingId;
      }

      id = R.id.etTicketCont;
      EditText etTicketCont = ViewBindings.findChildViewById(rootView, id);
      if (etTicketCont == null) {
        break missingId;
      }

      id = R.id.img1;
      ImageView img1 = ViewBindings.findChildViewById(rootView, id);
      if (img1 == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView1;
      TextView textView1 = ViewBindings.findChildViewById(rootView, id);
      if (textView1 == null) {
        break missingId;
      }

      id = R.id.topic1;
      TextView topic1 = ViewBindings.findChildViewById(rootView, id);
      if (topic1 == null) {
        break missingId;
      }

      return new ActivityTicketingBinding((RelativeLayout) rootView, bottomNav, btnAddCat,
          btnViewallActivity, etAddCategory, etPrice, etTicketCont, img1, textView, textView1,
          topic1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
