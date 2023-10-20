package com.example.calculator;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//用来存储一些数据模型
public class MyViewModel extends ViewModel {
    private MutableLiveData<String> mainNum;//主数值（用户正在操作的数）
    public boolean havePoint =false;//用于记录主数值中是否包含小数点
    public String sign1 = "",sign2 = "";//用于存储运算符号
    public String num[]={"",""};//用于存储参与计算的数值

    public MutableLiveData<String> getMainNum(){
        if (mainNum == null){
            mainNum = new MutableLiveData<>();
            mainNum.setValue("0");
        }
        return mainNum;
    }

    public void setMainNum(String n ){
        if (mainNum.getValue().equals("0")){
            mainNum.setValue(n);
        }
        else {
            mainNum.setValue(mainNum.getValue() + n);
        }
    }


    public String mainNumWithNum_0_Tocal(){
        String value = "0";
        if (mainNum.getValue().contains(".") || num[0].contains(".")) {//如果两个数的其中一个有小数点的运算
            switch (sign1){
                case "+":
                    value = String.valueOf(Double.valueOf(num[0]) + Double.valueOf(mainNum.getValue()));
                    break;
                case "-":
                    value = String.valueOf(Double.valueOf(num[0]) - Double.valueOf(mainNum.getValue()));
                    break;
                case "*":
                    value = String.valueOf(Double.valueOf(num[0]) * Double.valueOf(mainNum.getValue()));
                    break;
                case "/":
                    if (mainNum.getValue().equals("0")){
                        mainNum.setValue("1");
                    }
                    value = String.valueOf(Double.valueOf(num[0]) / Double.valueOf(mainNum.getValue()));
                    break;
                case "%":
                    value = String.valueOf(Double.valueOf(num[0]) % Double.valueOf(mainNum.getValue()));
                    break;
            }
        }
        else {
            switch (sign1){//如果没有小数点则为整数运算
                case "+":
                    value = String.valueOf(Integer.valueOf(num[0]) + Integer.valueOf(mainNum.getValue()));
                    break;
                case "-":
                    value = String.valueOf(Integer.valueOf(num[0]) - Integer.valueOf(mainNum.getValue()));
                    break;
                case "*":
                    value = String.valueOf(Integer.valueOf(num[0]) * Integer.valueOf(mainNum.getValue()));
                    break;
                case "/"://除号依旧为小数运算方式
                    if (mainNum.getValue().equals("0")){
                        mainNum.setValue("1");
                    }
                    value = String.valueOf(Double.valueOf(num[0]) / Double.valueOf(mainNum.getValue()));
                    break;
                 case "%":
                    value = String.valueOf(Integer.valueOf(num[0]) % Integer.valueOf(mainNum.getValue()));
            }
        }
        return value;
    }

   public String mainNumWith_Num_1_Tocal(){
        String value = "0";
        if (mainNum.getValue().contains(".") || num[0].contains(".")) {//如果两个数的其中一个有小数点的运算
            switch (sign2){
                case "*":
                    value = String.valueOf(Double.valueOf(num[1]) * Double.valueOf(mainNum.getValue()));
                    break;
                case "/":
                    if (mainNum.getValue().equals("0")){
                        mainNum.setValue("1");
                    }
                    value = String.valueOf(Double.valueOf(num[1]) / Double.valueOf(mainNum.getValue()));
                    break;
                case "%":
                    value = String.valueOf(Double.valueOf(num[1]) % Double.valueOf(mainNum.getValue()));
            }
        }
        else {
            switch (sign2){//如果没有小数点则为整数运算
                case "*":
                    value = String.valueOf(Integer.valueOf(num[1]) * Integer.valueOf(mainNum.getValue()));
                    break;
                case "/"://除号依旧为小数运算方式
                    if (mainNum.getValue().equals("0")){
                        mainNum.setValue("1");
                    }
                    value = String.valueOf(Double.valueOf(num[1]) / Double.valueOf(mainNum.getValue()));
                    break;
                case "%":
                    value = String.valueOf(Integer.valueOf(num[1]) % Integer.valueOf(mainNum.getValue()));
            }
        }
        return value;
    }

}

