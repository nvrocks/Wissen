package com.quiz.mnnit.wissen;

/**
 * Created by neera on 3/2/2017.
 */

public class Question {
    private int ID;
    private String QUESTION;
    private String OPTA;
    private String OPTB;
    private String OPTC;
    private String ANSWER;
    private String CATEGORY;
    private String TYPE;
    private String DIFFICULTY;



    public Question() {
        ID = 0;
        QUESTION = "";
        OPTA = "";
        OPTB = "";
        OPTC = "";
        ANSWER = "";
    }

    public Question(String qUESTION, String oPTA, String oPTB, String oPTC,
                    String aNSWER) {

        QUESTION = qUESTION;
        OPTA = oPTA;
        OPTB = oPTB;
        OPTC = oPTC;
        ANSWER = aNSWER;
    }

    public String getCATEGORY() {
        return CATEGORY;
    }

    public void setCATEGORY(String CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getDIFFICULTY() {
        return DIFFICULTY;
    }

    public void setDIFFICULTY(String DIFFICULTY) {
        this.DIFFICULTY = DIFFICULTY;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public void setQUESTION(String QUESTION) {
        this.QUESTION = QUESTION;
    }

    public String getOPTA() {
        return OPTA;
    }

    public void setOPTA(String OPTA) {
        this.OPTA = OPTA;
    }

    public String getOPTB() {
        return OPTB;
    }

    public void setOPTB(String OPTB) {
        this.OPTB = OPTB;
    }

    public String getOPTC() {
        return OPTC;
    }

    public void setOPTC(String OPTC) {
        this.OPTC = OPTC;
    }

    public String getANSWER() {
        return ANSWER;
    }

    public void setANSWER(String ANSWER) {
        this.ANSWER = ANSWER;
    }
}

