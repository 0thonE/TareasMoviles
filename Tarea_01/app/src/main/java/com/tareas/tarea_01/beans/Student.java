package com.tareas.tarea_01.beans;

public class Student {
    private String name, book;
    private double phone;
    private boolean sports;
    private Genre genre;
    private Scholarship scholarship;

    public enum Genre{
        FEMALE, MALE
    }
    public enum Scholarship {
        HIGH_SCHOOL,
        TECHNICAL,
        BACHERLOR,
        MASTER,
        PH
    }

    public Student(){
    }

    public Student(String name, String book, double phone, boolean sports, Genre genre, Scholarship scholarship) {
        this.name = name;
        this.book = book;
        this.phone = phone;
        this.sports = sports;
        this.genre = genre;
        this.scholarship = scholarship;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public double getPhone() {
        return phone;
    }

    public void setPhone(double phone) {
        this.phone = phone;
    }

    public boolean isSports() {
        return sports;
    }

    public void setSports(boolean sports) {
        this.sports = sports;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getGenreStr() {
        String  gnre="" ;

        switch (genre){
            case MALE:
                gnre="Masculino";
                break;
            case FEMALE:
                gnre="Femenino";
                break;
        }
        return gnre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Scholarship getScholarship() {
        return scholarship;
    }

    public String getScholarshipStr() {
        String scholar="";

        switch (scholarship){
            case HIGH_SCHOOL:
                scholar="Preparatoria";
                break;
            case TECHNICAL:
                scholar="Técnico";
                break;
            case BACHERLOR:
                scholar="Licenciatura";
                break;
            case MASTER:
                scholar="Maestría";
                break;
            case PH:
                scholar="Doctorado";
                break;
        }
        return scholar;
    }

    public void setScholarship(Scholarship scholarship) {
        this.scholarship = scholarship;
    }

    public void setScholarship(int scholarship) {
        switch (scholarship){
            case 0:
                this.scholarship= Scholarship.HIGH_SCHOOL;
                break;
            case 1:
                this.scholarship= Scholarship.TECHNICAL;
                break;
            case 2:
                this.scholarship= Scholarship.BACHERLOR;
                break;
            case 3:
                this.scholarship= Scholarship.MASTER;
                break;
            case 4:
                this.scholarship= Scholarship.PH;
                break;
        }
    }

    @Override
    public String toString() {

        return "Student{" +
                "name='" + name + '\'' +
                ", book='" + book + '\'' +
                ", phone=" + phone +
                ", sports=" + sports +
                ", genre=" + getGenreStr() +
                ", scholarship=" + getScholarshipStr() +
                '}';
    }
}
