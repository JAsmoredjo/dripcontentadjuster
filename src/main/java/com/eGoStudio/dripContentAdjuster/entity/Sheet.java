package com.eGoStudio.dripContentAdjuster.entity;

public class Sheet {
    private String folder;
    private String action;
    private String type;
    private String discNumber;
    private String seq;
    private String title;
    private String artist;
    private String language;
    private String upcISRC;
    private String releaseDate;
    private String releaseLanguage;
    private String explicit;
    private String stream;
    private String territory;
    private String genre;
    private String subGenre;
    private String mediaType;
    private String label;
    private String copyright;
    private String deliveredBy;
    private String title2;
    private String artist2;
    private String language2;
    private String title3;
    private String artist3;
    private String language3;

    public Sheet() {
    }

    public Sheet(String folder, String action, String type, String discNumber, String seq, String title, String artist, String language, String upcISRC, String releaseDate, String releaseLanguage, String explicit, String stream, String territory, String genre, String subGenre, String mediaType, String label, String copyright, String deliveredBy, String title2, String artist2, String language2, String title3, String artist3, String language3) {
        this.folder = folder;
        this.action = action;
        this.type = type;
        this.discNumber = discNumber;
        this.seq = seq;
        this.title = title;
        this.artist = artist;
        this.language = language;
        this.upcISRC = upcISRC;
        this.releaseDate = releaseDate;
        this.releaseLanguage = releaseLanguage;
        this.explicit = explicit;
        this.stream = stream;
        this.territory = territory;
        this.genre = genre;
        this.subGenre = subGenre;
        this.mediaType = mediaType;
        this.label = label;
        this.copyright = copyright;
        this.deliveredBy = deliveredBy;
        this.title2 = title2;
        this.artist2 = artist2;
        this.language2 = language2;
        this.title3 = title3;
        this.artist3 = artist3;
        this.language3 = language3;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(String discNumber) {
        this.discNumber = discNumber;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getUpcISRC() {
        return upcISRC;
    }

    public void setUpcISRC(String upcISRC) {
        this.upcISRC = upcISRC;
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

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
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

    public String getDeliveredBy() {
        return deliveredBy;
    }

    public void setDeliveredBy(String deliveredBy) {
        this.deliveredBy = deliveredBy;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getArtist2() {
        return artist2;
    }

    public void setArtist2(String artist2) {
        this.artist2 = artist2;
    }

    public String getLanguage2() {
        return language2;
    }

    public void setLanguage2(String language2) {
        this.language2 = language2;
    }

    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    public String getArtist3() {
        return artist3;
    }

    public void setArtist3(String artist3) {
        this.artist3 = artist3;
    }

    public String getLanguage3() {
        return language3;
    }

    public void setLanguage3(String language3) {
        this.language3 = language3;
    }

    @Override
    public String toString() {
        return "Sheet{" +
                "action='" + action + '\'' +
                ", type='" + type + '\'' +
                ", discNumber='" + discNumber + '\'' +
                ", seq='" + seq + '\'' +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", language='" + language + '\'' +
                ", upcISRC='" + upcISRC + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", releaseLanguage='" + releaseLanguage + '\'' +
                ", explicit='" + explicit + '\'' +
                ", stream='" + stream + '\'' +
                ", territory='" + territory + '\'' +
                ", genre='" + genre + '\'' +
                ", subGenre='" + subGenre + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", label='" + label + '\'' +
                ", copyright='" + copyright + '\'' +
                ", deliveredBy='" + deliveredBy + '\'' +
                ", title2='" + title2 + '\'' +
                ", artist2='" + artist2 + '\'' +
                ", language2='" + language2 + '\'' +
                ", title3='" + title3 + '\'' +
                ", artist3='" + artist3 + '\'' +
                ", language3='" + language3 + '\'' +
                '}';
    }
}
