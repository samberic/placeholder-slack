package com.samatkinson;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UrlFormatterTest {

    @Test
    public void correctlyFormatsValidParams() throws Exception {
        UrlFormatter urlFormatter = new UrlFormatter("calm");

        String calm = urlFormatter.getFormattedUrl();
        assertThat(calm, is("https://www.placecage.com/200/300"));

        urlFormatter = new UrlFormatter("gray");
        assertThat(urlFormatter.getFormattedUrl(), is("https://www.placecage.com/g/200/300"));

        urlFormatter = new UrlFormatter("crazy");
        assertThat(urlFormatter.getFormattedUrl(), is("https://www.placecage.com/c/200/300"));

        urlFormatter = new UrlFormatter("gif");
        assertThat(urlFormatter.getFormattedUrl(), is("https://www.placecage.com/gif/200/300"));

    }

    @Test
    public void invalidCommandsReturnCalm() throws Exception {
        UrlFormatter urlFormatter = new UrlFormatter("");
        assertThat(urlFormatter.getFormattedUrl(), is("https://www.placecage.com/200/300"));

        urlFormatter = new UrlFormatter("crazie");
        assertThat(urlFormatter.getFormattedUrl(), is("https://www.placecage.com/200/300"));

        urlFormatter = new UrlFormatter("213");
        assertThat(urlFormatter.getFormattedUrl(), is("https://www.placecage.com/200/300"));

        urlFormatter = new UrlFormatter("crazy and");
        assertThat(urlFormatter.getFormattedUrl(), is("https://www.placecage.com/200/300"));

    }

}
