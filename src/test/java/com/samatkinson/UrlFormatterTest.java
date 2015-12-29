package com.samatkinson;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UrlFormatterTest {

    private HeightWidthGenerator heightWidthGenerator;

    @Test
    public void correctlyFormatsValidParams() throws Exception {
        heightWidthGenerator = new HeightWidthGenerator() {
            public int height() {
                return 300;
            }

            public int width() {
                return 200;
            }
        };
        UrlFormatter urlFormatter = new UrlFormatter(
                heightWidthGenerator);

        String calm = urlFormatter.getFormattedUrl("calm");
        assertThat(calm, is("https://www.placecage.com/200/300"));

        String gray = urlFormatter.getFormattedUrl("gray");
        assertThat(gray, is("https://www.placecage.com/g/200/300"));

        String crazy = urlFormatter.getFormattedUrl("crazy");
        assertThat(crazy, is("https://www.placecage.com/c/200/300"));

        String gif = urlFormatter.getFormattedUrl("gif");
        assertThat(gif, is("https://www.placecage.com/gif/200/300"));

    }

    @Test
    public void invalidCommandsReturnCalm() throws Exception {
        UrlFormatter urlFormatter = new UrlFormatter(heightWidthGenerator);

        String calm = urlFormatter.getFormattedUrl("");
        assertThat(calm, is("https://www.placecage.com/200/300"));

        calm = urlFormatter.getFormattedUrl("crazier");
        assertThat(calm, is("https://www.placecage.com/200/300"));

        calm = urlFormatter.getFormattedUrl("213");
        assertThat(calm, is("https://www.placecage.com/200/300"));

        calm = urlFormatter.getFormattedUrl("crazy and");
        assertThat(calm, is("https://www.placecage.com/200/300"));


    }
}
