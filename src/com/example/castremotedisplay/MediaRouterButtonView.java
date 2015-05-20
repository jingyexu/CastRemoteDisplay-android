/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.castremotedisplay;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.app.MediaRouteButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

/*
 * Composite UI for a button with a cast icon and text label
 */
public class MediaRouterButtonView extends LinearLayout {

    private MediaRouteButton mMediaRouteButton;
    private TextView mTextView;

    public MediaRouterButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.MediaRouterButtonView, 0, 0);
        String buttonText = a.getString(R.styleable.MediaRouterButtonView_buttonText);
        a.recycle();

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.media_router_button_view, this, true);

        mMediaRouteButton = (MediaRouteButton) getChildAt(0);

        mTextView = (TextView) getChildAt(1);
        mTextView.setText(buttonText);
    }

    public MediaRouterButtonView(Context context) {
        this(context, null);
    }

    public MediaRouteButton getMediaRouteButton() {
        return mMediaRouteButton;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        // Simulate a click on the button as a click on the cast icon
        mMediaRouteButton.performClick();
        return false;
    }

}
