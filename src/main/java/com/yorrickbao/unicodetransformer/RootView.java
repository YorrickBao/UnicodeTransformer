package com.yorrickbao.unicodetransformer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RootView implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textField.setText("");
        textField2.setText("");
    }

    @FXML
    private TextField textField;

    @FXML
    private TextField textField2;

    private final Pattern pattern = Pattern.compile("^[\\u4e00-\\u9fa5]{0,}$");
    private final Pattern pattern2 = Pattern.compile("\\\\u[\\da-fA-F]{4}");


    @FXML
    private void textFieldOnChanged() {
        textField2.setText(stringToUnicode(textField.getText()));
    }

    @FXML
    private void textField2OnChanged() {
        textField.setText(unicodeToString(textField2.getText()));
    }

    @NotNull
    private String stringToUnicode(String in) {

        char[] chars = in.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (pattern.matcher(String.valueOf(c)).find()) {
                sb.append("\\u").append(Integer.toString(c, 16).toUpperCase());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @NotNull
    private String unicodeToString(String s){
        StringBuffer sb = new StringBuffer();
        Matcher m = pattern2.matcher(s);
        while(m.find()){
            m.appendReplacement(sb, String.valueOf((char)Integer.parseInt(m.group().substring(2).toLowerCase(), 16)));
        }
        m.appendTail(sb);
        return sb.toString();
    }

}
