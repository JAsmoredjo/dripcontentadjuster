package com.eGoStudio.dripContentAdjuster.entity;

public class Form {
    private String folder;
    private String discNumber;
    private String albumTitle;
    private String artist;
    private String language;
    private String upc;
    private String lastISRC;
    private String releaseDate;
    private String releaseLanguage;
    private String explicit;
    private String stream;
    private String territory;
    private String genre;
    private String subGenre;
    private String label;
    private String copyright;

    public Form() {
    }

    public Form(String folder, String discNumber, String albumTitle, String artist, String language, String upc, String lastISRC, String releaseDate, String releaseLanguage, String explicit, String stream, String territory, String genre, String subGenre, String label, String copyright) {
        this.folder = folder;
        this.discNumber = discNumber;
        this.albumTitle = albumTitle;
        this.artist = artist;
        this.language = language;
        this.upc = upc;
        this.lastISRC = lastISRC;
        this.releaseDate = releaseDate;
        this.releaseLanguage = releaseLanguage;
        this.explicit = explicit;
        this.stream = stream;
        this.territory = territory;
        this.genre = genre;
        this.subGenre = subGenre;
        this.label = label;
        this.copyright = copyright;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(String discNumber) {
        this.discNumber = discNumber;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getLastISRC() {
        return lastISRC;
    }

    public void setLastISRC(String lastISRC) {
        this.lastISRC = lastISRC;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseLanguage() {
        return releaseLanguage;
    }

    public void setReleaseLanguage(String releaseLanguage) {
        this.releaseLanguage = releaseLanguage;
    }

    public String getExplicit() {
        return explicit;
    }

    public void setExplicit(String explicit) {
        this.explicit = explicit;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSubGenre() {
        return subGenre;
    }

    public void setSubGenre(String subGenre) {
        this.subGenre = subGenre;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
}
