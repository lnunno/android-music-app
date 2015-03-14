package com.lnunno.musicutils.echonest;

import com.echonest.api.v4.Artist;
import com.echonest.api.v4.Biography;
import com.echonest.api.v4.Blog;
import com.echonest.api.v4.EchoNestException;
import com.echonest.api.v4.Image;
import com.echonest.api.v4.Review;

import java.util.List;

import static com.lnunno.musicutils.echonest.EchoNestExampleUtils.EN;

/**
 * Created by Lucas on 1/19/2015.
 */
public class EchoNestExamples {

    private static void printDetail(String title, String text) {
        System.out.println(title + ":\n\t" + text);
    }

    public static void runArtistExample() throws EchoNestException {
        List<Artist> results = EN.searchArtists("minus the bear");
        for (Artist artist : results) {
            System.out.println(artist);
            for (Biography bio : artist.getBiographies()) {
                System.out.println("SITE:\n" + bio.getSite());
                System.out.println("LICENSE:\n" + bio.getLicenseType());
                System.out.println("TEXT:\n" + bio.getText());
            }
            for (Blog blog : artist.getBlogs()) {
                System.out.println("BLOG_TITLE:\n\t" + blog.getName());
                System.out.println("BLOG_SUMMARY:\n\t" + blog.getSummary());
            }
            for (Image image : artist.getImages()) {
                System.out.println("IMAGE:\n\t" + image.getURL());
            }
            for (Review review : artist.getReviews()) {
                printDetail("REVIEW_NAME", review.getName());
                printDetail("REVIEW_IMAGE", review.getImageURL());
                printDetail("REVIEW_SUMMARY", review.getSummary());
            }
        }
    }

    public static void main(String[] args) throws EchoNestException {
        runArtistExample();
    }

}
