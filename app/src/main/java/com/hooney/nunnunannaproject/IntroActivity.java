package com.hooney.nunnunannaproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;


public class IntroActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SliderPage sliderPage1 = new SliderPage();
        sliderPage1.setTitle("눈누난나를 소개해요!");
        sliderPage1.setTitleColor(getColor(R.color.black));
        sliderPage1.setDescription("눈누난나는 황반변성 의심증상을\n조기에 확인할 수 있는 앱이에요.");
        sliderPage1.setImageDrawable(R.drawable.intro_1);
        sliderPage1.setBgColor(Color.WHITE);
        sliderPage1.setDescColor(getColor(R.color.black));
        addSlide(AppIntroFragment.newInstance(sliderPage1));

        SliderPage sliderPage2 = new SliderPage();
        sliderPage2.setTitle("정확한 검사거리와 검사화면 크기");
        sliderPage2.setTitleColor(getColor(R.color.black));
        sliderPage2.setDescription("적정검사거리를 음성으로 조절해드려요.\n기종에 상관없이 정확한 크기의\n검사화면을 보여드리구요.");
        sliderPage2.setImageDrawable(R.drawable.intro_2);
        sliderPage2.setBgColor(Color.WHITE);
        sliderPage2.setDescColor(getColor(R.color.black));
        addSlide(AppIntroFragment.newInstance(sliderPage2));

        SliderPage sliderPage3 = new SliderPage();
        sliderPage3.setTitle("정기적인 검사를 도와드려요");
        sliderPage3.setTitleColor(getColor(R.color.black));
        sliderPage3.setDescription("검사 날짜를 기억할 필요가 없어요.\n정기적으로 검사시기를 알려드리니,\n꾸준히 검사해보세요.");
        sliderPage3.setImageDrawable(R.drawable.intro_3);
        sliderPage3.setBgColor(Color.WHITE);
        sliderPage3.setDescColor(getColor(R.color.black));
        addSlide(AppIntroFragment.newInstance(sliderPage3));

        SliderPage sliderPage4 = new SliderPage();
        sliderPage4.setTitle("유용한 그래프");
        sliderPage4.setTitleColor(getColor(R.color.black));
        sliderPage4.setDescription("나의 기록들을 그래프로 볼 수 있어요.\n원하는 날짜의 결과도 자세히 볼 수 있지요.");
        sliderPage4.setImageDrawable(R.drawable.intro_4);
        sliderPage4.setBgColor(Color.WHITE);
        sliderPage4.setDescColor(getColor(R.color.black));
        addSlide(AppIntroFragment.newInstance(sliderPage4));

        ((ImageButton)this.backButton).setColorFilter(getColor(R.color.black));
        ((ImageButton)this.nextButton).setColorFilter(getColor(R.color.black));
        ((AppCompatButton)this.doneButton).setTextColor(getColor(R.color.black));
        ((AppCompatButton)this.doneButton).setText("시작하기");

        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.parseColor("#ffffff"));
        setSeparatorColor(Color.parseColor("#000000"));

        // Hide Skip/Done button.
        showSkipButton(false);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
        this.mController.setSelectedIndicatorColor(getColor(R.color.black));
        this.mController.setUnselectedIndicatorColor(getColor(R.color.unselect));
    }
}
