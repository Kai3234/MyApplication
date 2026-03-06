package com.example.vocab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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

        // Hiển thị nghĩa
        TextView defTextView = rootView.findViewById(R.id.defTextView);
        defTextView.setText(vocab.def);
        defTextView.setOnClickListener(v -> {
            // Hiển thị Dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());


            View dialogView = inflater.inflate(R.layout.vocab_layout, null);

            TextView dialogDefTextView = dialogView.findViewById(R.id.defTextView);

            TextView dialogIpaTextView = dialogView.findViewById(R.id.ipaTextView);


            dialogDefTextView.setText("\nBạn đang xem nghĩa của từ " + vocab.term);

            builder.setView(dialogView);

            builder.setCancelable(false);

            builder.setPositiveButton("Đóng", (dialog, which) -> dialog.dismiss());

            builder.setTitle(vocab.def);


            AlertDialog alertDialog = builder.create();

            alertDialog.show();

        });


        // Hiển thị cách phát âm
        TextView ipaTextView = rootView.findViewById(R.id.ipaTextView);
        ipaTextView.setText(vocab.ipa);


        return rootView;
    }
}
