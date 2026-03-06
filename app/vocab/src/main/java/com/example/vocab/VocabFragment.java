package com.example.vocab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

// Dùng cho màn hình landscape
public class VocabFragment extends DialogFragment {


    Vocab vocab;
    VocabFragment(Vocab vocab){
        this.vocab = vocab;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.vocab_layout, container, false);

        // Hiển thị từ gốc
        TextView termTextView = rootView.findViewById(R.id.termTextView);
        termTextView.setText("Bạn đang xem nghĩa của từ " + vocab.term);

        // Hiển thị nghĩa
        TextView defTextView = rootView.findViewById(R.id.defTextView);
        defTextView.setText(vocab.def);

        // Hiển thị cách phát âm
        TextView ipaTextView = rootView.findViewById(R.id.ipaTextView);
        ipaTextView.setText(vocab.ipa);
        return rootView;
    }
}



