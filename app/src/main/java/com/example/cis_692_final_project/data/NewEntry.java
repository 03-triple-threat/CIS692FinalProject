package com.example.cis_692_final_project.data;

public class NewEntry {

    private int id;
    private float inputWeight;
    private String inputDate;

    public NewEntry(int id, float inputWeight, String inputDate) {
        this.id = id;
        this.inputWeight = inputWeight;
        this.inputDate = inputDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getInputWeight() {
        return inputWeight;
    }

    public void setInputWeight(float inputWeight) {
        this.inputWeight = inputWeight;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    @Override
    public String toString() {
        return "NewEntry{" +
                "id=" + id +
                ", inputWeight=" + inputWeight +
                ", inputDate='" + inputDate + '\'' +
                '}';
    }
}
