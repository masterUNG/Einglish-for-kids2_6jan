package rtc.warali.jatuporn.einglishforkids;

/**
 * Created by masterUNG on 12/4/2016 AD.
 */

public class MyConstant {

    //Explicit
    private String[] qurstionStrings = new String[]{
            "Ant","Bat","Cat","Dog","Egg",
            "Fox","Goat","Hen","Ice","Jam",
            "Koala", "Lion","Monkey","Nurse",
            "Owl","Panda","Quail","Rabbit","Snake",
            "Tiger","Unicorn", "Violin","Whale",
            "Xylophone","Yak","Zeber"};


    private int[] trueAnserInts = new int[]{2,1,3,1,2,
                                            1,1,1,2,3,
                                            1,3,1,2,1,
                                            2,1,1,2,1,
                                            3,1,1,3,1,3};



    private int[][] choiceInts = new int[][]{
            {R.drawable.ka1, R.drawable.ka2, R.drawable.ka3},
            {R.drawable.kb1, R.drawable.kb2, R.drawable.kb3},
            {R.drawable.kc1, R.drawable.kc2, R.drawable.kc3},
            {R.drawable.kd1, R.drawable.kd2, R.drawable.kd3},
            {R.drawable.ke1, R.drawable.ke2, R.drawable.ke3},
            {R.drawable.kf1, R.drawable.kf2, R.drawable.kf3},
            {R.drawable.kg1, R.drawable.kg2, R.drawable.kg3},
            {R.drawable.kh1, R.drawable.kh2, R.drawable.kh3},
            {R.drawable.ki1, R.drawable.ki2, R.drawable.ki3},
            {R.drawable.kj1, R.drawable.kj2, R.drawable.kj3},
            {R.drawable.kk1, R.drawable.kk2, R.drawable.kk3},
            {R.drawable.kl1, R.drawable.kl2, R.drawable.kl3},
            {R.drawable.km1, R.drawable.km2, R.drawable.km3},
            {R.drawable.kn1, R.drawable.kn2, R.drawable.kn3},
            {R.drawable.ko1, R.drawable.ko2, R.drawable.ko3},
            {R.drawable.kp1, R.drawable.kp2, R.drawable.kp3},
            {R.drawable.kq1, R.drawable.kq2, R.drawable.kq3},
            {R.drawable.kr1, R.drawable.kr2, R.drawable.kr3},
            {R.drawable.ks1, R.drawable.ks2, R.drawable.ks3},
            {R.drawable.kt1, R.drawable.kt2, R.drawable.kt3},
            {R.drawable.ku1, R.drawable.ku2, R.drawable.ku3},
            {R.drawable.kv1, R.drawable.kv2, R.drawable.kv3},
            {R.drawable.kw1, R.drawable.kw2, R.drawable.kw3},
            {R.drawable.kx1, R.drawable.kx2, R.drawable.kx3},
            {R.drawable.ky1, R.drawable.ky2, R.drawable.ky3},
            {R.drawable.kz1, R.drawable.kz2, R.drawable.kz3}};

    public String[] getQurstionStrings() {
        return qurstionStrings;
    }

    public int[] getTrueAnserInts() {
        return trueAnserInts;
    }

    public int[][] getChoiceInts() {
        return choiceInts;
    }
}   // Main Class
